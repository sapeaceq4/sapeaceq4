package com.sapient.commands;

import com.sapient.receiver.Door;

public class DoorCloseCommand implements Command {
	private Door door;

	public DoorCloseCommand(Door door) {
		this.door = door;
	}

	@Override
	public void execute() {
		door.close();

	}

	@Override
	public void undo() {
		door.open();

	}
}
