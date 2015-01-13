package deck;

import entity.Player;
import fields.GameBoard;

public class Movetofleetcard extends Movecard{
	private int newposition;

	public Movetofleetcard(String message, GameBoard board) {
		super(message, board);
	}

	@Override
	public void drawCard(Player player) {
		if (player.getPosition() >= 35 && player.getPosition() < 5) {
			newposition = 5;
			if (player.getPosition() <= 39)
				player.passStart();
		}
		else if (player.getPosition() >= 25 && player.getPosition() < 35) {
			newposition = 35;
		}
		else if (player.getPosition() >= 15 && player.getPosition() < 25) {
			newposition = 25;
		}
		else if (player.getPosition() >= 5 && player.getPosition() < 15) {
			newposition = 15;
		}
		player.setPosition(newposition);
	}
	

}
