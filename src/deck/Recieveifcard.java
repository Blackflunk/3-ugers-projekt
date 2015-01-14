package deck;
import entity.Player;
import fields.GameBoard;

public class Recieveifcard extends Recievecard{
	private int maxvalue;
	private GameBoard board;

	public Recieveifcard(String message, int bonus, int maxvalue, GameBoard board) {
		super(message, bonus);
		this.maxvalue = maxvalue;
		this.bonus = bonus;
		this.board = board;
	}
	
	public void drawCard(Player player) {
		int totalworth;
		int ownableworth = 0;
		int buildingworth = 0;
		for (int i=0; i<40;i++) {
			if (player.equals(board.getField(i).getOwner())) {
				ownableworth += board.getField(i).getPrice();
				buildingworth += (board.getField(i).getNumberofhouses() * board.getField(i).getHouseprice());
			}		
		}
		totalworth = player.account.getScore() + ownableworth + buildingworth; 
		if (totalworth <= maxvalue)
			player.account.addPoints(bonus);
	}
}
