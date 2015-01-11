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
		field[1] = new Street.Builder().setTitle("Rï¿½dovrevej")
				.setDescription("Rï¿½dovrevej").setBgColor(Color.BLUE)
				.setSubText("Price: 1200").setRent("Rent: 1000").build();
		field[2] = new Chance.Builder().build();
		field[3] = new Street.Builder().setTitle("Hvidovrevej")
				.setDescription("Hvidovrevej").setBgColor(Color.BLUE)
				.setSubText("Price: 1200").setRent("Rent: 1000").build();
		field[4] = new Tax.Builder().setTitle("Statskat")
				.setDescription("Pay: 2000").setBgColor(Color.ORANGE)
				.setSubText("Pay: 2000").build();
		field[5] = new Shipping.Builder().setTitle("Helsingï¿½r-Helsingborg")
				.setDescription("Helsingï¿½r-Helsingborg").setBgColor(Color.GRAY)
				.setSubText("Price: 4000").setRent("Rent: 500").build();
		field[6] = new Street.Builder().setTitle("Roskildevej")
				.setDescription("Roskildevej").setBgColor(Color.PINK)
				.setSubText("Price: 2000").setRent("Rent: 1000").build();
		field[7] = new Chance.Builder().build();
		field[8] = new Street.Builder().setTitle("Valby Langgade")
				.setDescription("Valby Langgade").setBgColor(Color.PINK)
				.setSubText("Price: 2000").setRent("Rent: 1000").build();
		field[9] = new Street.Builder().setTitle("Allï¿½gade")
				.setDescription("Allï¿½gade").setBgColor(Color.PINK)
				.setSubText("Price: 2400").setRent("Rent: 1000").build();
		field[10] = new Jail.Builder().setTitle("Fï¿½ngsel").setDescription("Fï¿½ngsel")
				.setSubText("RAWR").build();
		field[11] = new Street.Builder().setTitle("Fredriksberg Allï¿½")
				.setDescription("Fredriksberg Allï¿½").setBgColor(Color.GREEN)
				.setSubText("Price: 2800").setRent("Rent: 2000").build();
		field[12] = new Brewery.Builder().setTitle("Tuborg")
				.setDescription("Tuborg").setBgColor(Color.CYAN)
				.setSubText("Price: 3000").setRent("80/200 x dice").build();
		field[13] = new Street.Builder().setTitle("Bï¿½lowsvej")
				.setDescription("Bï¿½lowsvej").setBgColor(Color.GREEN)
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
		field[23]= new Street.Builder().setTitle("ï¿½sterbrogade")
				.setDescription("ï¿½sterbrogade").setBgColor(Color.RED)
				.setSubText("Price: 4400").setRent("Rent: 3000").build();
		field[24] = new Street.Builder().setTitle("Grï¿½nningen")
				.setDescription("Grï¿½nningen").setBgColor(Color.RED)
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
		field[29] = new Street.Builder().setTitle("ï¿½stergade")
				.setDescription("ï¿½stergade").setBgColor(Color.WHITE)
				.setSubText("Price: 5600").setRent("Rent: 3000").build();
		field[30] = new Jail.Builder().setDescription("Ryk til Fï¿½ngsel")
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
		field[35] = new Shipping.Builder().setTitle("Rï¿½dby-Puttgarden")
				.setDescription("Rï¿½dby-Puttgarden").setBgColor(Color.CYAN)
				.setSubText("Price: 4000").setRent("Rent: 500").build();
		field[36] = new Chance.Builder().build();
		field[37] = new Street.Builder().setTitle("Frederiksberggade")
				.setDescription("Frederiksberggade").setBgColor(Color.MAGENTA)
				.setSubText("Price: 7000").setRent("Rent: 4000").build();
		field[38] = new Tax.Builder().setTitle("Indkomstskat")
				.setDescription("Pay: 4000 or 10%").setBgColor(Color.ORANGE)
				.setSubText("Pay: 4000 or 10%").build();
		field[39] = new Street.Builder().setTitle("Rï¿½dhuspladsen")
				.setDescription("Rï¿½dhuspladsen").setBgColor(Color.MAGENTA)
				.setSubText("Price: 8000").setRent("Rent: 4000").build();
		
		GUI.create(field);
	}
	
	public int playerAmount() {
		return Integer.parseInt(JOptionPane.showInputDialog("Vï¿½lg antallet af spillere (mellem 3-6)"));
	}
	
	public void playerAmountError(){
		JOptionPane.showMessageDialog(null, "Du skal vï¿½lge mellem 3-6 spiller");
	}
	public void showMessage(String message) {
		GUI.showMessage(message);
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
		GUI.showMessage(player[currentPlayer].getName()+"'s tur til at slï¿½.");
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
		player[currentPlayer].movePosition(diceSum);
		// Sets car on new position on board
		GUI.setCar(player[currentPlayer].getPosition() + 1,
				player[currentPlayer].getName());
	}
	public void removeCar(Player player) {
		GUI.removeAllCars(player.getName());
	}
	public void setCar(Player player) {
		GUI.setCar(player.getPosition(), player.getName());
	}
	
	public void newPositon(Player player) {
		GUI.removeAllCars(player.getName());
		GUI.setCar(player.getPosition(), player.getName());
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
				" har ingen ejer, vil du kï¿½be grunden for " + price + "?", "Ja",
				"Nej");
	}
	
	public void fieldBought(String name) {
		GUI.showMessage("Du har kï¿½bt " + name);
	}
	
	public void fieldRefused(String name) {
		GUI.showMessage("Du har ikke kï¿½bt " + name);
	}
	
	public void fieldRefusedPrice(String name) {
		GUI.showMessage("Du har ikke nok penge til at kï¿½be " + name);
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
		GUI.showMessage("du er landet pï¿½ " + name + " og modtager " + bonus + " Kr.");
	}
	
	public void startMessage(String name) {
		GUI.showMessage("Du er landet pï¿½ " + name
				+ ". Rest here until next turn.");  // FIKS THIS
	}
	
	public void goldmineMessage(String name) {
		GUI.showMessage("Du er landet pï¿½ " + name
				+ " og mï¿½ betale 2000 til skat");
	}
	
	public void insufficiantFundsTax() {
		GUI.showMessage("Du skylder mere i skat end du har. "
				+ "Resten af dine vï¿½rdier vil bliver overfï¿½rt til banken.");
	}
	
	public String taxPick(String name) {
		return GUI.getUserSelection(
				"du er landet pï¿½ "+ name + " og skal betale indkomstskat. "
						+ "vil du helts betale 4000 eller 10% af dine kontanter?",
				"4000", "10%");
	}
	
	public void taxFunds() {
		GUI.showMessage("The tax is higher than your balance. Instead you pay the rest of you balance.");
	}
	
	public String offerToBuy(String possibleBuild){
		return GUI.getUserSelection("Du ejer nok grunde af en farve til at bygge huse. Ønsker du at bygger på en af disse grunde?" + possibleBuild,"Ja","Nej");
	}
	public boolean jailOptions(Player player) {
		return GUI.getUserLeftButtonPressed(player.getName()+" sidder i fængsel, "
				+ "vil du betale 1000kr for at komme ud, eller prøve at slå dig ud af fængslet?", "Betal 1000kr", "slå for at komme ud");
	}
}
