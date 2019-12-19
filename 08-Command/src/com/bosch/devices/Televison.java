package com.bosch.devices;

// Television is a receiver of a command object
// RemoteControl is a sender (or issuer) of a command object
public class Televison implements ElectronicDevice {

	@Override
	public void switchOn() {
		System.out.println("Television switched ON");
	}

	@Override
	public void switchOff() {
		System.out.println("Television switched OFF");
	}

	@Override
	public void up() {
		System.out.println("Television volume UP");
	}

	@Override
	public void down() {
		System.out.println("Television volume DOWN");
	}

}
