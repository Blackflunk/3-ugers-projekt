package control;

import boundary.GUIController;
import entity.Player;
import fields.Field;
import fields.GameBoard;


public class HouseController {
	private GUIController GUIC;
	private GameBoard board;
	private Player[] playerlist;
	private boolean khan = true;
	private String[] sellOptions;
	
	public HouseController(GUIController GUIC, GameBoard board,Player[] playerlist){
		this.board =board;
		this.GUIC = GUIC;
		this.playerlist = playerlist;
		this.board = board;
	}
	
	public void buyHouse(int currentPlayer){
		//check if you can buy.
		boolean moreHouses = true;
		while(moreHouses== true){
			for(int i=1; i<=8; i++){
				if(getPriceAndValue(currentPlayer, i, board) == true){
					for(int q=1; q<=8; q++){
						if(getBuild(q, currentPlayer) == true){
							buildPlots(currentPlayer ,q);
							}
						}
				}
			}
			
			if(GUIC.offerMoreHouses()==false){
				moreHouses=false;
			}
		}
	}		
	
	
	//sell house
	public void sellHouse(int currentPlayer,GameBoard board, String plot){		
			for(int i=1; i<=39; i++){
				if(board.getField(i).getName().equals(plot)){
					playerlist[currentPlayer].account.addPoints(getHousePrice(1));
					board.getField(i).addNumberofHouses(-1);
					if(board.getField(i).getNumberofhouses()==5){
						GUIC.setHotel(i+1,false);
						removeHotel(currentPlayer);
					}else{
					playerlist[currentPlayer].addHouseammount(-1);	
					GUIC.setHouse(i+1, board.getField(i).getNumberofhouses());
					}
				}	
			}GUIC.updateBalance(playerlist[currentPlayer].getName(), playerlist[currentPlayer].account.getScore());
		}
	public String[] checkIfPossibleSell(int currentPlayer, GameBoard board){
		int arrayIndex = 0;
		int arraylength = 0;
		for(int i=1; i<=39; i++){
			if(board.getField(i).getNumberofhouses() > 0 && playerlist[currentPlayer].equals(board.getField(i).getOwner())){
				arraylength++;
			}
		}	
		sellOptions = new String[arraylength];	
		for(int i=1; i<=39; i++){
			if(board.getField(i).getNumberofhouses() > 0 && playerlist[currentPlayer].equals(board.getField(i).getOwner())){
				sellOptions[arrayIndex] = board.getField(i).getName();
				arrayIndex++;
			}
		}
			return sellOptions;
	}

	public void checkOwnedFields(int currentPlayer){
		checkBlue(currentPlayer);
		checkPink(currentPlayer);
		checkGreen(currentPlayer);
		checkGrey(currentPlayer);
		checkRed(currentPlayer);
		checkWhite(currentPlayer);
		checkYellow(currentPlayer);
		checkMagneta(currentPlayer);
	}
	public void checkBlue(int currentPlayer){
		if(playerlist[currentPlayer].getFieldammount_blue() == 2){
			playerlist[currentPlayer].setBuy_Blue(khan);
		}
	}
	
	public void checkPink(int currentPlayer){
		if(playerlist[currentPlayer].getFieldammount_pink() == 3){
			playerlist[currentPlayer].setBuy_Pink(khan);
		}
	}
	
	public void checkGreen(int currentPlayer){
		if(playerlist[currentPlayer].getFieldammount_green() == 3){
			playerlist[currentPlayer].setBuy_Green(khan);
		}
	}
	
	public void checkGrey(int currentPlayer){
		if(playerlist[currentPlayer].getFieldammount_grey() == 3){
			playerlist[currentPlayer].setBuy_grey(khan);
		}
	}
	
	public void checkRed(int currentPlayer){
		if(playerlist[currentPlayer].getFieldammount_red() == 3){
			playerlist[currentPlayer].setBuy_Red(khan);
		}
	}
	
	public void checkWhite(int currentPlayer){
		if(playerlist[currentPlayer].getFieldammount_white() == 3){
			playerlist[currentPlayer].setBuy_White(khan);
		}
	}
	
	public void checkYellow(int currentPlayer){
		if(playerlist[currentPlayer].getFieldammount_yellow() == 3){
			playerlist[currentPlayer].setBuy_Yellow(khan);
		}
	}
	
