package control;

import game.DiceBox;
import game.Player;
import boundary.GUIcontroller;
import fields.GameBoard;


public class HouseController {
	private GUIcontroller GUIC;
	private GameBoard board;
	private Player[] playerlist;
	private boolean khan = true;
	private String possibleBuild;
	
	public HouseController(GUIcontroller GUIC, GameBoard board,Player[] playerlist){
		this.board =board;
		this.GUIC = GUIC;
		this.playerlist = playerlist;
		possibleBuild = " ";
	}
	
	public void Housing(Player player, int currentPlayer){
		//check if you can buy.
		if(player.getBuy_Blue()== true||player.getBuy_Pink()== true||player.getBuy_Green()== true
				||player.getBuy_grey()== true||player.getBuy_Red()== true||player.getBuy_White() == true
				||player.getBuy_Yellow()== true||player.getBuy_Magenta()== true){
					for(int i=1; i<=8; i++){
						if(getBuild(i, player) == true && getPriceAndValue() == true){
							getRoad(i);
						}
					}
					if(GUIC.offerToBuy(possibleBuild).equals("Ja")){
						for(int i=1; i<=8; i++){
							if(getBuild(i, player) == true){
								buildPlots(player,i);
							}
					
					}
				}
		}		
	}
	
	
	public void checkOwnedFields(Player player){
		checkBlue(player);
		checkPink(player);
		checkGreen(player);
		checkGrey(player);
		checkRed(player);
		checkWhite(player);
		checkYellow(player);
		checkMagneta(player);
	}
	public void checkBlue(Player player){
		if(player.getFieldammount_blue() == 2){
			player.setBuy_Blue(khan);
		}
	}
	
	public void checkPink(Player player){
		if(player.getFieldammount_pink() == 3){
			player.setBuy_Pink(khan);
		}
	}
	
	public void checkGreen(Player player){
		if(player.getFieldammount_green() == 3){
			player.setBuy_Green(khan);
		}
	}
	
	public void checkGrey(Player player){
		if(player.getFieldammount_grey() == 3){
			player.setBuy_grey(khan);
		}
	}
	
	public void checkRed(Player player){
		if(player.getFieldammount_red() == 3){
			player.setBuy_Red(khan);
		}
	}
	
	public void checkWhite(Player player){
		if(player.getFieldammount_white() == 3){
			player.setBuy_White(khan);
		}
	}
	
	public void checkYellow(Player player){
		if(player.getFieldammount_yellow() == 3){
			player.setBuy_Yellow(khan);
		}
	}
	
	public void checkMagneta(Player player){
		if(player.getFieldammount_magenta() == 2){
			player.setBuy_Magenta(khan);
		}
	}

	public boolean getBuild(int n, Player player){
		if(n == 1){
			return player.getBuy_Blue();
		}
		else if(n == 2){
			return player.getBuy_Pink();
		}
		else if(n == 3){
			return player.getBuy_Green();
		}
		else if(n == 4){
			return player.getBuy_grey();
		}
		else if(n == 5){
			return player.getBuy_Red();
		}
		else if(n == 6){
			return player.getBuy_White();
		}
		else if(n == 7){
			return player.getBuy_Yellow();
		}
		else if(n == 8){
			return player.getBuy_Magenta();
		}
		return false;
	}
	
	public boolean getPriceAndValue(){
		return true;
		
	}
	
