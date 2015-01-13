package fields;

import game.Player;

public class Start extends Fields { 

	public Start(String name) {
		super(name);
	}

	@Override
	public void landOnField(Player player) {
	}
	@Override
	public String toString() {
		return "Type: Start --- Name: " + name + "\n";
	}

}
