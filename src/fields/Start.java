package fields;

import boundary.GUIcontroller;
import game.Player;

public class Start extends Fields {

	private String name;
	private GUIcontroller out = new GUIcontroller(); 

	public Start(String name) {
		super(name);
		this.name = name;
	}

	@Override
	public void landOnField(Player player) {
		out.startMessage(name);
	}
	@Override
	public String toString() {
		return "Type: Start --- Name: " + name + "\n";
	}

}
