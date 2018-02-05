package org.usfirst.frc.team1155.robot.subsystems;

import org.usfirst.frc.team1155.robot.Robot;
import org.usfirst.frc.team1155.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LiftSubsystem extends Subsystem 
{
	
	private int maxHeight = 1;
	private int setHeight = 1;
	private TalonSRX LF;
	private TalonSRX LB;
	private TalonSRX RF;
	private TalonSRX RB;
	private int tick;
	private Encoder liftEncoder;
	@Override
	protected void initDefaultCommand() 
	{
		LF = new TalonSRX(RobotMap.leftFront);
		RF = new TalonSRX(RobotMap.rightFront);
		LB = new TalonSRX(RobotMap.leftBack);
		RB = new TalonSRX(RobotMap.rightBack);
		liftEncoder = new Encoder(1, 2);
		tick = liftEncoder.get();
		stop();
	}
	
	public void stop()
	{
		LF.set(ControlMode.PercentOutput, 0);
		LB.set(ControlMode.PercentOutput, 0);
		RF.set(ControlMode.PercentOutput, 0);
		RB.set(ControlMode.PercentOutput, 0);
	}
	
	public void LiftMax()
	{
		while(tick < maxHeight)
		{
			LF.set(ControlMode.PercentOutput, 1);
			LB.set(ControlMode.PercentOutput, 1);
			RF.set(ControlMode.PercentOutput, -1);
			RB.set(ControlMode.PercentOutput, -1);
			tick = liftEncoder.get();
		}
		stop();
	}
	
	public void LiftSet()
	{
		while(tick < setHeight)
		{
			LF.set(ControlMode.PercentOutput, 1);
			LB.set(ControlMode.PercentOutput, 1);
			RF.set(ControlMode.PercentOutput, -1);
			RB.set(ControlMode.PercentOutput, -1);
			tick = liftEncoder.get();
		}
		stop();
	}
	public void retract()
	{
		while(tick > 0)
		{
			LF.set(ControlMode.PercentOutput, -1);
			LB.set(ControlMode.PercentOutput, -1);
			RF.set(ControlMode.PercentOutput, 1);
			RB.set(ControlMode.PercentOutput, 1);
			tick = liftEncoder.get();
		}
		stop();
	}
	public boolean changeState(boolean up)
	{
		if(up)
		{
			Robot.liftSubsystem.retract();
			return false;
		} else
		{
			Robot.liftSubsystem.LiftMax();
			return true;
		}
	}
}
