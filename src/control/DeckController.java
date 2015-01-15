package control;
import boundary.GUIcontroller;
import deck.Card;
import deck.Deck;
import deck.Movecard;
import entity.Player;
import fields.GameBoard;

public class DeckController {
	private GUIcontroller GUIC = new GUIcontroller();
	private Deck deck;
	private FieldController FC;
	private Player[] playerlist;
	private int decklength = 30;
	private int cardsdrawned= 0;
	
	
	
	public DeckController(GUIcontroller GUIC, Player[] playerlist, GameBoard board, FieldController FC) {
		this.GUIC = GUIC;
		this.playerlist = playerlist;
		this.deck = new Deck(playerlist, board);
		this.FC = FC;
		shuffleDeck();
	}
	
	public void drawCard(int currentPlayer) {
		GUIC.showMessage(deck.getMessage(0));
		Card temp = deck.drawCard(playerlist[currentPlayer]);
		cardsdrawned++;
		GUIC.newPositon(playerlist[currentPlayer]);
		if (cardsdrawned >=decklength) {
			deck.shuffleDeck();
			cardsdrawned = 0;
		}
		if (temp instanceof Movecard)
			FC.landOnField(currentPlayer);
		// ektra update på GUI
		GUIC.updateBalance(playerlist[currentPlayer].getName(), playerlist[currentPlayer].account.getScore());
	}
	public void shuffleDeck() {
		deck.shuffleDeck();
	}
	public void pickCard(Player player, int cardnumber) {
		GUIC.showMessage(deck.getMessage(cardnumber));
		deck.pickCard(player, cardnumber);
		GUIC.newPositon(player);
	}
	

}
