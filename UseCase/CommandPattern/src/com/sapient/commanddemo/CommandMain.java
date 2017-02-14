package com.sapient.commanddemo;

// Client
public class CommandMain {

	public static void main(String[] args) {
		// instantiate receiver
		Light light = new Light();
		// instantiate commands
		LightOnCommand lightOnCommand = new LightOnCommand();
		LightOffCommand lightOffCommand = new LightOffCommand();
		// link commands to receivers
		lightOffCommand.setLight(light);
		lightOnCommand.setLight(light);
		// instantiate invoker
		Remote remote = new Remote();
		// invoke actions
		remote.pressButton(lightOnCommand);
		remote.pressButton(lightOffCommand);

	}

}
