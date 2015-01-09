package deck;
import game.Player;
public abstract class Card {
	
	private String message;
	
	public Card(String message) {
		this.message = message;
	}
	
	public abstract void drawCard(Player player);
	
	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return message;
	}

}
