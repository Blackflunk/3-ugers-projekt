package deck;
import game.Player;

public class Giftcard extends Recievecard {
	private Player[] playerlist;

	public Giftcard(String message, int bonus, Player[] playerlist) {
		super(message, 0);
		this.playerlist = playerlist;
	}
	
	public void drawcard(Player player) {
		for (int i=0; i < playerlist.length; i++) {
			if (player!=playerlist[i])
				playerlist[i].account.addPoints(-bonus);
		}
		player.account.addPoints(bonus*(playerlist.length-1));
	}
	
	
	
	

}
