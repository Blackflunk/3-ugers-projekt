package control;

import desktop_resources.GUI;
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
	boolean moreHouses = true;
	
	public HouseController(GUIcontroller GUIC, GameBoard board,Player[] playerlist){
		this.board =board;
		this.GUIC = GUIC;
		this.playerlist = playerlist;
		this.board = board;
	}
	
	public void buyHouse(Player player, int currentPlayer){
		//check if you can buy.
		possibleBuild = " ";
		while(moreHouses== true){
		if(player.getBuy_Blue()== true||player.getBuy_Pink()== true||player.getBuy_Green()== true
				||player.getBuy_grey()== true||player.getBuy_Red()== true||player.getBuy_White() == true
				||player.getBuy_Yellow()== true||player.getBuy_Magenta()== true){
					for(int i=1; i<=8; i++){
						if(getPriceAndValue(player, i, board) == true){
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
			}if(GUIC.offerMoreHouses()==false){
				moreHouses=false;
			}
		}	
	}
	
	//sell house
	public void sellHouse(Player player, int currentPlayer){
		
		if(GUIC.offerToSellHouse().equals("Ja"));
		
		possibleBuild = " ";
		if(player.getBuy_Blue()== true||player.getBuy_Pink()== true||player.getBuy_Green()== true
				||player.getBuy_grey()== true||player.getBuy_Red()== true||player.getBuy_White() == true
				||player.getBuy_Yellow()== true||player.getBuy_Magenta()== true){
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
	
	public boolean getPriceAndValue(Player player, int n, GameBoard board){
		if(n == 1){
			if(player.getBuy_Blue() == true){
				if(player.account.getScore() >= board.getField(player.getPosition()).getPrice()){
					return true;	
				}
			}	
		}
		else if(n == 2){
			if(player.getBuy_Pink() == true){
				if(player.account.getScore() >= board.getField(player.getPosition()).getPrice()){
					return true;
				}
			}	
		}
		else if(n == 3){
			if(player.getBuy_Green() == true){
				if(player.account.getScore() >= board.getField(player.getPosition()).getPrice()){
					return true;
				}
			}	
		}
		else if(n == 4){
			if(player.getBuy_grey() == true){
				if(player.account.getScore() >= board.getField(player.getPosition()).getPrice()){
					return true;
				}
			}	
		}
		else if(n == 5){
			if(player.getBuy_Red() == true){
				if(player.account.getScore() >= board.getField(player.getPosition()).getPrice()){
					return true;
				}
			}	
		}
		else if(n == 6){
			if(player.getBuy_White() == true){
				if(player.account.getScore() >= board.getField(player.getPosition()).getPrice()){
					return true;
				}
			}	
		}
		else if(n == 7){
			if(player.getBuy_Yellow() == true){
				if(player.account.getScore() >= board.getField(player.getPosition()).getPrice()){
					return true;
				}
			}	
		}
		else if(n == 8){
			if(player.getBuy_Magenta() == true){
				if(player.account.getScore() >= board.getField(player.getPosition()).getPrice()){
					return true;
				}
			}	
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
	public void setHotel(Player player){
		player.addHouseammount(-4);
		player.addHotelammount(1);
	}
	public int gethouses(int n){
		return board.getField(n).getNumberofhouses();
	}
	public int getHousePrice(int n){
		return board.getField(n).getHouseprice();
	}
	
	public void buildPlots(Player player, int n){
		if(n == 1){
			if(gethouses(1) <= gethouses(3)){
				if(board.getField(1).getNumberofhouses()<5){
					if(GUIC.buyRoedovervej().equals("Ja")){
						player.account.addPoints(-getHousePrice(1));
						board.getField(1).setNumberofHouses(1);
						if(board.getField(1).getNumberofhouses()==5){
							GUIC.setHotel(2,true);
							setHotel(player);
						}else{
						GUIC.setHouse(2, gethouses(1));
						player.addHouseammount(1);
						}
					}}}
			if(gethouses(3) <= gethouses(1)){
				if(board.getField(3).getNumberofhouses()<5){
					if(GUIC.buyHvidovervej().equals("Ja")){
						player.account.addPoints(-getHousePrice(3));
						board.getField(3).setNumberofHouses(1);
						if(board.getField(3).getNumberofhouses()==5){
							GUIC.setHotel(4,true);
							setHotel(player);
						}else{
						GUIC.setHouse(4, gethouses(3));
						player.addHouseammount(1);
						}
					}}}
		}
		if(n == 2){
			if(gethouses(6) <= gethouses(8) && gethouses(6) <= gethouses(9)){
				if(board.getField(6).getNumberofhouses()<5){
					if(GUIC.buyRoskildevej().equals("Ja")){
						player.account.addPoints(-getHousePrice(6));
						board.getField(6).setNumberofHouses(1);
						if(board.getField(6).getNumberofhouses()==5){
							GUIC.setHotel(7,true);
							setHotel(player);
						}else{
						GUIC.setHouse(7, gethouses(6));
						player.addHouseammount(1);
						}}}}
			if(gethouses(8) <= gethouses(6) && gethouses(8) <= gethouses(9)){
				if(board.getField(8).getNumberofhouses()<5){
					if(GUIC.buyValbyLanggade().equals("Ja")){
						player.account.addPoints(-getHousePrice(8));
						board.getField(8).setNumberofHouses(1);
						if(board.getField(8).getNumberofhouses()==5){
							GUIC.setHotel(9,true);
							setHotel(player);
						}else{
						GUIC.setHouse(9, gethouses(8));
						player.addHouseammount(1);
						}}}}
			if(gethouses(9) <= gethouses(6) && gethouses(9) <= gethouses(8)){
				if(board.getField(9).getNumberofhouses()<5){
					if(GUIC.buyAllegade().equals("Ja")){
						player.account.addPoints(-getHousePrice(9));
						board.getField(9).setNumberofHouses(1);
						if(board.getField(9).getNumberofhouses()==5){
							GUIC.setHotel(10,true);
							setHotel(player);
						}else{
						GUIC.setHouse(10, gethouses(9));
						player.addHouseammount(1);
						}}}}
		}
		if(n == 3){
			if(gethouses(11) <= gethouses(13) && gethouses(11) <= gethouses(14)){
				if(board.getField(11).getNumberofhouses()<5){
					if(GUIC.buyFredriksbergAlle().equals("Ja")){
						player.account.addPoints(-getHousePrice(11));
						board.getField(11).setNumberofHouses(1);
						if(board.getField(11).getNumberofhouses()==5){
							GUIC.setHotel(12,true);
							setHotel(player);
						}else{
						GUIC.setHouse(12, gethouses(11));
						player.addHouseammount(1);
						}}}}
			if(gethouses(13) <= gethouses(11) && gethouses(13) <= gethouses(14)){
				if(board.getField(13).getNumberofhouses()<5){
					if(GUIC.buyBulowsvej().equals("Ja")){
						player.account.addPoints(-getHousePrice(13));
						board.getField(13).setNumberofHouses(1);
						if(board.getField(13).getNumberofhouses()==5){
							GUIC.setHotel(14,true);
							setHotel(player);
						}else{
						GUIC.setHouse(14, gethouses(13));
						player.addHouseammount(1);
						}}}}
			if(gethouses(14) <= gethouses(11) && gethouses(14) <= gethouses(13)){
				if(board.getField(14).getNumberofhouses()<5){
					if(GUIC.buyGlKongevej().equals("Ja")){
						player.account.addPoints(-getHousePrice(14));
						board.getField(14).setNumberofHouses(1);
						if(board.getField(14).getNumberofhouses()==5){
							GUIC.setHotel(15,true);
							setHotel(player);
						}else{
						GUIC.setHouse(15, gethouses(14));
						player.addHouseammount(1);
						}}}}
		}
		if(n == 4){
			if(gethouses(16) <= gethouses(18) && gethouses(16) <= gethouses(19)){
				if(board.getField(16).getNumberofhouses()<5){
					if(GUIC.buyBernstorffsvej().equals("Ja")){
						player.account.addPoints(-getHousePrice(16));
						board.getField(16).setNumberofHouses(1);
						if(board.getField(16).getNumberofhouses()==5){
							GUIC.setHotel(17,true);
							setHotel(player);
						}else{
						GUIC.setHouse(17, gethouses(16));
						player.addHouseammount(1);
						}}}}
			if(gethouses(18) <= gethouses(16) && gethouses(18) <= gethouses(19)){
				if(board.getField(18).getNumberofhouses()<5){
					if(GUIC.buyHellerupvej().equals("Ja")){
						player.account.addPoints(-getHousePrice(18));
						board.getField(18).setNumberofHouses(1);
						if(board.getField(18).getNumberofhouses()==5){
							GUIC.setHotel(19,true);
							setHotel(player);
						}else{
						GUIC.setHouse(19, gethouses(18));
						player.addHouseammount(1);
						}}}}
			if(gethouses(19) <= gethouses(16) && gethouses(19) <= gethouses(18)){
				if(board.getField(19).getNumberofhouses()<5){
					if(GUIC.buyStrandvejen().equals("Ja")){
						player.account.addPoints(-getHousePrice(19));
						board.getField(19).setNumberofHouses(1);
						if(board.getField(19).getNumberofhouses()==5){
							GUIC.setHotel(20,true);
							setHotel(player);
						}else{
						GUIC.setHouse(20, gethouses(19));
						player.addHouseammount(1);
						}}}}
		}
		
		if(n == 5){
			if(gethouses(21) <= gethouses(23) && gethouses(21) <= gethouses(24)){
				if(board.getField(21).getNumberofhouses()<5){
					if(GUIC.buyTrianglen().equals("Ja")){
						player.account.addPoints(-getHousePrice(21));
						board.getField(21).setNumberofHouses(1);
						if(board.getField(21).getNumberofhouses()==5){
							GUIC.setHotel(22,true);
							setHotel(player);
						}else{
						GUIC.setHouse(22, gethouses(21));
						player.addHouseammount(1);
						}}}}
			if(gethouses(23) <= gethouses(21) && gethouses(23) <= gethouses(24)){
				if(board.getField(23).getNumberofhouses()<5){
					if(GUIC.buyOesterbrogade().equals("Ja")){
						player.account.addPoints(-getHousePrice(23));
						board.getField(23).setNumberofHouses(1);
						if(board.getField(23).getNumberofhouses()==5){
							GUIC.setHotel(24,true);
							setHotel(player);
						}else{
						GUIC.setHouse(24, gethouses(23));
						player.addHouseammount(1);
						}}}}
			if(gethouses(24) <= gethouses(21) && gethouses(24) <= gethouses(23)){
				if(board.getField(24).getNumberofhouses()<5){
					if(GUIC.buyGroenningen().equals("Ja")){
						player.account.addPoints(-getHousePrice(24));
						board.getField(24).setNumberofHouses(1);
						if(board.getField(24).getNumberofhouses()==5){
							GUIC.setHotel(25,true);
							setHotel(player);
						}else{
						GUIC.setHouse(25, gethouses(24));
						player.addHouseammount(1);
						}}}}
		}
		
		if(n == 6){
			if(gethouses(26) <= gethouses(27) && gethouses(26) <= gethouses(29)){
				if(board.getField(26).getNumberofhouses()<5){
					if(GUIC.buyBredgade().equals("Ja")){
						player.account.addPoints(-getHousePrice(26));
						board.getField(26).setNumberofHouses(1);
						if(board.getField(26).getNumberofhouses()==5){
							GUIC.setHotel(27,true);
							setHotel(player);
						}else{
						GUIC.setHouse(27, gethouses(26));
						player.addHouseammount(1);
						}}}}
			if(gethouses(27) <= gethouses(26) && gethouses(27) <= gethouses(29)){
				if(board.getField(27).getNumberofhouses()<5){
					if(GUIC.buyKgsNytorv().equals("Ja")){
						player.account.addPoints(-getHousePrice(27));
						board.getField(27).setNumberofHouses(1);
						if(board.getField(27).getNumberofhouses()==5){
							GUIC.setHotel(28,true);
							setHotel(player);
						}else{
						GUIC.setHouse(28, gethouses(27));
						player.addHouseammount(1);
						}}}}
			if(gethouses(29) <= gethouses(26) && gethouses(29) <= gethouses(27)){
				if(board.getField(29).getNumberofhouses()<5){
					if(GUIC.buyIstergade().equals("Ja")){
						player.account.addPoints(-getHousePrice(29));
						board.getField(29).setNumberofHouses(1);
						if(board.getField(29).getNumberofhouses()==5){
							GUIC.setHotel(30,true);
							setHotel(player);
						}else{
						GUIC.setHouse(30, gethouses(29));
						player.addHouseammount(1);
						}}}}
		}
		
		if(n == 7){
			if(gethouses(31) <= gethouses(32) && gethouses(31) <= gethouses(34)){
				if(board.getField(31).getNumberofhouses()<5){
					if(GUIC.buyAmagertorv().equals("Ja")){
						player.account.addPoints(-getHousePrice(31));
						board.getField(31).setNumberofHouses(1);
						if(board.getField(31).getNumberofhouses()==5){
							GUIC.setHotel(32,true);
							setHotel(player);
						}else{
							GUIC.setHouse(32, gethouses(31));
							player.addHouseammount(1);
							}}}}
			if(gethouses(32) <= gethouses(31) && gethouses(32) <= gethouses(34)){
				if(board.getField(32).getNumberofhouses()<5){
					if(GUIC.buyVimmelskaftet().equals("Ja")){
						player.account.addPoints(-getHousePrice(32));
						board.getField(32).setNumberofHouses(1);
						if(board.getField(32).getNumberofhouses()==5){
							GUIC.setHotel(33,true);
							setHotel(player);
						}else{
						GUIC.setHouse(33, gethouses(32));
						player.addHouseammount(1);
						}}}}
			if(gethouses(34) <= gethouses(31) && gethouses(34) <= gethouses(32)){
				if(board.getField(34).getNumberofhouses()<5){
					if(GUIC.buyNygade().equals("Ja")){
						player.account.addPoints(-getHousePrice(34));
						board.getField(34).setNumberofHouses(1);
						if(board.getField(34).getNumberofhouses()==5){
							GUIC.setHotel(35,true);
							setHotel(player);
						}else{
						GUIC.setHouse(35, gethouses(34));
						player.addHouseammount(1);
						}}}}
		}
		if(n == 8){
			if(gethouses(37) <= gethouses(39)){
				if(board.getField(37).getNumberofhouses()<5){
					if(GUIC.buyFrederiksberggade().equals("Ja")){
						player.account.addPoints(-getHousePrice(37));
						board.getField(37).setNumberofHouses(1);
						if(board.getField(37).getNumberofhouses()==5){
							GUIC.setHotel(38,true);
							setHotel(player);
						}else{
						GUIC.setHouse(38, gethouses(37));
						player.addHouseammount(1);
						}}}}
			if(gethouses(39) <= gethouses(37)){
				if(board.getField(39).getNumberofhouses()<5){
					if(GUIC.buyRaadhuspladsen().equals("Ja")){
						player.account.addPoints(-getHousePrice(39));
						board.getField(39).setNumberofHouses(1);
						if(board.getField(39).getNumberofhouses()==5){
							GUIC.setHotel(40,true);
							setHotel(player);
						}else{
						GUIC.setHouse(40, gethouses(39));
						player.addHouseammount(1);
						}}}}
		}
	}
	
	public void sellPlots(Player player, int n){
		
	}
}


