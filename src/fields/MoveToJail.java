package fields;

import entity.Player;

public class MoveToJail extends Field {
	
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
