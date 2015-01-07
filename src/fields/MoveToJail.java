package fields;

import game.Player;

public class MoveToJail extends Fields {
	
	public MoveToJail() {
		
	}

	@Override
	public void landOnField(Player player){
		player.setJailed(true);
		player.setPosition(11);
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
