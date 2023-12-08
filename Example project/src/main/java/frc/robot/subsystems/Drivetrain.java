// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.DoubleSubscriber;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants.DriveConstants;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */

  private final MecanumDrive _drive;
  
  private final CANSparkMax _front_left_motor; 
  private final CANSparkMax _front_right_motor; 
  private final CANSparkMax _back_left_motor; 
  private final CANSparkMax _back_right_motor; 

  private static Drivetrain _instance = null;

  public static Drivetrain getInstance() {
    if (_instance == null) {
      _instance = new Drivetrain();
    }
    return _instance;
  }

  private Drivetrain() {
    _front_left_motor = new CANSparkMax(DriveConstants.FRONT_LEFT, MotorType.kBrushless);
    _front_right_motor = new CANSparkMax(DriveConstants.FRONT_RIGHT, MotorType.kBrushless);
    _back_left_motor = new CANSparkMax(DriveConstants.BACK_LEFT, MotorType.kBrushless);
    _back_right_motor = new CANSparkMax(DriveConstants.BACK_RIGHT, MotorType.kBrushless);

    _drive =  new MecanumDrive(_front_right_motor, _front_left_motor, _back_right_motor, _back_left_motor);
    _front_left_motor.setInverted(false);
    _back_left_motor.setInverted(false);
    _back_right_motor.setInverted(true);
    _front_right_motor.setInverted(true);
  }

  public void cartesianDrive( double x, double y, double z) {
    _drive.driveCartesian(x, y, z);
  }



  @Override
  public void periodic() {
    // _drive.driveCartesian(m_stick.getX(), m_stick.getY(), m_stick.getZ());
    // This method will be called once per scheduler run
  }
}
