/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
                                             
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSub;
import frc.robot.subsystems.IndexSub;
import frc.robot.subsystems.LeftShooterSubPID;
import frc.robot.subsystems.RightShooterSubPID;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AutoCenterStart extends SequentialCommandGroup {
  /**
   * Creates a new AutoCenterStart.
   */
  public AutoCenterStart(DriveSub driveSub, double distance, LeftShooterSubPID shooterLeft, RightShooterSubPID shooterRight, IndexSub indexSub) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(
      new DriveStraight(driveSub, RobotContainer.Shooter, -3.0).withTimeout(.2),
      new DriveStraight(driveSub, RobotContainer.Shooter, 3.0).withTimeout(.2),
      // new ReverseIndex(indexSub).withTimeout(.5),
      new RunShooter(RobotContainer.Shooter, shooterLeft, shooterRight, indexSub).withTimeout(3),
      new DriveStraight(driveSub, RobotContainer.Shooter, distance).withTimeout(1)
    );
  }
}
