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
					}GUIC.offerToBuy(possibleBuild);
					if(GUIC.offerToBuy(possibleBuild).equals("Ja")){
						for(int i=1; i<=8; i++){
							if(getBuild(i, player) == true){
								buildPlots(i);
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
	
	public int gethouses(int n){
		return board.getField(n).getNumberofhouses();
	}
	
	public void buildPlots(int n){
		if(n == 1){
			if(gethouses(1) <= gethouses(3)){
			GUIC.buyRoedovervej();
			if(GUIC.buyRoedovervej().equals("Ja")){
				board.getField(1).setNumberofHouses(1);
				GUIC.setHouse(1, gethouses(1));
			}}
			if(gethouses(3) <= gethouses(1)){
			GUIC.buyHvidovervej();
			if(GUIC.buyHvidovervej().equals("Ja")){
				board.getField(3).setNumberofHouses(1);
				GUIC.setHouse(3, 1);
			}}
		}
		if(n == 2){
			if(gethouses(6) <= gethouses(8) && gethouses(6) <= gethouses(9)){
			GUIC.buyRoskildevej();
			if(GUIC.buyRoskildevej().equals("Ja")){
				board.getField(6).setNumberofHouses(1);
				GUIC.setHouse(6, 1);
			}}
			if(gethouses(8) <= gethouses(6) && gethouses(8) <= gethouses(9)){
			GUIC.buyValbyLanggade();
			if(GUIC.buyValbyLanggade().equals("Ja")){
				board.getField(8).setNumberofHouses(1);
				GUIC.setHouse(8, 1);
			}}
			if(gethouses(9) <= gethouses(8) && gethouses(9) <= gethouses(6)){
			GUIC.buyAllegade();
			if(GUIC.buyAllegade().equals("Ja")){
				board.getField(9).setNumberofHouses(1);
				GUIC.setHouse(9, 1);
			}}
		}
		if(n == 3){
			if(gethouses(11) <= gethouses(13) && gethouses(11) <= gethouses(14)){
			GUIC.buyFredriksbergAlle();
			if(GUIC.buyFredriksbergAlle().equals("Ja")){
				board.getField(11).setNumberofHouses(1);
				GUIC.setHouse(11, 1);
			}}
			if(gethouses(13) <= gethouses(11) && gethouses(13) <= gethouses(14)){
			GUIC.buyBulowsvej();
			if(GUIC.buyBulowsvej().equals("Ja")){
				board.getField(13).setNumberofHouses(1);
				GUIC.setHouse(13, 1);
			}}
			if(gethouses(14) <= gethouses(11) && gethouses(14) <= gethouses(13)){
			GUIC.buyGlKongevej();
			if(GUIC.buyGlKongevej().equals("Ja")){
				board.getField(14).setNumberofHouses(1);
				GUIC.setHouse(14, 1);
			}}
		}
		if(n == 4){
			if(gethouses(16) <= gethouses(18) && gethouses(16) <= gethouses(19)){
			GUIC.buyBernstorffsvej();
			if(GUIC.buyBernstorffsvej().equals("Ja")){
				board.getField(16).setNumberofHouses(1);
				GUIC.setHouse(16, 1);
			}}
			if(gethouses(18) <= gethouses(16) && gethouses(18) <= gethouses(19)){
			GUIC.buyHellerupvej();
			if(GUIC.buyHellerupvej().equals("Ja")){
				board.getField(18).setNumberofHouses(1);
				GUIC.setHouse(18, 1);
			}}
			if(gethouses(19) <= gethouses(16) && gethouses(19) <= gethouses(18)){
			GUIC.buyStrandvejen();
			if(GUIC.buyStrandvejen().equals("Ja")){
				board.getField(19).setNumberofHouses(1);
				GUIC.setHouse(19, 1);
			}}
		}
		
		if(n == 5){
			if(gethouses(21) <= gethouses(23) && gethouses(21) <= gethouses(24)){
			GUIC.buyTrianglen();
			if(GUIC.buyTrianglen().equals("Ja")){
				board.getField(21).setNumberofHouses(1);
				GUIC.setHouse(21, 1);
			}}
			if(gethouses(23) <= gethouses(21) && gethouses(23) <= gethouses(24)){
			GUIC.buyOesterbrogade();
			if(GUIC.buyOesterbrogade().equals("Ja")){
				board.getField(23).setNumberofHouses(1);
				GUIC.setHouse(23, 1);
			}}
			if(gethouses(24) <= gethouses(21) && gethouses(24) <= gethouses(23)){
			GUIC.buyGroenningen();
			if(GUIC.buyGroenningen().equals("Ja")){
				board.getField(24).setNumberofHouses(1);
				GUIC.setHouse(24, 1);
			}}
		}
		
		if(n == 6){
			if(gethouses(26) <= gethouses(27) && gethouses(26) <= gethouses(29)){
			GUIC.buyBredgade();
			if(GUIC.buyBredgade().equals("Ja")){
				board.getField(26).setNumberofHouses(1);
				GUIC.setHouse(26, 1);
			}}
			if(gethouses(27) <= gethouses(26) && gethouses(27) <= gethouses(29)){
			GUIC.buyKgsNytorv();
			if(GUIC.buyKgsNytorv().equals("Ja")){
				board.getField(27).setNumberofHouses(1);
				GUIC.setHouse(27, 1);
			}}
			if(gethouses(29) <= gethouses(26) && gethouses(29) <= gethouses(27)){
			GUIC.buyIstergade();
			if(GUIC.buyIstergade().equals("Ja")){
				board.getField(29).setNumberofHouses(1);
				GUIC.setHouse(29, 1);
			}}
		}
		
		if(n == 7){
			if(gethouses(31) <= gethouses(32) && gethouses(31) <= gethouses(34)){
			GUIC.buyAmagertorv();
			if(GUIC.buyAmagertorv().equals("Ja")){
				board.getField(31).setNumberofHouses(1);
				GUIC.setHouse(31, 1);
			}}
			if(gethouses(32) <= gethouses(31) && gethouses(32) <= gethouses(34)){
			GUIC.buyVimmelskaftet();
			if(GUIC.buyVimmelskaftet().equals("Ja")){
				board.getField(32).setNumberofHouses(1);
				GUIC.setHouse(32, 1);
			}}
			if(gethouses(34) <= gethouses(31) && gethouses(34) <= gethouses(32)){
			GUIC.buyNygade();
			if(GUIC.buyNygade().equals("Ja")){
				board.getField(34).setNumberofHouses(1);
				GUIC.setHouse(34, 1);
			}}
		}
		if(n == 8){
			if(gethouses(37) <= gethouses(39)){
			GUIC.buyFrederiksberggade();
			if(GUIC.buyFrederiksberggade().equals("Ja")){
				board.getField(37).setNumberofHouses(1);
				GUIC.setHouse(37, 1);
			}}
			if(gethouses(39) <= gethouses(37)){
			GUIC.buyRaadhuspladsen();
			if(GUIC.buyRaadhuspladsen().equals("Ja")){
				board.getField(39).setNumberofHouses(1);
				GUIC.setHouse(39, 1);
			}}
		}
	}
}
