// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class MoveToTarget extends CommandBase {
  private final DriveTrain driveTrain;
  
  public MoveToTarget(DriveTrain driveTrain) {
    this.driveTrain = driveTrain;
    addRequirements(driveTrain);
  }

  @Override
  public void initialize() {
    System.out.println("MoveToTarget cmd started");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    final double STEER_K = 0.03;
    final double DRIVE_K = 0.26;
    final double DESIRED_TARGET_AREA = 13.0;
    final double MAX_SPEED = 0.4;  

    double tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
    double tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
    double ta = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);

    if (tv < 1){
      driveTrain.setLeftMotors(0);
      driveTrain.setRightMotors(0);
      return;
    }

    double turn = tx * STEER_K;
    double drive = (DESIRED_TARGET_AREA - ta) * DRIVE_K;

    if (drive > MAX_SPEED){
      drive = MAX_SPEED;
    }

    if (turn > MAX_SPEED){
      turn = MAX_SPEED;
    }

    double left = drive + turn;
    double right = drive - turn;

    driveTrain.setLeftMotors(left);
    driveTrain.setRightMotors(right);
  }

  @Override
  public void end(boolean interrupted) {
    driveTrain.setLeftMotors(0);
    driveTrain.setLeftMotors(0);
    System.out.println("MoveToTarget cmd ended");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
