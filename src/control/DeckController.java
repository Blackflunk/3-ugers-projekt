package control;
import boundary.GUIcontroller;
import deck.Deck;
import fields.GameBoard;
import game.Player;

public class DeckController {
	private GUIcontroller GUIC = new GUIcontroller();
	private Player[] playerlist;
	private GameBoard board;
	private Deck deck = new Deck(playerlist, board);
	private FieldController FC;
	private int decklength = 30;
	private int cardsdrawned= 0;
	
	
	
	public DeckController(Deck deck, GUIcontroller GUIC, Player[] playerlist, GameBoard board, FieldController FC) {
		this.GUIC = GUIC;
		this.playerlist = playerlist;
		this.board = board;
		this.deck = deck;
		this.FC = FC;
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
