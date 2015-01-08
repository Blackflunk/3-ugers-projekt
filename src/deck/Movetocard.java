package deck;

import game.Player;

public class Movetocard extends Movecard {
	private int newposition;

	public Movetocard(String message, int newposition) {
		super(message);
		this.newposition = newposition;
	}

	@Override
	public void drawCard(Player player) {
		player.setPosition(newposition);
	}
	
	
	

}
