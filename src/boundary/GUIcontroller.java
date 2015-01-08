package boundary;

import java.awt.Color;

import javax.swing.JOptionPane;

import desktop_codebehind.Car;
import desktop_fields.Brewery;
import desktop_fields.Chance;
import desktop_fields.Field;
import desktop_fields.Jail;
import desktop_fields.Refuge;
import desktop_fields.Shipping;
import desktop_fields.Start;
import desktop_fields.Street;
import desktop_fields.Tax;
import desktop_resources.GUI;
import game.Player;

public class GUIcontroller {
	//Game methods
	public void createField() {
		// Array that holds the fields for the GUI
		Field[] field = new Field[40];
		field[0] = new Start.Builder().setTitle("Start")
				.setDescription("Start").setSubText("Start")
				.setBgColor(Color.RED).build();
		field[1] = new Street.Builder().setTitle("Rødovrevej")
				.setDescription("Rødovrevej").setBgColor(Color.BLUE)
				.setSubText("Price: 1200").setRent("Rent: 1000").build();
		field[2] = new Chance.Builder().build();
		field[3] = new Street.Builder().setTitle("Hvidovrevej")
				.setDescription("Hvidovrevej").setBgColor(Color.BLUE)
				.setSubText("Price: 1200").setRent("Rent: 1000").build();
		field[4] = new Tax.Builder().setTitle("Statskat")
				.setDescription("Pay: 2000").setBgColor(Color.ORANGE)
				.setSubText("Pay: 2000").build();
		field[5] = new Shipping.Builder().setTitle("Helsingør-Helsingborg")
				.setDescription("Helsingør-Helsingborg").setBgColor(Color.GRAY)
				.setSubText("Price: 4000").setRent("Rent: 500").build();
		field[6] = new Street.Builder().setTitle("Roskildevej")
				.setDescription("Roskildevej").setBgColor(Color.PINK)
				.setSubText("Price: 2000").setRent("Rent: 1000").build();
		field[7] = new Chance.Builder().build();
		field[8] = new Street.Builder().setTitle("Valby Langgade")
				.setDescription("Valby Langgade").setBgColor(Color.PINK)
				.setSubText("Price: 2000").setRent("Rent: 1000").build();
		field[9] = new Street.Builder().setTitle("Allégade")
				.setDescription("Allégade").setBgColor(Color.PINK)
				.setSubText("Price: 2400").setRent("Rent: 1000").build();
		field[10] = new Jail.Builder().setTitle("Fængsel").setDescription("Fængsel")
				.setSubText("RAWR").build();
		field[11] = new Street.Builder().setTitle("Fredriksberg Allé")
				.setDescription("Fredriksberg Allé").setBgColor(Color.GREEN)
				.setSubText("Price: 2800").setRent("Rent: 2000").build();
		field[12] = new Brewery.Builder().setTitle("Tuborg")
				.setDescription("Tuborg").setBgColor(Color.CYAN)
				.setSubText("Price: 3000").setRent("80/200 x dice").build();
		field[13] = new Street.Builder().setTitle("Bülowsvej")
				.setDescription("Bülowsvej").setBgColor(Color.GREEN)
				.setSubText("Price: 2800").setRent("Rent: 2000").build();
		field[14] = new Street.Builder().setTitle("Gl Kongevej")
				.setDescription("Gl Kongevej").setBgColor(Color.GREEN)
				.setSubText("Price: 3200").setRent("Rent: 2000").build();
		field[15] = new Shipping.Builder().setTitle("Mols-Linien")
				.setDescription("Mols-Linien").setBgColor(Color.CYAN)
				.setSubText("Price: 4000").setRent("Rent: 500").build();
		field[16] = new Street.Builder().setTitle("Bernstorffsvej")
				.setDescription("Bernstorffsvej").setBgColor(Color.GRAY)
				.setSubText("Price: 3600").setRent("Rent: 2000").build();
		field[17] = new Chance.Builder().build();
		field[18] = new Street.Builder().setTitle("Hellerupvej")
				.setDescription("Hellerupvej").setBgColor(Color.GRAY)
				.setSubText("Price: 3600").setRent("Rent: 2000").build();
		field[19] = new Street.Builder().setTitle("Strandvejen")
				.setDescription("Strandvejen").setBgColor(Color.GRAY)
				.setSubText("Price: 4000").setRent("Rent: 2000").build();
		field[20] = new Refuge.Builder().setTitle("Helle")
				.setDescription("Price 5000").setBgColor(Color.ORANGE)
				.setSubText("Recieve: 500").build();
		field[21] = new Street.Builder().setTitle("Trianglen")
				.setDescription("Trianglen").setBgColor(Color.RED)
				.setSubText("Price: 4400").setRent("Rent: 3000").build();
		field[22] = new Chance.Builder().build();
		field[23]= new Street.Builder().setTitle("Østerbrogade")
				.setDescription("Østerbrogade").setBgColor(Color.RED)
				.setSubText("Price: 4400").setRent("Rent: 3000").build();
		field[24] = new Street.Builder().setTitle("Grønningen")
				.setDescription("Grønningen").setBgColor(Color.RED)
				.setSubText("Price: 4800").setRent("Rent: 3000").build();
		field[25] = new Shipping.Builder().setTitle("Gedser-Rostock")
				.setDescription("Gedser-Rostock").setBgColor(Color.CYAN)
				.setSubText("Price: 4000").setRent("Rent: 500").build();
		field[26] = new Street.Builder().setTitle("Bredgade")
				.setDescription("Bredgade").setBgColor(Color.WHITE)
				.setSubText("Price: 5200").setRent("Rent: 3000").build();
		field[27] = new Street.Builder().setTitle("Kgs Nytorv")
				.setDescription("Kgs Nytorv").setBgColor(Color.WHITE)
				.setSubText("Price: 5200").setRent("Rent: 3000").build();
		field[28] = new Brewery.Builder().setTitle("Coca-Cola")
				.setDescription("Coca-Cola").setBgColor(Color.CYAN)
				.setSubText("Price: 3000").setRent("80/200 x dice").build();
		field[29] = new Street.Builder().setTitle("Østergade")
				.setDescription("Østergade").setBgColor(Color.WHITE)
				.setSubText("Price: 5600").setRent("Rent: 3000").build();
		field[30] = new Jail.Builder().setDescription("Ryk til Fængsel")
				.setSubText("Du modtager ikke kr. 4000 selvom du passerer start").build();
		field[31] = new Street.Builder().setTitle("Amagertorv")
				.setDescription("Amagertorv").setBgColor(Color.YELLOW)
				.setSubText("Price: 6000").setRent("Rent: 4000").build();
		field[32] = new Street.Builder().setTitle("Vimmelskaftet")
				.setDescription("Vimmelskaftet").setBgColor(Color.YELLOW)
				.setSubText("Price: 6000").setRent("Rent: 4000").build();
		field[33] = new Chance.Builder().build();
		field[34] = new Street.Builder().setTitle("Nygade")
				.setDescription("Nygade").setBgColor(Color.YELLOW)
				.setSubText("Price: 6400").setRent("Rent: 4000").build();
		field[35] = new Shipping.Builder().setTitle("Rødby-Puttgarden")
				.setDescription("Rødby-Puttgarden").setBgColor(Color.CYAN)
				.setSubText("Price: 4000").setRent("Rent: 500").build();
		field[36] = new Chance.Builder().build();
		field[37] = new Street.Builder().setTitle("Frederiksberggade")
				.setDescription("Frederiksberggade").setBgColor(Color.MAGENTA)
				.setSubText("Price: 7000").setRent("Rent: 4000").build();
		field[38] = new Tax.Builder().setTitle("Indkomstskat")
				.setDescription("Pay: 4000 or 10%").setBgColor(Color.ORANGE)
				.setSubText("Pay: 4000 or 10%").build();
		field[39] = new Street.Builder().setTitle("Rådhuspladsen")
				.setDescription("Rådhuspladsen").setBgColor(Color.MAGENTA)
				.setSubText("Price: 8000").setRent("Rent: 4000").build();
		
		GUI.create(field);
	}
	
