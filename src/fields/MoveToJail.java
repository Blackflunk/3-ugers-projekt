package fields;

import game.Player;

public class MoveToJail extends Fields {
	
	public MoveToJail(String name) {
		super(name);
	}

	@Override
	public void landOnField(Player player){
		player.setJailed(true);
		player.setPosition(10);
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
