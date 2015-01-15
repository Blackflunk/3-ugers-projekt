package deck;

import entity.Player;

public class QueensCard extends Card{

	public QueensCard(String message) {
		super(message);
	}

	@Override
	public void drawCard(Player player) {
		player.setOutofjailcard(true);		
	}

}
