package deck;
import game.Player;

public class Moveammountcard extends Movecard{
	private int moveammount;
	
	public Moveammountcard(String message, int moveammount) {
		super(message);
		this.moveammount = moveammount;
	}
	
	@Override
	public void drawCard(Player player) {
		player.setPosition(player.getPosition()+moveammount);
	}

}
