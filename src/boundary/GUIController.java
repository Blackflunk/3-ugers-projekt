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

public class GUIController {
	//Game methods
	public void createField() {
		// Array that holds the fields for the GUI
		Field[] field = new Field[40];
		field[0] = new Start.Builder().setTitle("Start")
				.setDescription("Start").setSubText("Start")
				.setBgColor(Color.RED).build();
		field[1] = new Street.Builder().setTitle("R�dovrevej")
				.setDescription("R�dovrevej").setBgColor(Color.BLUE)
				.setSubText("Price: 1200").setRent("Rent: 1000").build();
		field[2] = new Chance.Builder().build();
		field[3] = new Street.Builder().setTitle("Hvidovrevej")
				.setDescription("Hvidovrevej").setBgColor(Color.BLUE)
				.setSubText("Price: 1200").setRent("Rent: 1000").build();
		field[4] = new Tax.Builder().setTitle("Statskat")
				.setDescription("Pay: 4000 or 10%").setBgColor(Color.ORANGE)
				.setSubText("Pay: 4000 or 10%").build();
		field[5] = new Shipping.Builder().setTitle("Helsing�r-Helsingborg")
				.setDescription("Helsing�r-Helsingborg").setBgColor(Color.GRAY)
				.setSubText("Price: 4000").setRent("Rent: 500").build();
		field[6] = new Street.Builder().setTitle("Roskildevej")
				.setDescription("Roskildevej").setBgColor(Color.PINK)
				.setSubText("Price: 2000").setRent("Rent: 1000").build();
		field[7] = new Chance.Builder().build();
		field[8] = new Street.Builder().setTitle("Valby Langgade")
				.setDescription("Valby Langgade").setBgColor(Color.PINK)
				.setSubText("Price: 2000").setRent("Rent: 1000").build();
		field[9] = new Street.Builder().setTitle("All�gade")
				.setDescription("All�gade").setBgColor(Color.PINK)
				.setSubText("Price: 2400").setRent("Rent: 1000").build();
		field[10] = new Jail.Builder().setTitle("F�ngsel").setDescription("F�ngsel")
				.setSubText("F�ngsel").build();
		field[11] = new Street.Builder().setTitle("Fredriksberg All�")
				.setDescription("Fredriksberg All�").setBgColor(Color.GREEN)
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
		field[23]= new Street.Builder().setTitle("�sterbrogade")
				.setDescription("�sterbrogade").setBgColor(Color.RED)
				.setSubText("Price: 4400").setRent("Rent: 3000").build();
		field[24] = new Street.Builder().setTitle("Gr�nningen")
				.setDescription("Gr�nningen").setBgColor(Color.RED)
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
		field[29] = new Street.Builder().setTitle("�stergade")
				.setDescription("�stergade").setBgColor(Color.WHITE)
				.setSubText("Price: 5600").setRent("Rent: 3000").build();
		field[30] = new Jail.Builder().setDescription("Ryk til F�ngsel")
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
		field[35] = new Shipping.Builder().setTitle("R�dby-Puttgarden")
				.setDescription("R�dby-Puttgarden").setBgColor(Color.CYAN)
				.setSubText("Price: 4000").setRent("Rent: 500").build();
		field[36] = new Chance.Builder().build();
		field[37] = new Street.Builder().setTitle("Frederiksberggade")
				.setDescription("Frederiksberggade").setBgColor(Color.MAGENTA)
				.setSubText("Price: 7000").setRent("Rent: 4000").build();
		field[38] = new Tax.Builder().setTitle("Indkomstskat")
				.setDescription("Pay: 2000").setBgColor(Color.ORANGE)
				.setSubText("Pay: 2000").build();
		field[39] = new Street.Builder().setTitle("R�dhuspladsen")
				.setDescription("R�dhuspladsen").setBgColor(Color.MAGENTA)
				.setSubText("Price: 8000").setRent("Rent: 4000").build();
		
		GUI.create(field);
	}
	
	public int playerAmount() {
		return Integer.parseInt(JOptionPane.showInputDialog("V�lg antallet af spillere (mellem 3-6)"));
	}
	public int playerAmountshowcase() {
		return Integer.parseInt(JOptionPane.showInputDialog("V�lg antallet af spillere (mellem 2-6) \n DETTE ER EN DEMO K�RSEL AF SPILLET"));
	}
	
