package deck;
import game.Player;
import fields.GameBoard;

public class Moveammountcard extends Movecard{
	private int moveammount;
	
	public Moveammountcard(String message, int moveammount, GameBoard board) {
		super(message, board);
		this.moveammount = moveammount;
	}
	
	@Override
	public void drawCard(Player player) {
		if (player.getPosition()+moveammount<39)
			player.passStart();
		player.setPosition(player.getPosition()+moveammount);
		
	}

}
