package com.sapient.commands;

import com.sapient.receiver.Door;

public class DoorOpenCommand implements Command {
	private Door door;

	public DoorOpenCommand(Door door) {
		this.door = door;
	}

	@Override
	public void execute() {
		door.open();

	}

	@Override
	public void undo() {
		door.close();

	}

}
