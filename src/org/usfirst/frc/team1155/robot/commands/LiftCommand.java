package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.OI;
import org.usfirst.frc.team1155.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

public class LiftCommand extends Command 
{
	public boolean isUp;
	private Button b = new JoystickButton(OI.stick, 1);
	private Button c = new JoystickButton(OI.stick, 2);
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isUp;
	}
	
	public LiftCommand()
	{
		requires(Robot.liftSubsystem);
	}
	
	protected void initialize()
	{
		Robot.liftSubsystem.retract();
		isUp = false;
	}
	protected void execute() 
	{
		if(b.get())
		{
			isUp = Robot.liftSubsystem.changeState(true);
		}
		else if(c.get())
		{
			isUp = Robot.liftSubsystem.changeState(false);
		}
	}
	
	protected void end()
	{
		
	}
	
}
