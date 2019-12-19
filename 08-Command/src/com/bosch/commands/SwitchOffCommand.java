package com.bosch.commands;

import com.bosch.devices.ElectronicDevice;

public class SwitchOffCommand implements Command {
	
	// a command object HAS-A electronic device, 
	// upon which it operates.
	
	private ElectronicDevice device;
	
	public SwitchOffCommand(ElectronicDevice device) {
		this.device = device;
	}

	@Override
	public void execute() {
		device.switchOff();
	}

}
