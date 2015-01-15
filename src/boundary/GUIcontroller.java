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
import entity.Player;

public class GUIcontroller {
	//Game methods
	public void createField() {
		// Array that holds the fields for the GUI
		Field[] field = new Field[40];
		field[0] = new Start.Builder().setTitle("Start")
				.setDescription("Start").setSubText("Start")
				.setBgColor(Color.RED).build();
		field[1] = new Street.Builder().setTitle("Roedovrevej")
				.setDescription("Roedovrevej").setBgColor(Color.BLUE)
				.setSubText("Price: 1200").setRent("Rent: 1000").build();
		field[2] = new Chance.Builder().build();
		field[3] = new Street.Builder().setTitle("Hvidovrevej")
				.setDescription("Hvidovrevej").setBgColor(Color.BLUE)
				.setSubText("Price: 1200").setRent("Rent: 1000").build();
		field[4] = new Tax.Builder().setTitle("Statskat")
				.setDescription("Pay: 4000 eller 10%").setBgColor(Color.ORANGE)
				.setSubText("Pay: 4000 eller 10%").build();
		field[5] = new Shipping.Builder().setTitle("Helsingoer-Helsingborg")
				.setDescription("Helsingoer-Helsingborg").setBgColor(Color.GRAY)
				.setSubText("Price: 4000").setRent("Rent: 500").build();
		field[6] = new Street.Builder().setTitle("Roskildevej")
				.setDescription("Roskildevej").setBgColor(Color.PINK)
				.setSubText("Price: 2000").setRent("Rent: 1000").build();
		field[7] = new Chance.Builder().build();
		field[8] = new Street.Builder().setTitle("Valby Langgade")
				.setDescription("Valby Langgade").setBgColor(Color.PINK)
				.setSubText("Price: 2000").setRent("Rent: 1000").build();
		field[9] = new Street.Builder().setTitle("Allegade")
				.setDescription("Allegade").setBgColor(Color.PINK)
				.setSubText("Price: 2400").setRent("Rent: 1000").build();
		field[10] = new Jail.Builder().setTitle("Faengsel").setDescription("Faengsel")
				.setSubText("RAWR").build();
		field[11] = new Street.Builder().setTitle("Fredriksberg Alle")
				.setDescription("Fredriksberg Alle").setBgColor(Color.GREEN)
				.setSubText("Price: 2800").setRent("Rent: 2000").build();
		field[12] = new Brewery.Builder().setTitle("Tuborg")
				.setDescription("Tuborg").setBgColor(Color.CYAN)
				.setSubText("Price: 3000").setRent("80/200 x dice").build();
		field[13] = new Street.Builder().setTitle("Bulowsvej")
				.setDescription("Bulowsvej").setBgColor(Color.GREEN)
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
		field[23]= new Street.Builder().setTitle("Oesterbrogade")
				.setDescription("Oesterbrogade").setBgColor(Color.RED)
				.setSubText("Price: 4400").setRent("Rent: 3000").build();
		field[24] = new Street.Builder().setTitle("Groenningen")
				.setDescription("Groenningen").setBgColor(Color.RED)
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
		field[29] = new Street.Builder().setTitle("Istergade")
				.setDescription("Oestergade").setBgColor(Color.WHITE)
				.setSubText("Price: 5600").setRent("Rent: 3000").build();
		field[30] = new Jail.Builder().setDescription("Ryk til Faengsel")
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
		field[35] = new Shipping.Builder().setTitle("Roedby-Puttgarden")
				.setDescription("Roedby-Puttgarden").setBgColor(Color.CYAN)
				.setSubText("Price: 4000").setRent("Rent: 500").build();
		field[36] = new Chance.Builder().build();
		field[37] = new Street.Builder().setTitle("Frederiksberggade")
				.setDescription("Frederiksberggade").setBgColor(Color.MAGENTA)
				.setSubText("Price: 7000").setRent("Rent: 4000").build();
		field[38] = new Tax.Builder().setTitle("Indkomstskat")
				.setDescription("Pay: 2000").setBgColor(Color.ORANGE)
				.setSubText("Pay: 2000").build();
		field[39] = new Street.Builder().setTitle("Raadhuspladsen")
				.setDescription("Raadhuspladsen").setBgColor(Color.MAGENTA)
				.setSubText("Price: 8000").setRent("Rent: 4000").build();
		
		GUI.create(field);
	}
	
