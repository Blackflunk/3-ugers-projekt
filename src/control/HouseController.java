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
						if(getBuild(i, player) == true){
							getRoad(i);
						}
					}GUIC.offerToBuy(possibleBuild);
					if(GUIC.offerToBuy(possibleBuild) == "Ja"){
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
	
	public void buildPlots(int n){
		if(n == 1){
			GUIC.buyRoedovervej();
			if(GUIC.buyRoedovervej().equals("Ja")){
				board.getField(1).setNumberofHouses(1);
			}
			GUIC.buyHvidovervej();
			if(GUIC.buyHvidovervej().equals("Ja")){
				board.getField(3).setNumberofHouses(1);
			}
		}
		if(n == 2){
			GUIC.buyRoskildevej();
			if(GUIC.buyRoskildevej().equals("Ja")){
				board.getField(6).setNumberofHouses(1);
			}
			GUIC.buyValbyLanggade();
			if(GUIC.buyValbyLanggade().equals("Ja")){
				board.getField(8).setNumberofHouses(1);
			}
			GUIC.buyAllegade();
			if(GUIC.buyAllegade().equals("Ja")){
				board.getField(9).setNumberofHouses(1);
			}
		}
		if(n == 3){
			GUIC.buyFredriksbergAlle();
			if(GUIC.buyFredriksbergAlle().equals("Ja")){
				board.getField(11).setNumberofHouses(1);
			}
			GUIC.buyBulowsvej();
			if(GUIC.buyBulowsvej().equals("Ja")){
				board.getField(13).setNumberofHouses(1);
			}
			GUIC.buyGlKongevej();
			if(GUIC.buyGlKongevej().equals("Ja")){
				board.getField(14).setNumberofHouses(1);
			}
		}
		if(n == 4){
			GUIC.buyBernstorffsvej();
			if(GUIC.buyBernstorffsvej().equals("Ja")){
				board.getField(16).setNumberofHouses(1);
			}
			GUIC.buyHellerupvej();
			if(GUIC.buyHellerupvej().equals("Ja")){
				board.getField(18).setNumberofHouses(1);
			}
			GUIC.buyStrandvejen();
			if(GUIC.buyStrandvejen().equals("Ja")){
				board.getField(19).setNumberofHouses(1);
			}
		}
		
		if(n == 5){
			GUIC.buyTrianglen();
			if(GUIC.buyTrianglen().equals("Ja")){
				board.getField(21).setNumberofHouses(1);
			}
			GUIC.buyOesterbrogade();
			if(GUIC.buyOesterbrogade().equals("Ja")){
				board.getField(23).setNumberofHouses(1);
			}
			GUIC.buyGroenningen();
			if(GUIC.buyGroenningen().equals("Ja")){
				board.getField(24).setNumberofHouses(1);
			}
		}
		
		if(n == 6){
			GUIC.buyBredgade();
			if(GUIC.buyBredgade().equals("Ja")){
				board.getField(26).setNumberofHouses(1);
			}
			GUIC.buyKgsNytorv();
			if(GUIC.buyKgsNytorv().equals("Ja")){
				board.getField(27).setNumberofHouses(1);
			}
			GUIC.buyIstergade();
			if(GUIC.buyIstergade().equals("Ja")){
				board.getField(29).setNumberofHouses(1);
			}
		}
		
		if(n == 7){
			GUIC.buyAmagertorv();
			if(GUIC.buyAmagertorv().equals("Ja")){
				board.getField(31).setNumberofHouses(1);
			}
			GUIC.buyVimmelskaftet();
			if(GUIC.buyVimmelskaftet().equals("Ja")){
				board.getField(32).setNumberofHouses(1);
			}
			GUIC.buyNygade();
			if(GUIC.buyNygade().equals("Ja")){
				board.getField(34).setNumberofHouses(1);
			}
		}
		if(n == 8){
			GUIC.buyFrederiksberggade();
			if(GUIC.buyFrederiksberggade().equals("Ja")){
				board.getField(37).setNumberofHouses(1);
			}
			GUIC.buyRaadhuspladsen();
			if(GUIC.buyRaadhuspladsen().equals("Ja")){
				board.getField(39).setNumberofHouses(1);
			}
		}
	}
}
