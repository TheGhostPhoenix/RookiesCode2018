package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.OI;
import org.usfirst.frc.team1155.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class TankDriveCommand extends Command {
	//FOR TANK AND WEST COAST DRIVE
	private Joystick L = OI.stick;
	private Joystick R = OI.stick0;
	
	public TankDriveCommand()
	{
		requires(Robot.tankSubsystem);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	protected void execute()
	{
		Robot.tankSubsystem.drive(L.getY(), R.getY());
	}
	
	@Override
	protected void end()
	{
		Robot.tankSubsystem.drive(0, 0);
	}
	
	@Override
	protected void interrupted() {
		Robot.tankSubsystem.drive(0,0);
	}
}
