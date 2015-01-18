package deck;
import entity.Player;
import fields.GameBoard;
import java.util.Random;

public class Deck {
	private Card[] cardlist = new Card[30];
	
	public Deck(Player[] playerlist, GameBoard board){
		cardlist[0] = new MoveToCard("Ryk frem til Gr�nningen. Hvis de passerer \"Start\", indkasser da 4000kr ", 24, board);
		cardlist[1] = new MoveToFleetCard("Ryk brikken frem til det n�rmeste rederi og betal ejeren to gange den leje, "
				+ "han ellers er berettiget til, Hvis selskabet ikke ejes af nogen kan De k�be det af banken.", board);
		cardlist[2] = new MoveToCard("Ryk frem til \"Start\"", 0, board);
		cardlist[3] = new MoveAmmountCard("Ryk tre felter tilbage", -3, board);
		cardlist[4] = new MoveToCard("Ryk frem til Frederiksberg Alle. Hvis de passerer \"Start\", indkasser da 4000kr", 11, board);
		cardlist[5] = new MoveToCard("Tag med Mols-Linjen -- Flyt brikken frem og hvis de passerer \"Start\", indkasser da 4000kr", 15, board);
		cardlist[6] = new MoveToCard("Tag ind p� R�dhuspladsen", 39, board);
		cardlist[7] = new JailCard("G� i F�ngsel. Ryk direkte til faengsel. Selv om De passerer \"Start\", indkassere de ikke 4000kr", board);
		cardlist[8] = new JailCard("G� i F�ngsel. Ryk direkte til fængsel. Selv om De passerer \"Start\", indkassere de ikke 4000kr", board);
		cardlist[9] = new PayCard("Betal 3000kr for reparation af Deres vogn", 3000);
		cardlist[10] = new PropertyPayCard("Oliepriserne er steget, og de skal betale: \n 500kr pr. hus \n 2000kr pr. hotel", 500, 2000);
		cardlist[11] = new PayCard("De har m�tte vedtage en parkeringsb�de. Betal 200kr i b�de", 200);
		cardlist[12] = new PayCard("Betal deres bilforsikring p� 1000kr", 1000);
		cardlist[13] = new PayCard("Betal 3000kr for reparation af deres vogn", 3000);
		cardlist[14] = new PayCard("De har v�ret en tur i udlandet og haft for mange cigaretter med hjem. Betal told 200kr", 200);
		cardlist[15] = new PayCard("De har k�rt frem for \"Fuld Stop\". Betal 1000kr i b�de", 1000);
		cardlist[16] = new PayCard("De har modtaget Deres tandl�geregning. Betal 2000kr", 2000);
		cardlist[17] = new PropertyPayCard("Ejendomsskatterne er steget, Ekstra udgifter er: \n 800kr pr. hus \n 2300kr pr. hotel", 800, 2300);
		cardlist[18] = new RecieveCard("V�rdien af egen avl fra nyttehaven udgoer 200kr, som de modtager af banken", 200);
		cardlist[19] = new GiftCard("Det er Deres f�dselsdag. Modtag af hver medspiller 200kr", 200, playerlist);
		cardlist[20] = new RecieveCard("De har vundet i Kasselotteriet. Modtag 500kr", 500);
		cardlist[21] = new RecieveCard("De havde en r�kke med elleve rigtige i tipning. Modtag 1000kr", 1000);
		cardlist[22] = new RecieveCard("Modtag udbytte af Deres aktier 1000kr", 1000);
		cardlist[23] = new RecieveCard("Grundet dyrtiden har De faeet gageforh�jelse. Modtag 1000kr", 1000);
		cardlist[24] = new RecieveCard("Kommunen har eftergivet et kvartals skat. H�v i banken 3000kr", 3000);
		cardlist[25] = new RecieveCard("Modtag udbytte af Deres aktier 1000kr", 1000);
		cardlist[26] = new RecieveCard("Deres pr�mieobligation er kommet ud. De modtager 1000kr af banken", 1000);
		cardlist[27] = new RecieveCard("De modtager Deres aktieudbytte. Modtag 1000kr af banken", 1000);
		cardlist[28] = new RecieveIfCard("De modtager \"Matador-legatet for de v�rdige tr�ngende\" stort 40000kr. "
				+ "Ved v�rdige tr�ngende forst�s, af Deres formue, "
				+ "d.v.s. Deres kontante penge + sk�der + bygninger ikke overskrider 15000kr", 40000, 15000, board);
		cardlist[29] = new QueensCard("I anledning af deres majest�ts f�dselsdag ben�des de herved for f�ngsel. "
				+ "Dette kort kan opbevares, indtil De f�r brug for det");
	}
	
	public void shuffleDeck() {
		// Fisher-Yates shuffle algorithm
		Random r = new Random();
		for (int i = cardlist.length-1; i>0; i--) {
			int index = r.nextInt(i+1);
			Card a = cardlist[index];
			cardlist[index] = cardlist[i];
			cardlist[i] = a;
		}
	}
	public Card drawCard(Player player) {
		cardlist[0].drawCard(player);
		// puts the card in the bottom of the list/array
		Card temp = cardlist[0];
		for (int k = 1; k<cardlist.length; k++){
			cardlist[k-1] = cardlist[k];
		}
		cardlist[cardlist.length-1]=temp;
		return temp;
		
	}
	public String getMessage(int cardnumber) {
		return cardlist[cardnumber].getMessage();
	}
	public void pickCard(Player player, int cardnumber) {
		cardlist[cardnumber].drawCard(player);
	}
		

	public String toString() {
		String n = "";
		for (int i=0; i<cardlist.length; i++){
			n += i+1 + ":\t" + cardlist[i] + "\n" + "\n";
		}
		return n;
	}
}
