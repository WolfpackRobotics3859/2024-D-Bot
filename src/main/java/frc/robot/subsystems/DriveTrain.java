// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {

  private WPI_VictorSPX motorLeft1 = new WPI_VictorSPX(Constants.MOTORS.MOTOR_LEFT_1_ID);
  private WPI_VictorSPX motorLeft2 = new WPI_VictorSPX(Constants.MOTORS.MOTOR_LEFT_2_ID);
  private WPI_VictorSPX motorRight1 = new WPI_VictorSPX(Constants.MOTORS.MOTOR_RIGHT_1_ID);
  private WPI_VictorSPX motorRight2 = new WPI_VictorSPX(Constants.MOTORS.MOTOR_RIGHT_2_ID);

  /** Creates a new DriveTrain. */
  public DriveTrain() {
    motorLeft1.configFactoryDefault();
    motorLeft2.configFactoryDefault();
    motorRight1.configFactoryDefault();
    motorRight2.configFactoryDefault();
    motorLeft2.setInverted(false);
    motorLeft1.setInverted(false);
    motorRight1.setInverted(true);
  }

  @Override
  public void periodic() {}

  public void setLeftMotors(double speed) {
    motorLeft1.set(ControlMode.PercentOutput, speed);
    motorLeft2.set(ControlMode.PercentOutput, speed);
    SmartDashboard.putNumber("Left Speed", speed);
  }

  public void setRightMotors(double speed) {
    motorRight1.set(ControlMode.PercentOutput, speed);
    motorRight2.set(ControlMode.PercentOutput, speed);
    SmartDashboard.putNumber("Right Speed", speed);
  }
}
