package org.usfirst.frc.team1155.robot;

import edu.wpi.first.wpilibj.I2C;

public class RioDuinoController {
	private I2C i2cBus;
	String rioDuinoDrive;
	public RioDuinoController()
	{
		i2cBus = new I2C(I2C.Port.kMXP, 4);
	}
	public void sendChange(String state, int alliance)
	{
		byte[] toSend = new byte[1];
		switch(state)
		{
		case("test"):
			toSend[0] = (byte) ((1 << 1) | alliance);
			break;
		case("auto"):
			toSend[0] = (byte) ((2 << 1) | alliance);
			break;
		case("climb"):
			toSend[0] = (byte) ((3 << 1) | alliance);
			break;
		}
		i2cBus.transaction(toSend, 1, null, 0);
	}
}
