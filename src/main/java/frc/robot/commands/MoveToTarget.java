// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import org.photonvision.PhotonUtils;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
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
    var result = RobotContainer.camera.getLatestResult();

    if(result.hasTargets()){
      result.getBestTarget();
      
      double range = PhotonUtils.calculateDistanceToTargetMeters(
        Constants.CAMERA.CAMERA_HEIGHT_METERS,
        Constants.CAMERA.TARGET_HEIGHT_METERS,
        Constants.CAMERA.CAMERA_PITCH_RADIANS,
        Units.degreesToRadians(result.getBestTarget().getPitch())
      );
      
      SmartDashboard.putNumber("Range to Target", range);
      SmartDashboard.putNumber("Target ID", result.getBestTarget().getFiducialId());

      if (range > 1.5){
        driveTrain.setRightMotors(0.5);
        driveTrain.setLeftMotors(0.5);
      }
    } 
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
