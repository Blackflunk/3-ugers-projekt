package game;

import desktop_fields.Jail;
import fields.Fields;
import fields.Fleet;
import fields.LaborCamp;
import fields.Ownable;
import fields.Refuge;
import fields.Start;
import fields.Tax;
import fields.Territory;


public class GameBoard {

	private Fields[] field;
	
	public GameBoard(DiceBox dice) {
		
		// Array that creates each field and the attributes
		field = new Fields[32];
		field[0] = new Start("Start");
		field[1] = new Territory("Rødovrevej", 1200, 1000);
		//field[2] = prøv lykken
		field[3] = new Territory("Hvidovrevej", 1200, 1000);
		field[4] = new Tax("Statsskat", 2000);
		field[5] = new Fleet("Helsingør-Helsingborg", 4000, 500, 1000, 2000, 4000);
		field[6] = new Territory("Roskildevej", 2000, 1000);
		//field[7] = prøv lykken
		field[8] = new Territory("Valby Langgade", 2000, 1000);
		field[9] = new Territory("Allégade", 2400, 1000);
		//field[10] = new jail
		field[11] = new Territory("Fredriksberg Allé", 2800, 2000);
		field[12] = new LaborCamp("Tuborg", 3000, 80, dice);
		field[13] = new Territory("Bülowsvej", 2800, 2000);
		field[14] = new Territory("Gl Kongevej", 3200, 2000);
		field[15] = new Fleet("Mols-Linien", 4000, 500, 1000, 2000, 4000);
		field[16] = new Territory("Bernstorffsvej", 3600, 2000);
		//field[17] =	prøv lykken
		field[18] = new Territory("Hellerupvej", 3600, 2000);
		field[19] = new Territory("Strandvejen", 4000, 2000);
		field[20] = new Refuge("Parkering", 200);
		field[21] = new Territory("Trianglen", 4400, 3000);
		//field[22] = prøv lykken
		field[23] =	new Territory("Østerbrogade", 4400, 3000);
		field[24] = new Territory("Grønningen", 4800, 3000);
		field[25] = new Fleet("Gedser-Rostock", 4000, 500, 1000, 2000, 4000);
		field[26] = new Territory("Bredgade", 5200, 3000);
		field[27] =	new Territory("Kgs Nytorv", 5200, 3000);
		field[28] = new LaborCamp("Coca-Cola", 3000, 80, dice);
		field[29] = new Territory("Østergade", 5600, 3000);
		//field[30] = Move to jail;
		field[31] = new Territory("Amagertorv", 6000, 4000);
		field[32] =	new Territory("Vimmelskaftet", 6000, 4000);
		//field[33] = prøv lykken
		field[34] = new Territory("Nygade", 6400, 4000);
		field[35] = new Fleet("Rødby-Puttgarden", 4000, 500, 1000, 2000, 4000);
		//field[36] = prøv lykken
		field[37] = new Territory("Frederiksberggade", 7000, 4000);
		field[38] = new Tax("Indkomstskat", 4000);
		field[39] =	new Territory("Rådhuspladsen", 8000, 4000);
		
		
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
