package org.usfirst.frc.team1155.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;
	
	public static int leftFront = 1;
	public static int leftBack = 2;
	public static int rightFront = 3;
	public static int rightBack = 4; 
	
	public static int climb = 5;
	public static int climb0 = 6;
	
	public static int climbMotor = 7;
	public static int climbMotor0 = 8;
	
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
