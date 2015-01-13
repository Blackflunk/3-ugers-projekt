package deck;
import entity.Player;
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
		// control for Chancecard on field 2
		if (player.getPosition() ==2)
			player.setPosition(39);
		else
			player.setPosition(player.getPosition()+moveammount);
		
	}

}
