package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.OI;
import org.usfirst.frc.team1155.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

public class ClimbCommand extends Command {
	boolean isDown = true;
	
	private Button b = new JoystickButton(OI.stick, 5);
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return !isDown;
	}
	
	protected void execute()
	{
		if(b.get())
		{
			isDown = false;
		}
		if(!isDown)
		{
			Robot.climbSubsystem.climb();
		}
	}
	
}
