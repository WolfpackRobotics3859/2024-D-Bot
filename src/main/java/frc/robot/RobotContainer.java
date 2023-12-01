// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.DriveFwd;
import frc.robot.commands.MoveToTarget;
import frc.robot.subsystems.DriveTrain;

public class RobotContainer {

  //subsystems
  private final DriveTrain driveTrain = new DriveTrain();
  
  //controllers
  private final XboxController driverController = new XboxController(Constants.CONTROLLERS.DRIVER_CONTROLLER);

  //cameras

  public RobotContainer() {

    driveTrain.setDefaultCommand(
      new ArcadeDrive(driveTrain, () -> driverController.getRawAxis(1), () -> driverController.getRawAxis(4))
    );

    configureBindings();
  }

  private void configureBindings() {
    // Move to Target
    new JoystickButton(driverController, 1).whileTrue(new MoveToTarget(driveTrain));

    // DriveFWD
    new JoystickButton(driverController, 2).whileTrue(new DriveFwd(driveTrain));
    
  }

}
