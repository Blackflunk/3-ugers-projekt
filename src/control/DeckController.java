package control;
import boundary.GUIController;
import deck.Card;
import deck.Deck;
import deck.MoveCard;
import entity.Player;
import fields.GameBoard;

public class DeckController {
	private GUIController GUIC = new GUIController();
	private Deck deck;
	private Player[] playerlist;
	private FieldController FC;
	private int decklength = 30;
	private int cardsdrawned= 0;
	
	
	
	public DeckController(GUIController GUIC, Player[] playerlist, GameBoard board, FieldController FC) {
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
		GUIC.newPosition(playerlist[currentPlayer]);
		if (cardsdrawned >=decklength) {
			deck.shuffleDeck();
			cardsdrawned = 0;
		}
		if (temp instanceof MoveCard)
			FC.landOnField(currentPlayer);
		// ektra update on GUI
		GUIC.updateBalance(playerlist[currentPlayer].getName(), playerlist[currentPlayer].account.getScore());
	}
	public void shuffleDeck() {
		deck.shuffleDeck();
	}
	public void pickCard(Player player, int cardnumber) {
		GUIC.showMessage(deck.getMessage(cardnumber));
		deck.pickCard(player, cardnumber);
		GUIC.newPosition(player);
	}
	

}