	public int playerAmount() {
		return Integer.parseInt(JOptionPane.showInputDialog("Vælg antallet af spillere (mellem 3-6)"));
	}
	
	public void playerAmountError(){
		JOptionPane.showMessageDialog(null, "Du skal vælge mellem 3-6 spiller");
	}
	
	public void createPlayers(int playerAmount, Player[] player) {
		// Array that holds the cars for the GUI
		Car[] car = new Car[6];
		car[0] = new Car.Builder().primaryColor(Color.blue).build();
		car[1] = new Car.Builder().primaryColor(Color.red).build();
		car[2] = new Car.Builder().primaryColor(Color.yellow).build();
		car[3] = new Car.Builder().primaryColor(Color.green).build();
		car[4] = new Car.Builder().primaryColor(Color.white).build();
		car[5] = new Car.Builder().primaryColor(Color.black).build();
		
		for (int i = 0; i < playerAmount; i++) {
			player[i] = new Player(GUI.getUserString("Skriv navnet for spiller "
					+ (i + 1) + ":"));
			GUI.addPlayer(player[i].getName(), player[i].account.getScore(),
					car[i]);
			GUI.setCar(player[i].getPosition() + 1, player[i].getName());
		}
	}
	
	public void nextPlayer(Player[] player, int currentPlayer) {
		GUI.showMessage(player[currentPlayer].getName()
				+ "'s tur til at slå.");
	}
	
