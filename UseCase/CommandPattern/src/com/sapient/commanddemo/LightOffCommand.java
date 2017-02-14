package com.sapient.commanddemo;

//Concrete Command
public class LightOffCommand implements Command {
	private Light light;

	public void setLight(Light light) {
		this.light = light;
	}
    @Override
	public void execute() {
		light.off();

	}
}