	public void getRoad(int n){
		if(n == 1){
			possibleBuild += " Roedovervej og Hvidovervej";
		}
		else if(n == 2){
			possibleBuild += " Roskildevej, Valby Langgade og Allegade";
		}
		else if(n == 3){
			possibleBuild += " Fredriksberg Alle, Bulowsvej og GL Kongevej";
		}
		else if(n == 4){
			possibleBuild += " Bernstorffsvej, Hellerupvej og Strandvej";
		}
		else if(n == 5){
			possibleBuild += " Trianglen, Oesterbrogade og Groenningen";
		}
		else if(n == 6){
			possibleBuild += " Bredgade, Kgs Nytorv og Istergade";
		}
		else if(n == 7){
			possibleBuild += " Amagertorv, Vimmelskaftet og Nygade";
		}
		else if(n == 8){
			possibleBuild += " Frederiksberggade og Raedhuspladsen";
		}
	}
	//lav en funktion der checker om du har penge nok til at købe. hvis man ikke har skal den sige (Du har desværre ikke nok til at købe huse, rul venligts terningen)
	public int gethouses(int n){
		return board.getField(n).getNumberofhouses();
	}
	public int getHousePrice(int n){
		return board.getField(n).getHouseprice();
	}
	
	public void buildPlots(Player player, int n){
		if(n == 1){
			if(gethouses(2) <= gethouses(4)){
				if(GUIC.buyRoedovervej().equals("Ja")){
					player.account.addPoints(-getHousePrice(2));
					board.getField(2).setNumberofHouses(1);
					GUIC.setHouse(2, gethouses(2));
				}}
			if(gethouses(4) <= gethouses(2)){
				if(GUIC.buyHvidovervej().equals("Ja")){
					player.account.addPoints(-getHousePrice(4));
					board.getField(4).setNumberofHouses(1);
					GUIC.setHouse(4, gethouses(4));
				}}
		}
		if(n == 2){
			if(gethouses(7) <= gethouses(9) && gethouses(7) <= gethouses(10)){
				if(GUIC.buyRoskildevej().equals("Ja")){
					player.account.addPoints(-getHousePrice(7));
					board.getField(7).setNumberofHouses(1);
					GUIC.setHouse(7, gethouses(7));
				}}
			if(gethouses(9) <= gethouses(7) && gethouses(9) <= gethouses(10)){
				if(GUIC.buyValbyLanggade().equals("Ja")){
					player.account.addPoints(-getHousePrice(9));
					board.getField(9).setNumberofHouses(1);
					GUIC.setHouse(9, gethouses(9));
				}}
			if(gethouses(10) <= gethouses(9) && gethouses(10) <= gethouses(7)){
				if(GUIC.buyAllegade().equals("Ja")){
					player.account.addPoints(-getHousePrice(10));
					board.getField(10).setNumberofHouses(1);
					GUIC.setHouse(10, gethouses(10));
				}}
		}
		if(n == 3){
			if(gethouses(12) <= gethouses(14) && gethouses(12) <= gethouses(15)){
				if(GUIC.buyFredriksbergAlle().equals("Ja")){
					player.account.addPoints(-getHousePrice(12));
					board.getField(12).setNumberofHouses(1);
					GUIC.setHouse(12, gethouses(12));
				}}
			if(gethouses(14) <= gethouses(12) && gethouses(14) <= gethouses(15)){
				if(GUIC.buyBulowsvej().equals("Ja")){
					player.account.addPoints(-getHousePrice(14));
					board.getField(14).setNumberofHouses(1);
					GUIC.setHouse(14, gethouses(14));
				}}
			if(gethouses(15) <= gethouses(12) && gethouses(15) <= gethouses(14)){
				if(GUIC.buyGlKongevej().equals("Ja")){
					player.account.addPoints(-getHousePrice(15));
					board.getField(15).setNumberofHouses(1);
					GUIC.setHouse(15, gethouses(15));
				}}
		}
		if(n == 4){
			if(gethouses(17) <= gethouses(19) && gethouses(17) <= gethouses(20)){
				if(GUIC.buyBernstorffsvej().equals("Ja")){
					player.account.addPoints(-getHousePrice(17));
					board.getField(17).setNumberofHouses(1);
					GUIC.setHouse(17, 1);
				}}
			if(gethouses(19) <= gethouses(17) && gethouses(19) <= gethouses(20)){
				if(GUIC.buyHellerupvej().equals("Ja")){
					player.account.addPoints(-getHousePrice(19));
					board.getField(19).setNumberofHouses(1);
					GUIC.setHouse(19, 1);
				}}
			if(gethouses(20) <= gethouses(17) && gethouses(20) <= gethouses(19)){
				if(GUIC.buyStrandvejen().equals("Ja")){
					player.account.addPoints(-getHousePrice(20));
					board.getField(20).setNumberofHouses(1);
					GUIC.setHouse(20, 1);
				}}
		}
		
		if(n == 5){
			if(gethouses(22) <= gethouses(24) && gethouses(22) <= gethouses(25)){
				if(GUIC.buyTrianglen().equals("Ja")){
					player.account.addPoints(-getHousePrice(22));
					board.getField(22).setNumberofHouses(1);
					GUIC.setHouse(22, 1);
				}}
			if(gethouses(24) <= gethouses(22) && gethouses(24) <= gethouses(25)){
				if(GUIC.buyOesterbrogade().equals("Ja")){
					player.account.addPoints(-getHousePrice(24));
					board.getField(24).setNumberofHouses(1);
					GUIC.setHouse(24, 1);
				}}
			if(gethouses(25) <= gethouses(22) && gethouses(25) <= gethouses(24)){
				if(GUIC.buyGroenningen().equals("Ja")){
					player.account.addPoints(-getHousePrice(25));
					board.getField(25).setNumberofHouses(1);
					GUIC.setHouse(25, 1);
				}}
		}
		
		if(n == 6){
			if(gethouses(27) <= gethouses(28) && gethouses(27) <= gethouses(30)){
				if(GUIC.buyBredgade().equals("Ja")){
					player.account.addPoints(-getHousePrice(27));
					board.getField(27).setNumberofHouses(1);
					GUIC.setHouse(27, 1);
				}}
			if(gethouses(28) <= gethouses(27) && gethouses(28) <= gethouses(30)){
				if(GUIC.buyKgsNytorv().equals("Ja")){
					player.account.addPoints(-getHousePrice(28));
					board.getField(28).setNumberofHouses(1);
					GUIC.setHouse(28, 1);
				}}
			if(gethouses(30) <= gethouses(27) && gethouses(30) <= gethouses(28)){
				if(GUIC.buyIstergade().equals("Ja")){
					player.account.addPoints(-getHousePrice(30));
					board.getField(30).setNumberofHouses(1);
					GUIC.setHouse(30, 1);
				}}
		}
		
		if(n == 7){
			if(gethouses(32) <= gethouses(33) && gethouses(32) <= gethouses(35)){
				if(GUIC.buyAmagertorv().equals("Ja")){
					player.account.addPoints(-getHousePrice(32));
					board.getField(32).setNumberofHouses(1);
					GUIC.setHouse(32, 1);
				}}
			if(gethouses(33) <= gethouses(32) && gethouses(33) <= gethouses(35)){
				if(GUIC.buyVimmelskaftet().equals("Ja")){
					player.account.addPoints(-getHousePrice(33));
					board.getField(33).setNumberofHouses(1);
					GUIC.setHouse(33, 1);
				}}
			if(gethouses(35) <= gethouses(32) && gethouses(35) <= gethouses(33)){
				if(GUIC.buyNygade().equals("Ja")){
					player.account.addPoints(-getHousePrice(35));
					board.getField(35).setNumberofHouses(1);
					GUIC.setHouse(35, 1);
				}}
		}
		if(n == 8){
			if(gethouses(38) <= gethouses(40)){
				if(GUIC.buyFrederiksberggade().equals("Ja")){
					player.account.addPoints(-getHousePrice(38));
					board.getField(38).setNumberofHouses(1);
					GUIC.setHouse(38, 1);
				}}
			if(gethouses(40) <= gethouses(38)){
				if(GUIC.buyRaadhuspladsen().equals("Ja")){
					player.account.addPoints(-getHousePrice(40));
					board.getField(40).setNumberofHouses(1);
					GUIC.setHouse(40, 1);
				}}
		}
	}
}
