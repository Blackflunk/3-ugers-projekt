package deck;
import game.Player;
import fields.GameBoard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Deck {
	private Card[] cardlist = new Card[30];
	
	public Deck(Player[] playerlist, GameBoard board){
		cardlist[0] = new Movetocard("Ryk frem til Grønningen. Hvis de passerer \"Start\", indkassér da 4000kr ", 24, board);
		cardlist[1] = new Movetofleetcard("Ryk brikken frem til det nærmeste rederi og betal ejeren to gange den leje, "
				+ "han ellers er berettiget til, Hvis selskabet ikke ejes af nogen kan De købe det af banken.", board);
		cardlist[2] = new Movetocard("Ryk frem til \"Start\"", 0, board);
		cardlist[3] = new Moveammountcard("Ryk tre felter tilbage", -3, board);
		cardlist[4] = new Movetocard("Ryk frem til Frederiksberg Allé. Hvis de passerer \"Start\", indkassér da 4000kr", 11, board);
		cardlist[5] = new Movetocard("Tag med Mols-Linien -- Flyt brikken frem og hvis de passerer \"Start\", indkassér da 4000kr", 15, board);
		cardlist[6] = new Movetocard("Tag ind på Rådhuspladsen", 39, board);
		cardlist[7] = new Jailcard("Gå i Fængsel. Ryk direkte til fængsel. Selv om De passerer \"Start\", indkassér de ikke 4000kr", board);
		cardlist[8] = new Jailcard("Gå i Fængsel. Ryk direkte til fængsel. Selv om De passerer \"Start\", indkassér de ikke 4000kr", board);
		cardlist[9] = new Paycard("Betal 3000kr for reparation af Deres vogn", 3000);
		cardlist[10] = new Propertypaycard("Oliepriserne er steget, og de skal betale: \n 500kr pr. hus \n 2000kr pr. hotel", 500, 2000);
		cardlist[11] = new Paycard("De har måtte vedtage en parkeringsbøde. Betal 200kr i bøde", 200);
		cardlist[12] = new Paycard("Betal deres bilforsikring på 1000kr", 1000);
		cardlist[13] = new Paycard("Betal 3000kr for reparation af deres vogn", 3000);
		cardlist[14] = new Paycard("De har været en tur i udlandet og haft for mange cigaretter med hjem. Betal told 200kr", 200);
		cardlist[15] = new Paycard("De har kørt frem for \"Fuld Stop\". Betal 1000kr i bøde", 1000);
		cardlist[16] = new Paycard("De har modtaget Deres tandlægeregning. Betal 2000kr", 2000);
		cardlist[17] = new Propertypaycard("Ejendomsskatterne er steget, Ekstra udgifter er: \n 800kr pr. hus \n 2300kr pr. hotel", 800, 2300);
		cardlist[18] = new Recievecard("Værdien af egen avl fra nyttehaven udgør 200kr, som de modtager af banken", 200);
		cardlist[19] = new Giftcard("Det er Deres fødselsdag. Modtag af hver medspiller 200kr", 200, playerlist);
		cardlist[20] = new Recievecard("De har vundet i Kasselotteriet. Modtag 500kr", 500);
		cardlist[21] = new Recievecard("De havde en række med elleve rigtige i tipning. Modtag 1000kr", 1000);
		cardlist[22] = new Recievecard("Modtag udbytte af Deres aktier 1000kr", 1000);
		cardlist[23] = new Recievecard("Grundet dyrtiden har De fået gageforhøjelse. Mogtag 1000kr", 1000);
		cardlist[24] = new Recievecard("Kommunen har eftergivet et kvartals skat. Hæv i banken 3000kr", 3000);
		cardlist[25] = new Recievecard("Modtag udbytte af Deres aktier 1000kr", 1000);
		cardlist[26] = new Recievecard("Deres præmieobligation er kommet ud. De modtager 1000kr af banken", 1000);
		cardlist[27] = new Recievecard("De modtager Deres aktieudbytte. Modtag 1000kr af banken", 1000);
		cardlist[28] = new Recieveifcard("De modtager \"Matador-legatet for de værdige trængende\" stort 40000kr. "
				+ "Ved værdige trængende forstås, af Deres formue, "
				+ "d.v.s. Deres kontante penge + skøder + bygninger ikke overskrider 15000kr", 40000, 15000, board);
		cardlist[29] = new Queenscard("I anledning af deres majestæts fødselsdag benådes de herved for fængsel. "
				+ "Dette kort kan opbevares, indtil de får brug for det");
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
	public void drawCard(Player player) {
		cardlist[0].drawCard(player);
		// puts the card in the bottom of the list/array
		Card temp = cardlist[0];
		for (int k = 1; k<cardlist.length; k++){
			cardlist[k-1] = cardlist[k];
		}
		cardlist[cardlist.length-1]=temp;
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
