package com.sapient.commanddemo;
//Invoker Class
import java.util.ArrayList;
import java.util.List;

public class Remote {
	private List<Command> history = new ArrayList<Command>();

	public void pressButton(Command command) {
		history.add(command);
		command.execute();
	}
}
