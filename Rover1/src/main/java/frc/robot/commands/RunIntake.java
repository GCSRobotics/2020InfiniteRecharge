/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.Timer;

import com.ctre.phoenix.time.StopWatch;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSub;

public class RunIntake extends CommandBase {
  private final IntakeSub intakeSub;
  private StopWatch stopWatch;

  /**
   * Creates a new RunIntake.
    */
  public RunIntake(IntakeSub subsystem ) {
    intakeSub = subsystem;
    
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is; initially scheduled.
  @Override
  public void initialize() {
    stopWatch = new StopWatch();
    stopWatch.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intakeSub.runIntake();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intakeSub.stopIntake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (stopWatch.getDuration() > 10.0) {
      return true;
    }
    return false;
  }
}
