package com.bosch.devices;

public class AirCooler implements ElectronicDevice {

	@Override
	public void switchOn() {
		System.out.println("Air cooler switched ON");
	}

	@Override
	public void switchOff() {
		System.out.println("Air cooler switched OFF");
	}

	@Override
	public void up() {
		System.out.println("Air cooler temperature UP");
	}

	@Override
	public void down() {
		System.out.println("Air cooler temperature DOWN");
	}

}
