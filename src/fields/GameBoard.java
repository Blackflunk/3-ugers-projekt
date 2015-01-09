package fields;

import game.DiceBox;
import game.Player;

public class GameBoard {

	private Fields[] field;
	
	public GameBoard(DiceBox box) {

		// Array that creates each field and the attributes
		field = new Fields[40];
		field[0] = new Start("Start");
		field[1] = new Territory("R�dovrevej",1200, 1000, 600, 40, 200, 600, 1800, 3200, 5000,"Blue");
		field[2] = new ChanceCard("Chancekort");
		field[3] = new Territory("Hvidovrevej", 1200, 1000, 600, 80, 400, 1200, 3600, 6400, 9000,"Blue");
		field[4] = new Tax("Statsskat", 2000);
		field[5] = new Fleet("Helsing�r-Helsingborg", 4000, 2000, 500, 1000, 2000, 4000);
		field[6] = new Territory("Roskildevej", 2000, 1000, 1000, 120, 600, 1800, 5400, 8000, 11000,"Pink");
		field[7] = new ChanceCard("Chancekort");
		field[8] = new Territory("Valby Langgade", 2000, 1000, 1000, 120, 600, 1800, 5400, 8000, 11000, "Pink");
		field[9] = new Territory("All�gade", 2400, 1000, 1200, 160, 800, 2000, 6000, 9000, 12000, "Pink");
		field[10] = new Jail("F�ngsel");
		field[11] = new Territory("Fredriksberg All�", 2800, 2000, 1400, 200, 1000, 3000, 9000, 12500, 15000, "Green");
		field[12] = new LaborCamp("Tuborg", 3000, 1500, 80, box);
		field[13] = new Territory("B�lowsvej", 2800, 2000, 1400, 200, 1000, 3000, 9000, 12500, 15000,"Green");
		field[14] = new Territory("Gl Kongevej", 3200, 2000, 1600, 240, 1200, 3600, 10000, 14000, 18000, "Green");
		field[15] = new Fleet("Mols-Linien", 4000, 2000, 500, 1000, 2000, 4000);
		field[16] = new Territory("Bernstorffsvej", 3600, 2000, 1800, 280, 1400, 4000, 11000, 15000, 19000,"Gray");
		field[17] = new ChanceCard("Chancekort");
		field[18] = new Territory("Hellerupvej", 3600, 2000, 1800, 280, 1400, 4000, 11000, 15000, 19000, "Gray");
		field[19] = new Territory("Strandvejen", 4000, 2000, 2000, 320, 1600, 4400, 12000, 16000, 20000, "Gray");
		field[20] = new Refuge("Parkering", 5000);
		field[21] = new Territory("Trianglen", 4400, 3000, 2200, 360, 1800, 5000, 14000, 17500, 21000,"Red");
		field[22] = new ChanceCard("Chancekort");
		field[23] =	new Territory("�sterbrogade", 4400, 3000, 2200, 360, 1800, 5000, 14000, 17500, 21000,"Red");
		field[24] = new Territory("Gr�nningen", 4800, 3000, 2400, 400, 2000, 6000, 15000, 18500, 22000,"Red");
		field[25] = new Fleet("Gedser-Rostock", 4000, 2000, 500, 1000, 2000, 4000);
		field[26] = new Territory("Bredgade", 5200, 3000, 2600, 440, 2200, 6600, 16000, 19500, 23000,"White");
		field[27] =	new Territory("Kgs Nytorv", 5200, 3000, 2600, 440, 2200, 6600, 16000, 19500, 23000,"White");
		field[28] = new LaborCamp("Coca-Cola", 3000, 1500, 80, box);
		field[29] = new Territory("�stergade", 5600, 3000, 2800, 480, 2400, 7200, 17000, 20500, 24000,"White");
		field[30] = new MoveToJail("G� I F�ngslet");
		field[31] = new Territory("Amagertorv", 6000, 4000, 3000, 520, 2600, 7800, 18000, 22000, 25500,"Yellow");
		field[32] =	new Territory("Vimmelskaftet", 6000, 4000, 3000, 520, 2600, 7800, 18000, 22000, 25500,"Yellow");
		field[33] = new ChanceCard("Chancekort");
		field[34] = new Territory("Nygade", 6400, 4000, 3200, 560, 3000, 9000, 20000, 24000, 28000,"Yellow");
		field[35] = new Fleet("R�dby-Puttgarden", 4000, 2000, 500, 1000, 2000, 4000);
		field[36] = new ChanceCard("Chancekort");
		field[37] = new Territory("Frederiksberggade", 7000, 4000, 3500, 700, 3500, 10000, 22000, 26000, 30000, "Magenta");
		field[38] = new Tax("Indkomstskat", 4000);
		field[39] =	new Territory("R�dhuspladsen", 8000, 4000, 4000, 1000, 4000, 12000, 28000, 34000, 40000, "Magenta");
		
		
		//Skal havde lavet en class til Chance kort Jail og move to jail.
	}
	
	public Fields getField(int i) {
		return field[i];
	}
	public void resetOwnedFields(Player player) {
		for (int i = 0; i<field.length; i++) {
			if (field[i] instanceof Ownable) {
				if (((Ownable) field[i]).getOwner() == player) {
					((Ownable) field[i]).setOwner(null);
				}
			}
		}
	}
	public String toString() {
		String s = "";
		for (int i = 0; i<field.length; i++) {
			s += "Felt " + (i+1)+ "		" + field[i].toString();
		}
		return s;		
	}
}
