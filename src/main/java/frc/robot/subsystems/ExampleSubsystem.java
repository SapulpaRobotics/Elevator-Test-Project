// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkFlexConfig;
import com.revrobotics.spark.config.SparkMaxConfig;

public class ExampleSubsystem extends SubsystemBase {

  SparkFlex elevator1 = new SparkFlex(5, MotorType.kBrushless);
  SparkFlex elevator2 = new SparkFlex(6, MotorType.kBrushless);
  SparkMax coralIntake = new SparkMax(7, MotorType.kBrushless);
  SparkFlex coralIntakeRotate = new SparkFlex(8, MotorType.kBrushless);

  SparkFlexConfig elevator1Config = new SparkFlexConfig();
  SparkFlexConfig elevator2Config = new SparkFlexConfig();
  SparkMaxConfig coralIntakeConfig = new SparkMaxConfig();
  SparkFlexConfig coralIntakeRotateConfig = new SparkFlexConfig();


  public ExampleSubsystem() {

    elevator1Config
    .inverted(false)
    .idleMode(IdleMode.kBrake);

    elevator1.configure(elevator1Config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    elevator2Config
    .inverted(false)
    .idleMode(IdleMode.kBrake)
    .follow(elevator1, true);

    elevator2.configure(elevator2Config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    coralIntakeConfig
    .inverted(false)
    .idleMode(IdleMode.kBrake);

    coralIntake.configure(coralIntakeConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    coralIntakeRotateConfig
    .inverted(false)
    .idleMode(IdleMode.kBrake);

    coralIntakeRotate.configure(coralIntakeRotateConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  //#region Control Methods

  public void setElevatorSpeed(double speed) {
    elevator1.set(speed);
  }

  public void stopElevatorSpeed() {
    elevator1.stopMotor();
  }

  public void setCoralIntakeSpeed(double speed) {
    coralIntake.set(speed);
  }

  public void stopCoralIntakeSpeed() {
    coralIntake.stopMotor();
  }

  public void setCoralIntakeRotateSpeed(double speed) {
    coralIntakeRotate.set(speed);
  }

  public void stopCoralIntakeRotateSpeed() {
    coralIntakeRotate.stopMotor();
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  public Command setElevatorSpeedCommand(double speed) {
    return Commands.runOnce(() -> setElevatorSpeed(speed));
  }

  public Command stopElevatorSpeedCommand() {
    return Commands.runOnce(() -> stopElevatorSpeed());
  }

  public Command setCoralIntakeSpeedCommand(double speed) {
    return Commands.runOnce(() -> setCoralIntakeSpeed(speed));
  }

  public Command stopCoralIntakeSpeedCommand() {
    return Commands.runOnce(() -> stopCoralIntakeSpeed());
  }

  public Command setCoralIntakeRotateSpeedCommand(double speed) {
    return Commands.runOnce(() -> setCoralIntakeRotateSpeed(speed));
  }

  public Command stopCoralIntakeRotateSpeedCommand() {
    return Commands.runOnce(() -> stopCoralIntakeRotateSpeed());
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