	public void checkMagneta(int currentPlayer){
		if(playerlist[currentPlayer].getFieldammount_magenta() == 2){
			playerlist[currentPlayer].setBuy_Magenta(khan);
		}
	}

	public boolean getBuild(int n, int currentPlayer){
		if(n == 1){
			return playerlist[currentPlayer].getBuy_Blue();
		}
		else if(n == 2){
			return playerlist[currentPlayer].getBuy_Pink();
		}
		else if(n == 3){
			return playerlist[currentPlayer].getBuy_Green();
		}
		else if(n == 4){
			return playerlist[currentPlayer].getBuy_grey();
		}
		else if(n == 5){
			return playerlist[currentPlayer].getBuy_Red();
		}
		else if(n == 6){
			return playerlist[currentPlayer].getBuy_White();
		}
		else if(n == 7){
			return playerlist[currentPlayer].getBuy_Yellow();
		}
		else if(n == 8){
			return playerlist[currentPlayer].getBuy_Magenta();
		}
		return false;
	}
	
	public boolean getPriceAndValue(int currentPlayer, int n, GameBoard board){
		if(n == 1){
			if(playerlist[currentPlayer].getBuy_Blue() == true){
				if(playerlist[currentPlayer].account.getScore() >= board.getField(playerlist[currentPlayer].getPosition()).getPrice()){
					return true;	
				}
			}	
		}
		else if(n == 2){
			if(playerlist[currentPlayer].getBuy_Pink() == true){
				if(playerlist[currentPlayer].account.getScore() >= board.getField(playerlist[currentPlayer].getPosition()).getPrice()){
					return true;
				}
			}	
		}
		else if(n == 3){
			if(playerlist[currentPlayer].getBuy_Green() == true){
				if(playerlist[currentPlayer].account.getScore() >= board.getField(playerlist[currentPlayer].getPosition()).getPrice()){
					return true;
				}
			}	
		}
		else if(n == 4){
			if(playerlist[currentPlayer].getBuy_grey() == true){
				if(playerlist[currentPlayer].account.getScore() >= board.getField(playerlist[currentPlayer].getPosition()).getPrice()){
					return true;
				}
			}	
		}
		else if(n == 5){
			if(playerlist[currentPlayer].getBuy_Red() == true){
				if(playerlist[currentPlayer].account.getScore() >= board.getField(playerlist[currentPlayer].getPosition()).getPrice()){
					return true;
				}
			}	
		}
		else if(n == 6){
			if(playerlist[currentPlayer].getBuy_White() == true){
				if(playerlist[currentPlayer].account.getScore() >= board.getField(playerlist[currentPlayer].getPosition()).getPrice()){
					return true;
				}
			}	
		}
		else if(n == 7){
			if(playerlist[currentPlayer].getBuy_Yellow() == true){
				if(playerlist[currentPlayer].account.getScore() >= board.getField(playerlist[currentPlayer].getPosition()).getPrice()){
					return true;
				}
			}	
		}
		else if(n == 8){
			if(playerlist[currentPlayer].getBuy_Magenta() == true){
				if(playerlist[currentPlayer].account.getScore() >= board.getField(playerlist[currentPlayer].getPosition()).getPrice()){
					return true;
				}
			}	
		}
		
		return false;
		
	}
	
	public void setHotel(int currentPlayer){
		playerlist[currentPlayer].addHouseammount(-4);
		playerlist[currentPlayer].addHotelammount(1);
	}
	
	public void removeHotel(int currentPlayer){
		playerlist[currentPlayer].addHouseammount(4);
		playerlist[currentPlayer].addHotelammount(-1);
	}

	public int getHousePrice(int n){
		return board.getField(n).getHouseprice();
	}
	
