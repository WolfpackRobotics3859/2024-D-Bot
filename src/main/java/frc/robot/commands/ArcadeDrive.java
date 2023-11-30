// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class ArcadeDrive extends CommandBase {
  private final DriveTrain driveTrain;
  private final Supplier<Double> speedFunction, turnFunction;
  
  public ArcadeDrive(DriveTrain driveTrain, Supplier<Double> speedFunction, Supplier<Double> turnFunction) {
    this.driveTrain = driveTrain;
    this.speedFunction = speedFunction;
    this.turnFunction = turnFunction;
    addRequirements(driveTrain);
  }

  @Override
  public void initialize() {
    System.out.println("ArcadeDrive cmd started");
  }

  @Override
  public void execute() {
    double realTimeSpeed = speedFunction.get();
    double realTimeTurn = turnFunction.get();

    double left = realTimeSpeed + realTimeTurn;
    double right = realTimeSpeed - realTimeTurn;

    SmartDashboard.putNumber("Right", right);
    SmartDashboard.putNumber("Left", left);

    driveTrain.setLeftMotors(left*0.75);
    driveTrain.setRightMotors(right*0.75);
  }

  @Override
  public void end(boolean interrupted) {
    System.out.println("ArcadeDrive cmd ended");
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
