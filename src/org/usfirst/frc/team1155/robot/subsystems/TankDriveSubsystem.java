package org.usfirst.frc.team1155.robot.subsystems;

import org.usfirst.frc.team1155.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class TankDriveSubsystem extends Subsystem {
	
	private TalonSRX L0;
	private TalonSRX L1;
	private TalonSRX L2;
	private TalonSRX R0;
	private TalonSRX R1;
	private TalonSRX R2;
	private DoubleSolenoid gear;
	
	@Override
	protected void initDefaultCommand() {
		L0 = new TalonSRX(RobotMap.driveMotorL0);
		R0 = new TalonSRX(RobotMap.driveMotorR0);
		R1.follow(R0);
		R2.follow(R0);
		L1.follow(L0);
		L2.follow(L0);
		gear = new DoubleSolenoid(RobotMap.gearBox, RobotMap.gearBox0);
		brake();
		gear.set(Value.kForward);
	}
	
	public void brake()
	{
		L0.set(ControlMode.PercentOutput, 0);
		R0.set(ControlMode.PercentOutput, 0);
	}
	
	public void drive(double l, double r)
	{
		L0.set(ControlMode.PercentOutput, l);
		R0.set(ControlMode.PercentOutput, r);
	}
}
