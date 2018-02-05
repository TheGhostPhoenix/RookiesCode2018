package org.usfirst.frc.team1155.robot.subsystems;

import org.usfirst.frc.team1155.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ClimbSubsystem extends Subsystem {
	private TalonSRX climb;
	private TalonSRX climb0;
	private DoubleSolenoid piston;
	private DoubleSolenoid piston0;
	private int climbMax = 1;
	private int climbMin = -1;
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		climb = new TalonSRX(RobotMap.climbMotor);
		climb0 = new TalonSRX(RobotMap.climbMotor0);
		piston = new DoubleSolenoid(RobotMap.climb, 0);
		piston0 = new DoubleSolenoid(RobotMap.climb0, 0);
		piston.set(Value.kForward);
		piston0.set(Value.kForward);
	}
	
	public void climb()
	{
		piston.set(Value.kReverse);
		piston0.set(Value.kReverse);
		climb.set(ControlMode.PercentOutput, -1);
		climb0.set(ControlMode.PercentOutput, 1);
	}
}
