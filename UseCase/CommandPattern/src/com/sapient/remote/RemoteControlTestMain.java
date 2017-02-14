package com.sapient.remote;

import com.sapient.commands.Command;
import com.sapient.commands.DoorCloseCommand;
import com.sapient.commands.DoorOpenCommand;
import com.sapient.commands.LightOffCommand;
import com.sapient.commands.LightOnCommand;
import com.sapient.commands.OffMacroCommand;
import com.sapient.commands.OnMacroCommand;
import com.sapient.commands.TVOffCommand;
import com.sapient.commands.TVOnCommand;
import com.sapient.receiver.Door;
import com.sapient.receiver.Light;
import com.sapient.receiver.TV;

public class RemoteControlTestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// instantiate Remote
		RemoteControl remoteControl = new RemoteControl();
		
		//Instantiate receiver classes 
		Light light = new Light();
		Door door = new Door();
		TV tv = new TV();
		// instantiate commands
		LightOnCommand lightOnCommand = new LightOnCommand(light);
		LightOffCommand lightOffCommand = new LightOffCommand(light);
		TVOnCommand tvOnCommand = new TVOnCommand(tv);
		TVOffCommand tvOffCommand = new TVOffCommand(tv);
		DoorOpenCommand doorOpenCommand = new DoorOpenCommand(door);
		DoorCloseCommand doorCloseCommand = new DoorCloseCommand(door);
		
		// setting command respective to buttons
		remoteControl.setCommand(0, lightOnCommand, lightOffCommand);
		remoteControl.setCommand(1, tvOnCommand, tvOffCommand);
		remoteControl.setCommand(2, doorOpenCommand, doorCloseCommand);
		// invoking an action
		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);
		remoteControl.onButtonWasPushed(1);
		// undo last action
		remoteControl.undoButtonWasPushed();
		
		System.out.println();
        // creating array of commands
		Command[] partyOn = { doorOpenCommand, lightOnCommand, tvOnCommand };
		Command[] partyoff = { doorCloseCommand, lightOffCommand, tvOffCommand };
		// creating macro on and off commands
		OnMacroCommand onMacroCommand = new OnMacroCommand(partyOn);
		OffMacroCommand offMacroCommand = new OffMacroCommand(partyoff);
		remoteControl.setCommand(3, onMacroCommand, offMacroCommand);
		// invoking action
		remoteControl.onButtonWasPushed(3);
		remoteControl.undoButtonWasPushed();
	}

}
