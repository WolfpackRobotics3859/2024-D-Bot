// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.util.Units;


public final class Constants {

  public static class MOTORS {
    public static final int MOTOR_LEFT_1_ID = 1;
    public static final int MOTOR_LEFT_2_ID = 3;
    public static final int MOTOR_RIGHT_1_ID = 2;
    public static final int MOTOR_RIGHT_2_ID = 4;
  }

  public static class CONTROLLERS {
    public static final int DRIVER_CONTROLLER = 0;
  }

  public static class CAMERA {
    public static double CAMERA_HEIGHT_METERS = Units.inchesToMeters(24);
    public static double TARGET_HEIGHT_METERS = Units.feetToMeters(5);
    public static double CAMERA_PITCH_RADIANS = Units.degreesToRadians(0);
  }
}
