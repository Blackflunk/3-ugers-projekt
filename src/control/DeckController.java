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
	private int decklength = 30;
	private int cardsdrawned= 0;
	
	
	
	public DeckController(Deck deck, GUIcontroller GUIC, Player[] playerlist, GameBoard board) {
		this.GUIC = GUIC;
		this.playerlist = playerlist;
		this.board = board;
		this.deck = deck;
	}
	
	public void drawCard(Player player) {
		GUIC.showMessage(deck.getMessage(0));
		deck.drawCard(player);
		cardsdrawned++;
		GUIC.newPositon(player);
		if (cardsdrawned >=decklength)
			deck.shuffleDeck();
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
