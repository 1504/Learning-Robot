// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class Cartesian extends CommandBase {

  private final DoubleSupplier _ySpeed;
  private final DoubleSupplier _xSpeed;
  private final DoubleSupplier _zRotation;
  private final Drivetrain m_drivetrain = Drivetrain.getInstance();
  /** Creates a new Cartesian. */
  public Cartesian(DoubleSupplier x, DoubleSupplier y, DoubleSupplier z) {
    // Use addRequirements() here to declare subsystem dependencies.
    _xSpeed = x;
    _ySpeed = y;
    _zRotation = z;

    addRequirements(m_drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.cartesianDrive(_xSpeed.getAsDouble(), _ySpeed.getAsDouble(), _zRotation.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
