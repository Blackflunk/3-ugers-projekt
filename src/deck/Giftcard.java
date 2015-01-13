package deck;
import entity.Player;

public class Giftcard extends Recievecard {
	private Player[] playerlist;

	public Giftcard(String message, int bonus, Player[] playerlist) {
		super(message, bonus);
		this.playerlist = playerlist;
	}
	
	public void drawcard(Player player) {
		for (int i=0; i < playerlist.length; i++) {
			boolean t = player.equals(playerlist[i]);
			if (!t)
				playerlist[i].account.addPoints(-bonus);
		}
		player.account.addPoints(bonus*(playerlist.length-1));
	}
	
	
	
	

}
