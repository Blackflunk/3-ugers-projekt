package fields;

import entity.Player;

public class Start extends Field { 

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