	public void buildPlots(int currentPlayer, int n){
		if(n == 1){
			Field f1 = board.getField(1);
			Field f2 = board.getField(3);
			
			if(f1.getNumberofhouses() <= f2.getNumberofhouses()){
				if(f1.getNumberofhouses()<5){
					if(GUIC.buyRoedovervej().equals("Ja")){
						playerlist[currentPlayer].account.addPoints(-getHousePrice(1));
						f1.addNumberofHouses(1);
						if(f1.getNumberofhouses()==5){
							GUIC.setHotel(2,true);
							setHotel(currentPlayer);
						}else{
						GUIC.setHouse(2, f1.getNumberofhouses());
						playerlist[currentPlayer].addHouseammount(1);
						}
					}}
				GUIC.updateBalance(playerlist[currentPlayer].getName(), playerlist[currentPlayer].account.getScore());
				}
			if(f2.getNumberofhouses() <= f1.getNumberofhouses()){
				if(f2.getNumberofhouses()<5){
					if(GUIC.buyHvidovervej().equals("Ja")){
						playerlist[currentPlayer].account.addPoints(-getHousePrice(3));
						f2.addNumberofHouses(1);
						if(f2.getNumberofhouses()==5){
							GUIC.setHotel(4,true);
							setHotel(currentPlayer);
						}else{
						GUIC.setHouse(4, f2.getNumberofhouses());
						playerlist[currentPlayer].addHouseammount(1);
						}
					}}}
			GUIC.updateBalance(playerlist[currentPlayer].getName(), playerlist[currentPlayer].account.getScore());
		}
		if(n == 2){
			Field f3 = board.getField(6);
			Field f4 = board.getField(8);
			Field f5 = board.getField(9);
			if(f3.getNumberofhouses() <= f4.getNumberofhouses() && f3.getNumberofhouses() <= f5.getNumberofhouses()){
				if(f3.getNumberofhouses()<5){
					if(GUIC.buyRoskildevej().equals("Ja")){
						playerlist[currentPlayer].account.addPoints(-getHousePrice(6));
						f3.addNumberofHouses(1);
						if(f3.getNumberofhouses()==5){
							GUIC.setHotel(7,true);
							setHotel(currentPlayer);
						}else{
						GUIC.setHouse(7, f3.getNumberofhouses());
						playerlist[currentPlayer].addHouseammount(1);
						}}}
				GUIC.updateBalance(playerlist[currentPlayer].getName(), playerlist[currentPlayer].account.getScore());
				}
			if(f4.getNumberofhouses() <= f3.getNumberofhouses() && f4.getNumberofhouses() <= f5.getNumberofhouses()){
				if(f4.getNumberofhouses()<5){
					if(GUIC.buyValbyLanggade().equals("Ja")){
						playerlist[currentPlayer].account.addPoints(-getHousePrice(8));
						f4.addNumberofHouses(1);
						if(f4.getNumberofhouses()==5){
							GUIC.setHotel(9,true);
							setHotel(currentPlayer);
						}else{
						GUIC.setHouse(9, f4.getNumberofhouses());
						playerlist[currentPlayer].addHouseammount(1);
						}}}}
			if(f5.getNumberofhouses() <= f3.getNumberofhouses() && f5.getNumberofhouses() <= f4.getNumberofhouses()){
				if(f5.getNumberofhouses()<5){
					if(GUIC.buyAllegade().equals("Ja")){
						playerlist[currentPlayer].account.addPoints(-getHousePrice(9));
						f5.addNumberofHouses(1);
						if(f5.getNumberofhouses()==5){
							GUIC.setHotel(10,true);
							setHotel(currentPlayer);
						}else{
						GUIC.setHouse(10, f5.getNumberofhouses());
						playerlist[currentPlayer].addHouseammount(1);
						}}}
				GUIC.updateBalance(playerlist[currentPlayer].getName(), playerlist[currentPlayer].account.getScore());
				}
		}
		if(n == 3){
			Field f6 = board.getField(11);
			Field f7 = board.getField(13);
			Field f8 = board.getField(14);
			
			if(f6.getNumberofhouses() <= f7.getNumberofhouses() && f6.getNumberofhouses() <= f8.getNumberofhouses()){
				if(f6.getNumberofhouses()<5){
					if(GUIC.buyFredriksbergAlle().equals("Ja")){
						playerlist[currentPlayer].account.addPoints(-getHousePrice(11));
						f6.addNumberofHouses(1);
						if(f6.getNumberofhouses()==5){
							GUIC.setHotel(12,true);
							setHotel(currentPlayer);
						}else{
						GUIC.setHouse(12, f6.getNumberofhouses());
						playerlist[currentPlayer].addHouseammount(1);
						}}}
				GUIC.updateBalance(playerlist[currentPlayer].getName(), playerlist[currentPlayer].account.getScore());
				}
			if(f7.getNumberofhouses() <= f6.getNumberofhouses() && f7.getNumberofhouses() <= f8.getNumberofhouses()){
				if(f7.getNumberofhouses()<5){
					if(GUIC.buyBulowsvej().equals("Ja")){
						playerlist[currentPlayer].account.addPoints(-getHousePrice(13));
						f7.addNumberofHouses(1);
						if(f7.getNumberofhouses()==5){
							GUIC.setHotel(14,true);
							setHotel(currentPlayer);
						}else{
						GUIC.setHouse(14, f7.getNumberofhouses());
						playerlist[currentPlayer].addHouseammount(1);
						}}}
				GUIC.updateBalance(playerlist[currentPlayer].getName(), playerlist[currentPlayer].account.getScore());
				}
			if(f8.getNumberofhouses() <= f6.getNumberofhouses() && f8.getNumberofhouses() <= f7.getNumberofhouses()){
				if(f8.getNumberofhouses()<5){
					if(GUIC.buyGlKongevej().equals("Ja")){
						playerlist[currentPlayer].account.addPoints(-getHousePrice(14));
						f8.addNumberofHouses(1);
						if(f8.getNumberofhouses()==5){
							GUIC.setHotel(15,true);
							setHotel(currentPlayer);
						}else{
						GUIC.setHouse(15, f8.getNumberofhouses());
						playerlist[currentPlayer].addHouseammount(1);
						}}}
				GUIC.updateBalance(playerlist[currentPlayer].getName(), playerlist[currentPlayer].account.getScore());
				}
		}
		if(n == 4){
			Field f9 = board.getField(16);
			Field f10 = board.getField(18);
			Field f11 = board.getField(19);
			
			if(f9.getNumberofhouses() <= f10.getNumberofhouses() && f9.getNumberofhouses() <= f11.getNumberofhouses()){
				if(f9.getNumberofhouses()<5){
					if(GUIC.buyBernstorffsvej().equals("Ja")){
						playerlist[currentPlayer].account.addPoints(-getHousePrice(16));
						f9.addNumberofHouses(1);
						if(f9.getNumberofhouses()==5){
							GUIC.setHotel(17,true);
							setHotel(currentPlayer);
						}else{
						GUIC.setHouse(17, f9.getNumberofhouses());
						playerlist[currentPlayer].addHouseammount(1);
						}}}
				GUIC.updateBalance(playerlist[currentPlayer].getName(), playerlist[currentPlayer].account.getScore());
				}
			if(f10.getNumberofhouses() <= f9.getNumberofhouses() && f10.getNumberofhouses() <= f11.getNumberofhouses()){
				if(f10.getNumberofhouses()<5){
					if(GUIC.buyHellerupvej().equals("Ja")){
						playerlist[currentPlayer].account.addPoints(-getHousePrice(18));
						f10.addNumberofHouses(1);
						if(f10.getNumberofhouses()==5){
							GUIC.setHotel(19,true);
							setHotel(currentPlayer);
						}else{
						GUIC.setHouse(19, f10.getNumberofhouses());
						playerlist[currentPlayer].addHouseammount(1);
						}}}
				GUIC.updateBalance(playerlist[currentPlayer].getName(), playerlist[currentPlayer].account.getScore());
				}
			if(f11.getNumberofhouses() <= f9.getNumberofhouses() && f11.getNumberofhouses() <= f10.getNumberofhouses()){
				if(f11.getNumberofhouses()<5){
					if(GUIC.buyStrandvejen().equals("Ja")){
						playerlist[currentPlayer].account.addPoints(-getHousePrice(19));
						f11.addNumberofHouses(1);
						if(f11.getNumberofhouses()==5){
							GUIC.setHotel(20,true);
							setHotel(currentPlayer);
						}else{
						GUIC.setHouse(20, f11.getNumberofhouses());
						playerlist[currentPlayer].addHouseammount(1);
						}}}
				GUIC.updateBalance(playerlist[currentPlayer].getName(), playerlist[currentPlayer].account.getScore());
						}
		}
		
		if(n == 5){
			Field f12 = board.getField(21);
			Field f13 = board.getField(23);
			Field f14 = board.getField(24);
			
			if(f12.getHouseprice() <= f13.getNumberofhouses() && f12.getHouseprice() <= f14.getNumberofhouses()){
				if(f12.getNumberofhouses()<5){
					if(GUIC.buyTrianglen().equals("Ja")){
						playerlist[currentPlayer].account.addPoints(-getHousePrice(21));
						f12.addNumberofHouses(1);
						if(f12.getNumberofhouses()==5){
							GUIC.setHotel(22,true);
							setHotel(currentPlayer);
						}else{
						GUIC.setHouse(22, f12.getNumberofhouses());
						playerlist[currentPlayer].addHouseammount(1);
						}}}
				GUIC.updateBalance(playerlist[currentPlayer].getName(), playerlist[currentPlayer].account.getScore());
				}
			if(f13.getNumberofhouses() <= f12.getNumberofhouses() && f13.getNumberofhouses() <= f14.getNumberofhouses()){
				if(f13.getNumberofhouses()<5){
					if(GUIC.buyOesterbrogade().equals("Ja")){
						playerlist[currentPlayer].account.addPoints(-getHousePrice(23));
						f13.addNumberofHouses(1);
						if(f13.getNumberofhouses()==5){
							GUIC.setHotel(24,true);
							setHotel(currentPlayer);
						}else{
						GUIC.setHouse(24, f13.getNumberofhouses());
						playerlist[currentPlayer].addHouseammount(1);
						}}}
				GUIC.updateBalance(playerlist[currentPlayer].getName(), playerlist[currentPlayer].account.getScore());
						}
			if(f14.getNumberofhouses() <= f12.getNumberofhouses() && f14.getNumberofhouses() <= f13.getNumberofhouses()){
				if(f14.getNumberofhouses()<5){
					if(GUIC.buyGroenningen().equals("Ja")){
						playerlist[currentPlayer].account.addPoints(-getHousePrice(24));
						f14.addNumberofHouses(1);
						if(f14.getNumberofhouses()==5){
							GUIC.setHotel(25,true);
							setHotel(currentPlayer);
						}else{
						GUIC.setHouse(25, f14.getNumberofhouses());
						playerlist[currentPlayer].addHouseammount(1);
						}}}
				GUIC.updateBalance(playerlist[currentPlayer].getName(), playerlist[currentPlayer].account.getScore());
				}
		}
		
		if(n == 6){
			Field f15 = board.getField(26);
			Field f16 = board.getField(27);
			Field f17 = board.getField(29);
			if(f15.getNumberofhouses() <= f16.getNumberofhouses() && f15.getNumberofhouses() <= f17.getNumberofhouses()){
				if(f15.getNumberofhouses()<5){
					if(GUIC.buyBredgade().equals("Ja")){
						playerlist[currentPlayer].account.addPoints(-getHousePrice(26));
						f15.addNumberofHouses(1);
						if(f15.getNumberofhouses()==5){
							GUIC.setHotel(27,true);
							setHotel(currentPlayer);
						}else{
						GUIC.setHouse(27, f15.getNumberofhouses());
						playerlist[currentPlayer].addHouseammount(1);
						}}}
				GUIC.updateBalance(playerlist[currentPlayer].getName(), playerlist[currentPlayer].account.getScore());
				}
			if(f16.getNumberofhouses() <= f15.getNumberofhouses() && f16.getNumberofhouses() <= f17.getNumberofhouses()){
				if(f16.getNumberofhouses()<5){
					if(GUIC.buyKgsNytorv().equals("Ja")){
						playerlist[currentPlayer].account.addPoints(-getHousePrice(27));
						f16.addNumberofHouses(1);
						if(f16.getNumberofhouses()==5){
							GUIC.setHotel(28,true);
							setHotel(currentPlayer);
						}else{
						GUIC.setHouse(28, f16.getNumberofhouses());
						playerlist[currentPlayer].addHouseammount(1);
						}}}
				GUIC.updateBalance(playerlist[currentPlayer].getName(), playerlist[currentPlayer].account.getScore());
				}
			if(f17.getNumberofhouses() <= f15.getNumberofhouses() && f17.getNumberofhouses() <= f16.getNumberofhouses()){
				if(f17.getNumberofhouses()<5){
					if(GUIC.buyIstergade().equals("Ja")){
						playerlist[currentPlayer].account.addPoints(-getHousePrice(29));
						f17.addNumberofHouses(1);
						if(f17.getNumberofhouses()==5){
							GUIC.setHotel(30,true);
							setHotel(currentPlayer);
						}else{
						GUIC.setHouse(30, f17.getNumberofhouses());
						playerlist[currentPlayer].addHouseammount(1);
						}}}
				GUIC.updateBalance(playerlist[currentPlayer].getName(), playerlist[currentPlayer].account.getScore());
				}
		}
		
		if(n == 7){
			Field f18 = board.getField(31);
			Field f19 = board.getField(32);
			Field f20 = board.getField(34);
			
			if(f18.getNumberofhouses() <= f19.getNumberofhouses() && f18.getNumberofhouses() <= f20.getNumberofhouses()){
				if(f18.getNumberofhouses()<5){
					if(GUIC.buyAmagertorv().equals("Ja")){
						playerlist[currentPlayer].account.addPoints(-getHousePrice(31));
						f18.addNumberofHouses(1);
						if(f18.getNumberofhouses()==5){
							GUIC.setHotel(32,true);
							setHotel(currentPlayer);
						}else{
							GUIC.setHouse(32, f18.getNumberofhouses());
							playerlist[currentPlayer].addHouseammount(1);
							}}}
				GUIC.updateBalance(playerlist[currentPlayer].getName(), playerlist[currentPlayer].account.getScore());
				}
			if(f19.getNumberofhouses() <= f18.getNumberofhouses() && f19.getNumberofhouses() <= f20.getNumberofhouses()){
				if(f19.getNumberofhouses()<5){
					if(GUIC.buyVimmelskaftet().equals("Ja")){
						playerlist[currentPlayer].account.addPoints(-getHousePrice(32));
						f19.addNumberofHouses(1);
						if(f19.getNumberofhouses()==5){
							GUIC.setHotel(33,true);
							setHotel(currentPlayer);
						}else{
						GUIC.setHouse(33, f19.getNumberofhouses());
						playerlist[currentPlayer].addHouseammount(1);
						}}}
				GUIC.updateBalance(playerlist[currentPlayer].getName(), playerlist[currentPlayer].account.getScore());
				}
			if(f20.getNumberofhouses() <= f18.getNumberofhouses() && f20.getNumberofhouses() <= f19.getNumberofhouses()){
				if(f20.getNumberofhouses()<5){
					if(GUIC.buyNygade().equals("Ja")){
						playerlist[currentPlayer].account.addPoints(-getHousePrice(34));
						f20.addNumberofHouses(1);
						if(f20.getNumberofhouses()==5){
							GUIC.setHotel(35,true);
							setHotel(currentPlayer);
						}else{
						GUIC.setHouse(35, f20.getNumberofhouses());
						playerlist[currentPlayer].addHouseammount(1);
						}}}
				GUIC.updateBalance(playerlist[currentPlayer].getName(), playerlist[currentPlayer].account.getScore());
				}
		}
		if(n == 8){
			Field f21 = board.getField(37);
			Field f22 = board.getField(39);
			
			if(f21.getNumberofhouses() <= f22.getNumberofhouses()){
				if(f21.getNumberofhouses()<5){
					if(GUIC.buyFrederiksberggade().equals("Ja")){
						playerlist[currentPlayer].account.addPoints(-getHousePrice(37));
						f21.addNumberofHouses(1);
						if(f21.getNumberofhouses()==5){
							GUIC.setHotel(38,true);
							setHotel(currentPlayer);
						}else{
						GUIC.setHouse(38, f21.getNumberofhouses());
						playerlist[currentPlayer].addHouseammount(1);
						}}}
				GUIC.updateBalance(playerlist[currentPlayer].getName(), playerlist[currentPlayer].account.getScore());
				}
			if(f22.getNumberofhouses() <= f21.getNumberofhouses()){
				if(f22.getNumberofhouses()<5){
					if(GUIC.buyRaadhuspladsen().equals("Ja")){
						playerlist[currentPlayer].account.addPoints(-getHousePrice(39));
						f22.addNumberofHouses(1);
						if(f22.getNumberofhouses()==5){
							GUIC.setHotel(40,true);
							setHotel(currentPlayer);
						}else{
						GUIC.setHouse(40, f22.getNumberofhouses());
						playerlist[currentPlayer].addHouseammount(1);
						}}}
				GUIC.updateBalance(playerlist[currentPlayer].getName(), playerlist[currentPlayer].account.getScore());
				}
		}
	}

}


