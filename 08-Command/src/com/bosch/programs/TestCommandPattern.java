package com.bosch.programs;

import com.bosch.RemoteControl;
import com.bosch.devices.AirCooler;
import com.bosch.devices.Televison;

public class TestCommandPattern {

	public static void main(String[] args) {
		
		Televison tv = new Televison();
		AirCooler ac = new AirCooler();
		
		RemoteControl rc = new RemoteControl(tv);
		rc.on();
		rc.up();
		rc.down();
		rc.off();
		
		System.out.println();
		
		rc.changeDevice(ac);
		rc.on();
		rc.up();
		rc.down();
		rc.off();
		
		
	}
}
