package control;
import boundary.GUIcontroller;
import deck.Deck;
import entity.Player;
import fields.GameBoard;

public class DeckController {
	private GUIcontroller GUIC = new GUIcontroller();
	private Deck deck;
	private FieldController FC;
	private int decklength = 30;
	private int cardsdrawned= 0;
	
	
	
	public DeckController(Deck deck, GUIcontroller GUIC, Player[] playerlist, GameBoard board) {
		this.GUIC = GUIC;
		this.deck = new Deck(playerlist, board);
		FC = new FieldController(GUIC, board, playerlist, deck);
		shuffleDeck();
	}
	
	public void drawCard(Player[] playerlist, int currentPlayer) {
		GUIC.showMessage(deck.getMessage(0));
		deck.drawCard(playerlist[currentPlayer]);
		cardsdrawned++;
		GUIC.newPositon(playerlist[currentPlayer]);
		if (cardsdrawned >=decklength) {
			deck.shuffleDeck();
			cardsdrawned = 0;
		}
		FC.landOnField(playerlist, currentPlayer);
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
