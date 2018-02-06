package org.usfirst.frc.team1155.robot.subsystems;

import org.usfirst.frc.team1155.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class MecanumDriveSubsystem extends Subsystem
{
	TalonSRX leftFront, leftBack, rightFront, rightBack;
	DoubleSolenoid gear;
	
	public MecanumDriveSubsystem()
	{
		leftFront = new TalonSRX(RobotMap.driveMotorL0);
		leftBack = new TalonSRX(RobotMap.driveMotorL2);
		rightBack = new TalonSRX(RobotMap.driveMotorR0);
		rightFront = new TalonSRX(RobotMap.driveMotorR2);
		gear = new DoubleSolenoid(RobotMap.gearBox, RobotMap.gearBox0);
		gear.set(Value.kForward);
		stop();
	}
	
	@Override
	protected void initDefaultCommand() 
	{
		stop();
	}
	public void stop()
	{
		leftFront.set(ControlMode.PercentOutput, 0);
		leftBack.set(ControlMode.PercentOutput, 0);
		rightFront.set(ControlMode.PercentOutput, 0);
		rightBack.set(ControlMode.PercentOutput, 0);
	}
	public void move(double speed, double direction)
	{
		if(direction == 0)
		{
			leftFront.set(ControlMode.PercentOutput, speed);
			leftBack.set(ControlMode.PercentOutput, speed);
			rightFront.set(ControlMode.PercentOutput, speed);
			rightBack.set(ControlMode.PercentOutput, speed);
		}
		else if(direction <= 1 && direction >= -1 && speed <= 1 && speed >= -1) 
		{
			leftFront.set(ControlMode.PercentOutput, speed * direction);
			rightBack.set(ControlMode.PercentOutput, speed * direction);
			leftBack.set(ControlMode.PercentOutput, -1 * speed / direction);
			rightFront.set(ControlMode.PercentOutput, -1 * speed / direction);
		}
		else
		{
			System.out.println("Please have the values of direction and speed be between 1 and -1");
		}
	}
	
}
