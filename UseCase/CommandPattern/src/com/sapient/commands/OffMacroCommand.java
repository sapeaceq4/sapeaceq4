package com.sapient.commands;

public class OffMacroCommand implements Command {
	Command[] commands;

	public OffMacroCommand(Command[] commands) {
		this.commands = commands;
	}

	@Override
	public void execute() {
		for (Command command : commands)
			command.execute();

	}

	@Override
	public void undo() {
		for (Command command : commands)
			command.undo();
	}

}
