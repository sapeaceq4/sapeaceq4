package com.sapient.commanddemo;

// Concrete command
public class LightOnCommand implements Command {
	private Light light;

	public void setLight(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.on();

	}

}
