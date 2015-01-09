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
		GUIC.showMessage(deck.getMessage());
		deck.drawCard(player);
		cardsdrawned++;
		if (cardsdrawned >=decklength)
			deck.shuffleDeck();
	}
	

}
