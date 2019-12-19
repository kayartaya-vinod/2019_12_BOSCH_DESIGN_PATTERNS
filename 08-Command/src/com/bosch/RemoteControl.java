package com.bosch;

import com.bosch.commands.Command;
import com.bosch.commands.DownCommand;
import com.bosch.commands.SwitchOffCommand;
import com.bosch.commands.SwitchOnCommand;
import com.bosch.commands.UpCommand;
import com.bosch.devices.ElectronicDevice;

public class RemoteControl {

	private Command switchOnCommand;
	private Command switchOffCommand;
	private Command upCommand;
	private Command downCommand;

	public RemoteControl(ElectronicDevice device) {
		switchOnCommand = new SwitchOnCommand(device);
		switchOffCommand = new SwitchOffCommand(device);
		upCommand = new UpCommand(device);
		downCommand = new DownCommand(device);
	}

	public void changeDevice(ElectronicDevice device) {
		switchOnCommand = new SwitchOnCommand(device);
		switchOffCommand = new SwitchOffCommand(device);
		upCommand = new UpCommand(device);
		downCommand = new DownCommand(device);
	}

	public void on() {
		switchOnCommand.execute();
	}

	public void off() {
		switchOffCommand.execute();
	}

	public void up() {
		upCommand.execute();
	}

	public void down() {
		downCommand.execute();
	}

}
