package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.OI;
import org.usfirst.frc.team1155.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class MecanumDriveCommand extends Command {
	
	
	
	public MecanumDriveCommand()
	{
		requires(Robot.mecanumSubsystem);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	protected void execute() {
		Robot.mecanumSubsystem.move(OI.stick.getX(), OI.stick0.getY());
	}
	
	@Override
	protected void end()
	{
		Robot.mecanumSubsystem.stop();
	}
	
	@Override
	protected void interrupted() {
		Robot.mecanumSubsystem.stop();
	}
	
}
