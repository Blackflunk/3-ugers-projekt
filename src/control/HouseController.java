package control;

import boundary.GUIcontroller;
import entity.DiceBox;
import entity.Player;
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
	//lav en funktion der checker om du har penge nok til at k�be. hvis man ikke har skal den sige (Du har desv�rre ikke nok til at k�be huse, rul venligts terningen)
	public int gethouses(int n){
		return board.getField(n).getNumberofhouses();
	}
	public int getHousePrice(int n){
		return board.getField(n).getHouseprice();
	}
	
	public void buildPlots(Player player, int n){
		if(n == 1){
			if(gethouses(1) <= gethouses(3)){
				if(GUIC.buyRoedovervej().equals("Ja")){
					player.account.addPoints(-getHousePrice(1));
					board.getField(1).setNumberofHouses(1);
					GUIC.setHouse(2, gethouses(1));
				}}
			if(gethouses(3) <= gethouses(1)){
				if(GUIC.buyHvidovervej().equals("Ja")){
					player.account.addPoints(-getHousePrice(3));
					board.getField(3).setNumberofHouses(1);
					GUIC.setHouse(4, gethouses(3));
				}}
		}
		if(n == 2){
			if(gethouses(6) <= gethouses(8) && gethouses(6) <= gethouses(9)){
				if(GUIC.buyRoskildevej().equals("Ja")){
					player.account.addPoints(-getHousePrice(6));
					board.getField(6).setNumberofHouses(1);
					GUIC.setHouse(7, gethouses(6));
				}}
			if(gethouses(8) <= gethouses(6) && gethouses(8) <= gethouses(9)){
				if(GUIC.buyValbyLanggade().equals("Ja")){
					player.account.addPoints(-getHousePrice(8));
					board.getField(8).setNumberofHouses(1);
					GUIC.setHouse(9, gethouses(8));
				}}
			if(gethouses(9) <= gethouses(6) && gethouses(9) <= gethouses(8)){
				if(GUIC.buyAllegade().equals("Ja")){
					player.account.addPoints(-getHousePrice(9));
					board.getField(9).setNumberofHouses(1);
					GUIC.setHouse(10, gethouses(9));
				}}
		}
		if(n == 3){
			if(gethouses(11) <= gethouses(13) && gethouses(11) <= gethouses(14)){
				if(GUIC.buyFredriksbergAlle().equals("Ja")){
					player.account.addPoints(-getHousePrice(11));
					board.getField(11).setNumberofHouses(1);
					GUIC.setHouse(12, gethouses(11));
				}}
			if(gethouses(13) <= gethouses(11) && gethouses(13) <= gethouses(14)){
				if(GUIC.buyBulowsvej().equals("Ja")){
					player.account.addPoints(-getHousePrice(13));
					board.getField(13).setNumberofHouses(1);
					GUIC.setHouse(14, gethouses(13));
				}}
			if(gethouses(14) <= gethouses(11) && gethouses(14) <= gethouses(13)){
				if(GUIC.buyGlKongevej().equals("Ja")){
					player.account.addPoints(-getHousePrice(14));
					board.getField(14).setNumberofHouses(1);
					GUIC.setHouse(15, gethouses(14));
				}}
		}
		if(n == 4){
			if(gethouses(16) <= gethouses(18) && gethouses(16) <= gethouses(19)){
				if(GUIC.buyBernstorffsvej().equals("Ja")){
					player.account.addPoints(-getHousePrice(16));
					board.getField(16).setNumberofHouses(1);
					GUIC.setHouse(17, gethouses(16));
				}}
			if(gethouses(18) <= gethouses(16) && gethouses(18) <= gethouses(19)){
				if(GUIC.buyHellerupvej().equals("Ja")){
					player.account.addPoints(-getHousePrice(18));
					board.getField(18).setNumberofHouses(1);
					GUIC.setHouse(19, gethouses(18));
				}}
			if(gethouses(19) <= gethouses(16) && gethouses(19) <= gethouses(18)){
				if(GUIC.buyStrandvejen().equals("Ja")){
					player.account.addPoints(-getHousePrice(19));
					board.getField(19).setNumberofHouses(1);
					GUIC.setHouse(20, gethouses(19));
				}}
		}
		
		if(n == 5){
			if(gethouses(21) <= gethouses(23) && gethouses(21) <= gethouses(24)){
				if(GUIC.buyTrianglen().equals("Ja")){
					player.account.addPoints(-getHousePrice(21));
					board.getField(21).setNumberofHouses(1);
					GUIC.setHouse(22, gethouses(21));
				}}
			if(gethouses(23) <= gethouses(21) && gethouses(23) <= gethouses(24)){
				if(GUIC.buyOesterbrogade().equals("Ja")){
					player.account.addPoints(-getHousePrice(23));
					board.getField(23).setNumberofHouses(1);
					GUIC.setHouse(24, gethouses(23));
				}}
			if(gethouses(24) <= gethouses(21) && gethouses(24) <= gethouses(23)){
				if(GUIC.buyGroenningen().equals("Ja")){
					player.account.addPoints(-getHousePrice(24));
					board.getField(24).setNumberofHouses(1);
					GUIC.setHouse(25, gethouses(24));
				}}
		}
		
		if(n == 6){
			if(gethouses(26) <= gethouses(27) && gethouses(26) <= gethouses(29)){
				if(GUIC.buyBredgade().equals("Ja")){
					player.account.addPoints(-getHousePrice(26));
					board.getField(26).setNumberofHouses(1);
					GUIC.setHouse(27, gethouses(26));
				}}
			if(gethouses(27) <= gethouses(26) && gethouses(27) <= gethouses(29)){
				if(GUIC.buyKgsNytorv().equals("Ja")){
					player.account.addPoints(-getHousePrice(27));
					board.getField(27).setNumberofHouses(1);
					GUIC.setHouse(28, gethouses(27));
				}}
			if(gethouses(29) <= gethouses(26) && gethouses(29) <= gethouses(27)){
				if(GUIC.buyIstergade().equals("Ja")){
					player.account.addPoints(-getHousePrice(29));
					board.getField(29).setNumberofHouses(1);
					GUIC.setHouse(30, gethouses(29));
				}}
		}
		
		if(n == 7){
			if(gethouses(31) <= gethouses(32) && gethouses(31) <= gethouses(34)){
				if(GUIC.buyAmagertorv().equals("Ja")){
					player.account.addPoints(-getHousePrice(31));
					board.getField(31).setNumberofHouses(1);
					GUIC.setHouse(32, gethouses(31));
				}}
			if(gethouses(32) <= gethouses(31) && gethouses(32) <= gethouses(34)){
				if(GUIC.buyVimmelskaftet().equals("Ja")){
					player.account.addPoints(-getHousePrice(32));
					board.getField(32).setNumberofHouses(1);
					GUIC.setHouse(33, gethouses(32));
				}}
			if(gethouses(34) <= gethouses(31) && gethouses(34) <= gethouses(32)){
				if(GUIC.buyNygade().equals("Ja")){
					player.account.addPoints(-getHousePrice(34));
					board.getField(34).setNumberofHouses(1);
					GUIC.setHouse(35, gethouses(34));
				}}
		}
		if(n == 8){
			if(gethouses(37) <= gethouses(39)){
				if(GUIC.buyFrederiksberggade().equals("Ja")){
					player.account.addPoints(-getHousePrice(37));
					board.getField(37).setNumberofHouses(1);
					GUIC.setHouse(38, gethouses(37));
				}}
			if(gethouses(39) <= gethouses(37)){
				if(GUIC.buyRaadhuspladsen().equals("Ja")){
					player.account.addPoints(-getHousePrice(39));
					board.getField(39).setNumberofHouses(1);
					GUIC.setHouse(40, gethouses(39));
				}}
		}
	}
}
