package com.sapient.commands;

public class OnMacroCommand implements Command {
	Command[] commands;

	public OnMacroCommand(Command[] commands) {
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