	public void showDice(int dice1, int dice2) {
		GUI.setDice(dice1, dice2);
	}
	
	public void setOwner(Player player) {
		GUI.setOwner(player.getPosition()+1, player.getName());
	}
	
	public void updatePosition(Player[] player, int currentPlayer, int diceSum) {
		// Remove car from old position on board
		GUI.removeCar(player[currentPlayer].getPosition() + 1,
				player[currentPlayer].getName());
		player[currentPlayer].setPosition(diceSum);
		// Sets car on new position on board
		GUI.setCar(player[currentPlayer].getPosition() + 1,
				player[currentPlayer].getName());

	}
	
	public void removePlayer(Player[] player, int currentPlayer) {
		GUI.removeCar(player[currentPlayer].getPosition() + 1, player[currentPlayer].getName());
		GUI.showMessage("Du er fallit.");		
	}
	
	public void showWin(Player[] player, int playerAmount) {
		for (int i = 0; i < playerAmount; i++) {
			if (!player[i].getStatus()) {
				GUI.showMessage(player[i].getName() + " har vundet!");
			}
		}
	}
	
	//Field methods
	public boolean buyField(String name, int price) {
		return GUI.getUserLeftButtonPressed(name + 
				" har ingen ejer, vil du købe grunden for " + price + "?", "Ja",
				"Nej");
	}
	
	public void fieldBought(String name) {
		GUI.showMessage("Du har købt " + name);
	}
	
	public void fieldRefused(String name) {
		GUI.showMessage("Du har ikke købt " + name);
	}
	
	public void fieldRefusedPrice(String name) {
		GUI.showMessage("Du har ikke nok penge til at købe " + name);
	}
	
	public void fieldOwnedByPlayer(String name) {
		GUI.showMessage(name
				+ " er ejet af dig selv og der sker derfor ikke noget..");
	}
	
	public void fieldTax(String fieldName, String playerName, int price) {
		GUI.showMessage(fieldName + " er ejet af " + playerName
				+ ", " + price
				+ " kr vil blive flyttet til "
				+ playerName + "'s konto");
	}
	
	public void updateBalance(String playerName, int amount) {
		GUI.setBalance(playerName, amount);
	}
	
	public void insufficiantFunds(String fieldName, String playerName, int balance) {
		GUI.showMessage(fieldName
				+ " er ejet af "
				+ playerName
				+ ", men du skal betale mere end du har, derfor vil resten af dine penge blevet flyttet, Dette er "
				+ balance
				+ "kr som "
				+ playerName + " vil modtage.");
	}
	
	public void bonusMessage(String name, int bonus) {
		GUI.showMessage("du er landet på " + name + " og modtager " + bonus + " Kr.");
	}
	
	public void startMessage(String name) {
		GUI.showMessage("Du er landet på " + name
				+ ". Rest here until next turn.");  // FIKS THIS
	}
	
	public void goldmineMessage(String name) {
		GUI.showMessage("Du er landet på " + name
				+ " og må betale 2000 til skat");
	}
	
	public void insufficiantFundsTax() {
		GUI.showMessage("Du skylder mere i skat end du har. "
				+ "Resten af dine værdier vil bliver overført til banken.");
	}
	
	public String taxPick(String name) {
		return GUI.getUserSelection(
				"du er landet på "+ name + " og skal betale indkomstskat. "
						+ "vil du helts betale 4000 eller 10% af dine kontanter?",
				"4000", "10%");
	}
	
	public void taxFunds() {
		GUI.showMessage("The tax is higher than your balance. Instead you pay the rest of you balance.");
	}
}