	public void playerAmountError(){
		JOptionPane.showMessageDialog(null, "Du skal v�lge mellem 3-6 spiller");
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
			player[i] = new Player(JOptionPane.showInputDialog("Skriv navnet for spiller "+(i + 1) + ":"));
			GUI.addPlayer(player[i].getName(), player[i].account.getScore(),
					car[i]);
			GUI.setCar(player[i].getPosition() + 1, player[i].getName());
		}
	}
	
	public void nextPlayer(Player[] player, int currentPlayer) {
		GUI.showMessage(player[currentPlayer].getName()+"'s tur til at sl�.");
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
	
	public void newPosition(Player player) {
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
		GUI.close();
	}
	
	//Field methods
	public boolean buyField(String name, int price) {
		return GUI.getUserLeftButtonPressed(name + 
				" har ingen ejer, vil du k�be grunden for " + price + "?", "Ja",
				"Nej");
	}
	
	public void fieldBought(String name) {
		GUI.showMessage("Du har k�bt " + name);
	}
	
	public void pastStart(){
		GUI.showMessage("Du har passeret start");
	}
	
	public void afterJail(){
		GUI.showMessage("Du forlod f�ngslet, og rykker summen p� terningerne");
	}
	public void moveToJail() {
		GUI.showMessage("Du har st�dt p� en politiracia, du er blevet arresteret, og bliver forflyttet til f�ngslet");
	}
	
	public void threePair(){
		GUI.showMessage("Du har sl�et 3 par i tr�k, du ryger i f�ngsel");
	}
	
	public void twoPair(){
		GUI.showMessage("Tryk for at sl� igen, hvis du sl�r to ens igen ryger du i f�ngsel");
	}
	
	public void onePair(){
		GUI.showMessage("Tryk for at sl� igen");
	}
	
	public void fieldRefused(String name) {
		GUI.showMessage("Du har ikke k�bt " + name);
	}
	
	public void fieldRefusedPrice(String name) {
		GUI.showMessage("Du har ikke nok penge til at k�be " + name);
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
		GUI.showMessage("du er landet p� " + name + " og modtager " + bonus + " Kr.");
	}
	
	public void startMessage(String name) {
		GUI.showMessage("Du er landet p� " + name
				+ ". Slap af indtil n�ste tur."); 
	}
	
	public void taxMessageNoOption(int price) {
			GUI.showMessage("Du har betalt " + price + " i tax");
		 	}
	
	public void insufficiantFundsTax() {
		GUI.showMessage("Du skylder mere i skat end du har. "
				+ "Resten af dine v�rdier vil bliver overf�rt til banken.");
	}
	public void showJailForcedPay() {
		GUI.showMessage("Du har pr�vet at komme ud af f�ngslet 3 gange, uden held - du betaler 1000kr for at komme ud"
						+ " du f�r ikke lov til at rykke denne tur");
	}
	public void showJailTurn() {
		GUI.showMessage("Sl� med terningerne for at pr�ve at komme ud af f�ngslet");
	}
	
	public boolean taxPick(String name) {
		return GUI.getUserLeftButtonPressed("du er landet p� "+ name + " og skal betale indkomstskat. "
								+ "vil du helst betale 4000 eller 10% af dine kontanter?","10%", "4000");
			}
	
	public void messageTax10percent() {
		GUI.showMessage("Du har betalt 10% af dine kontanter");
		 	}
	
	public void taxFunds() {
		GUI.showMessage("Den skat du skal betale er st�rre end den m�ngde penge du har og du betaler derfor resten af dine penge.");
	}
	public String startOfTurn(Player[] player, int currentPlayer){
		return GUI.getUserButtonPressed("Det er starten af din tur, " + player[currentPlayer].getName() + " hvad 'nsker du at g�re?", "K�b hus", "S�lg hus", "rul terning");
		
	}
	
	public String offerToBuy(String possibleBuild){
		return GUI.getUserButtonPressed("Du ejer nok grunde af en farve til at bygge huse. �nsker du at bygger p� en af disse grunde?" + possibleBuild,"Ja","Nej");
	}
	public boolean offerMoreHouses(){
		return GUI.getUserLeftButtonPressed("�nsker du at k�be flere huse?", "Ja", "Nej");
	}
	public String offerToSellHouse(String[] sellOptions){
		return GUI.getUserSelection("Du kan s�lge huse p� disse grunde!", sellOptions);
	}
	public boolean offerToMoreSellHouses(){
		return GUI.getUserLeftButtonPressed("�nsker du at s�lge flere huse?", "Ja", "Nej");
	}
	public String noHouseToSell(){
		return GUI.getUserButtonPressed("Du ejer ikke nogle huse som kan s�lges", "Okay");
	}

	public String noHouseToBuy() {
		return GUI.getUserButtonPressed("Du ejer ikke nogle grunde hvor du kan k�be huse'1", "Okay");
		
	}
	public String offerToSellPlot(){
		return GUI.getUserButtonPressed("�nsker du at s�lge dine grunde?","Ja","Nej");
	}

	
	public boolean jailOptions(Player player) {
		return GUI.getUserLeftButtonPressed(player.getName()+" sidder i f�ngsel, "
				+ "vil du betale 1000kr for at komme ud, eller pr�ve at sl� dig ud af f�ngslet?", "Betal 1000kr", "sl� for at komme ud");
	}
	
	public String buyRoedovervej(){
		return GUI.getUserButtonPressed("�nsker du at k�be et hus/hotel p� R�dovervej for kr. 1000?", "Ja", "Nej");
	}
	public String buyHvidovervej(){
		return GUI.getUserButtonPressed("�nsker du at k�be et hus/hotel p� Hvidovervej for kr. 1000?", "Ja", "Nej");
	}
	public String buyRoskildevej(){
		return GUI.getUserButtonPressed("�nsker du at k�be et hus/hotel p� Roskildevej for kr. 1000?", "Ja", "Nej");
	}
	public String buyValbyLanggade(){
		return GUI.getUserButtonPressed("�nsker du at k�be et hus/hotel p� Valby Langgade for kr. 1000?", "Ja", "Nej");
	}
	public String buyAllegade(){
		return GUI.getUserButtonPressed("�nsker du at k�be et hus/hotel p� All�gade for kr. 1000?", "Ja", "Nej");
	}
	public String buyFredriksbergAlle(){
		return GUI.getUserButtonPressed("�nsker du at k�be et hus/hotel p� Fredriksberg All� for kr. 2000?", "Ja", "Nej");
	}
	public String buyBulowsvej(){
		return GUI.getUserButtonPressed("�nsker du at k�be et hus/hotel p� Bulowsvej for kr. 2000?", "Ja", "Nej");
	}
	public String buyGlKongevej(){
		return GUI.getUserButtonPressed("�nsker du at k�be et hus/hotel p� Gl Kongevej for kr. 2000?", "Ja", "Nej");
	}
	public String buyBernstorffsvej(){
		return GUI.getUserButtonPressed("�nsker du at k�be et hus/hotel p� Bernstorffsvej for kr. 2000?", "Ja", "Nej");
	}
	public String buyHellerupvej(){
		return GUI.getUserButtonPressed("�nsker du at k�be et hus/hotel p� Hellerupvej for kr. 2000?", "Ja", "Nej");
	}
	public String buyStrandvejen(){
		return GUI.getUserButtonPressed("�nsker du at k�be et hus/hotel p� Strandvejen for kr. 2000?", "Ja", "Nej");
	}
	public String buyTrianglen(){
		return GUI.getUserButtonPressed("�nsker du at k�be et hus/hotel p� Trianglen for kr. 3000?", "Ja", "Nej");
	}
	public String buyOesterbrogade(){
		return GUI.getUserButtonPressed("�nsker du at k�be et hus/hotel p� �sterbrogade for kr. 3000?", "Ja", "Nej");
	}
	public String buyGroenningen(){
		return GUI.getUserButtonPressed("�nsker du at k�be et hus/hotel p� Gr�nningen for kr. 3000?", "Ja", "Nej");
	}
	public String buyBredgade(){
		return GUI.getUserButtonPressed("�nsker du at k�be et hus/hotel p� Bredgade for kr. 3000?", "Ja", "Nej");
	}
	public String buyKgsNytorv(){
		return GUI.getUserButtonPressed("�nsker du at k�be et hus/hotel p� Kgs Nytorv for kr. 3000?", "Ja", "Nej");
	}
	public String buyIstergade(){
		return GUI.getUserButtonPressed("�nsker du at k�be et hus/hotel p� �stergade for kr. 3000?", "Ja", "Nej");
	}
	public String buyAmagertorv(){
		return GUI.getUserButtonPressed("�nsker du at k�be et hus/hotel p� Amagertorv for kr. 4000?", "Ja", "Nej");
	}
	public String buyVimmelskaftet(){
		return GUI.getUserButtonPressed("�nsker du at k�be et hus/hotel p� Vimmelskaftet for kr. 4000?", "Ja", "Nej");
	}
	public String buyNygade(){
		return GUI.getUserButtonPressed("�nsker du at k�be et hus/hotel p� Nygade for kr. 4000?", "Ja", "Nej");
	}
	public String buyFrederiksberggade(){
		return GUI.getUserButtonPressed("�nsker du at k�be et hus/hotel p� Frederiksberggade for kr. 4000?", "Ja", "Nej");
	}
	public String buyRaadhuspladsen(){
		return GUI.getUserButtonPressed("�nsker du at k�be et hus/hotel p� R�dhuspladsen for kr. 4000?", "Ja", "Nej");
	}
	public void setHouse(int fieldNumber, int houseCount){
		GUI.setHouses(fieldNumber, houseCount);
	}
	public void setHotel(int fieldNumber, boolean hasHotel){
		GUI.setHotel(fieldNumber, hasHotel);
	}

}