	public int playerAmount() {
		return Integer.parseInt(JOptionPane.showInputDialog("Vaelg antallet af spillere (mellem 3-6)"));
	}
	
	public void playerAmountError(){
		JOptionPane.showMessageDialog(null, "Du skal vaelge mellem 3-6 spiller");
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
		GUI.showMessage(player[currentPlayer].getName()+"'s tur til at slaa.");
	}
	
	public void showDice(int dice1, int dice2) {
		GUI.setDice(dice1, dice2);
	}
	
	public void setOwner(Player player) {
		GUI.setOwner(player.getPosition()+1, player.getName());
	}
	
	public void updatePosition(Player[] player, int currentPlayer, int diceSum) {
		// Remove car from old position on board
		GUI.removeAllCars(player[currentPlayer].getName());;
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
		GUI.setCar(player.getPosition()+1, player.getName());
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
				" har ingen ejer, vil du koebe grunden for " + price + "?", "Ja",
				"Nej");
	}
	
	public void fieldBought(String name) {
		GUI.showMessage("Du har koebt " + name);
	}
	
	public void pastStart(){
		GUI.showMessage("Du har passeret start");
	}
	
	public void afterJail(){
		GUI.showMessage("Du forlod faengslet, og rykker summen paa terningerne");
	}
	
	public void threePair(){
		GUI.showMessage("Du har slaaet 3 par i traek, du ryger i faengsel");
	}
	
	public void twoPair(){
		GUI.showMessage("Tryk for at slaa igen, hvis du slaer to ens igen ryger du i faengsel");
	}
	
	public void onePair(){
		GUI.showMessage("Tryk for at slaa igen");
	}
	
	public void fieldRefused(String name) {
		GUI.showMessage("Du har ikke koebt " + name);
	}
	
	public void fieldRefusedPrice(String name) {
		GUI.showMessage("Du har ikke nok penge til at koebe " + name);
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
		GUI.showMessage("du er landet paa " + name + " og modtager " + bonus + " Kr.");
	}
	
	public void startMessage(String name) {
		GUI.showMessage("Du er landet paa " + name
				+ ". Slap af indtil naeste tur."); 
	}
	
	public void taxMessageNoOption(int price) {
		GUI.showMessage("Du har betalt " + price + " i tax");
	}
	
	public void insufficiantFundsTax() {
		GUI.showMessage("Du skylder mere i skat end du har. "
				+ "Resten af dine vaerdier vil bliver overfoert til banken.");
	}
	
	public boolean taxPick(String name) {
		return GUI.getUserLeftButtonPressed("du er landet paa "+ name + " og skal betale indkomstskat. "
						+ "vil du helst betale 4000 eller 10% af dine kontanter?","10%", "4000");
	}
	public void messageTax10percent() {
		GUI.showMessage("Du har betalt 10% af dine kontanter");
	}
	
	public void taxFunds() {
		GUI.showMessage("The tax is higher than your balance. Instead you pay the rest of your balance.");
	}
	
	public String offerToBuy(String possibleBuild){
		return GUI.getUserButtonPressed("Du ejer nok grunde af en farve til at bygge huse. Oensker du at bygger paa en af disse grunde?" + possibleBuild,"Ja","Nej");
	}
	
	public String offerToSell(){
		return GUI.getUserButtonPressed("Oensker du at sælge dine grunde/huse?","Ja","Nej");
	}
	
	public boolean jailOptions(Player player) {
		return GUI.getUserLeftButtonPressed(player.getName()+" sidder i faengsel, "
				+ "vil du betale 1000kr for at komme ud, eller proeve at slaa dig ud af faengslet?", "Betal 1000kr", "slaa for at komme ud");
	}
	
	public String buyRoedovervej(){
		return GUI.getUserButtonPressed("Oensker du at koebe et hus/hotel paa Roedovervej for kr. 1000?", "Ja", "Nej");
	}
	public String buyHvidovervej(){
		return GUI.getUserButtonPressed("Oensker du at koebe et hus/hotel paa Hvidovervej for kr. 1000?", "Ja", "Nej");
	}
	public String buyRoskildevej(){
		return GUI.getUserButtonPressed("Oensker du at koebe et hus/hotel paa Roskildevej for kr. 1000?", "Ja", "Nej");
	}
	public String buyValbyLanggade(){
		return GUI.getUserButtonPressed("Oensker du at koebe et hus/hotel paa Valby Langgade for kr. 1000?", "Ja", "Nej");
	}
	public String buyAllegade(){
		return GUI.getUserButtonPressed("Oensker du at koebe et hus/hotel paa Allegade for kr. 1000?", "Ja", "Nej");
	}
	public String buyFredriksbergAlle(){
		return GUI.getUserButtonPressed("Oensker du at koebe et hus/hotel paa Fredriksberg Alle for kr. 2000?", "Ja", "Nej");
	}
	public String buyBulowsvej(){
		return GUI.getUserButtonPressed("Oensker du at koebe et hus/hotel paa Bulowsvej for kr. 2000?", "Ja", "Nej");
	}
	public String buyGlKongevej(){
		return GUI.getUserButtonPressed("Oensker du at koebe et hus/hotel paa Gl Kongevej for kr. 2000?", "Ja", "Nej");
	}
	public String buyBernstorffsvej(){
		return GUI.getUserButtonPressed("Oensker du at koebe et hus/hotel paa Bernstorffsvej for kr. 2000?", "Ja", "Nej");
	}
	public String buyHellerupvej(){
		return GUI.getUserButtonPressed("Oensker du at koebe et hus/hotel paa Hellerupvej for kr. 2000?", "Ja", "Nej");
	}
	public String buyStrandvejen(){
		return GUI.getUserButtonPressed("Oensker du at koebe et hus/hotel paa Strandvejen for kr. 2000?", "Ja", "Nej");
	}
	public String buyTrianglen(){
		return GUI.getUserButtonPressed("Oensker du at koebe et hus/hotel paa Trianglen for kr. 3000?", "Ja", "Nej");
	}
	public String buyOesterbrogade(){
		return GUI.getUserButtonPressed("Oensker du at koebe et hus/hotel paa Oesterbrogade for kr. 3000?", "Ja", "Nej");
	}
	public String buyGroenningen(){
		return GUI.getUserButtonPressed("Oensker du at koebe et hus/hotel paa Groenningen for kr. 3000?", "Ja", "Nej");
	}
	public String buyBredgade(){
		return GUI.getUserButtonPressed("Oensker du at koebe et hus/hotel paa Bredgade for kr. 3000?", "Ja", "Nej");
	}
	public String buyKgsNytorv(){
		return GUI.getUserButtonPressed("Oensker du at koebe et hus/hotel paa Kgs Nytorv for kr. 3000?", "Ja", "Nej");
	}
	public String buyIstergade(){
		return GUI.getUserButtonPressed("Oensker du at koebe et hus/hotel paa Istergade for kr. 3000?", "Ja", "Nej");
	}
	public String buyAmagertorv(){
		return GUI.getUserButtonPressed("Oensker du at koebe et hus/hotel paa Amagertorv for kr. 4000?", "Ja", "Nej");
	}
	public String buyVimmelskaftet(){
		return GUI.getUserButtonPressed("Oensker du at koebe et hus/hotel paa Vimmelskaftet for kr. 4000?", "Ja", "Nej");
	}
	public String buyNygade(){
		return GUI.getUserButtonPressed("Oensker du at koebe et hus/hotel paa Nygade for kr. 4000?", "Ja", "Nej");
	}
	public String buyFrederiksberggade(){
		return GUI.getUserButtonPressed("Oensker du at koebe et hus/hotel paa Frederiksberggade for kr. 4000?", "Ja", "Nej");
	}
	public String buyRaadhuspladsen(){
		return GUI.getUserButtonPressed("Oensker du at koebe et hus/hotel paa Raadhuspladsen for kr. 4000?", "Ja", "Nej");
	}
	public void setHouse(int fieldNumber, int houseCount){
		GUI.setHouses(fieldNumber, houseCount);
	}
	public void setHotel(int fieldNumber, boolean hasHotel){
		GUI.setHotel(fieldNumber, hasHotel);
	}
}
