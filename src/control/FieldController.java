package control;


import entity.Player;
import fields.GameBoard;
import boundary.GUIController;

public class FieldController {
	private GUIController GUIC;
	private GameBoard gameboard;
	private Player[] playerlist;
	private DeckController DC;
	
	public FieldController(GUIController GUIC, GameBoard gameboard, Player[] playerlist) {
		this.GUIC = GUIC;
		this.gameboard = gameboard;
		this.playerlist = playerlist;
		DC = new DeckController(GUIC, playerlist, gameboard, this);
	}
	
	public void landOnField(int currentPlayer) {
		// For Territories
		if (gameboard.getField(playerlist[currentPlayer].getPosition()) instanceof fields.Territory)
			landOnTerritory(currentPlayer);
		// For Fleets
		else if (gameboard.getField(playerlist[currentPlayer].getPosition()) instanceof fields.Fleet)
			landOnFleet(currentPlayer);
		// For LaborCamps
		else if (gameboard.getField(playerlist[currentPlayer].getPosition()) instanceof fields.LaborCamp)
			landOnLaborCamp(currentPlayer);
		// For ChanceCard
		else if (gameboard.getField(playerlist[currentPlayer].getPosition()) instanceof fields.ChanceCard)
			DC.drawCard(currentPlayer);
		// For MoveToJail
		else if (gameboard.getField(playerlist[currentPlayer].getPosition()) instanceof fields.MoveToJail) {
			GUIC.moveToJail();
			gameboard.getField(playerlist[currentPlayer].getPosition()).landOnField(playerlist[currentPlayer]);
			GUIC.newPosition(playerlist[currentPlayer]);
		}
		// For Tax
		else if (gameboard.getField(playerlist[currentPlayer].getPosition()) instanceof fields.Tax) 
			landOnTax(currentPlayer);
		// For Refuge
		else if (gameboard.getField(playerlist[currentPlayer].getPosition()) instanceof fields.Refuge)
			landOnRefuge(currentPlayer);
		// For every other fields
		else
			gameboard.getField(playerlist[currentPlayer].getPosition()).landOnField(playerlist[currentPlayer]);
		
		// Update on GUI
		for (int i = 0; i<playerlist.length; i++) {
		GUIC.newPosition(playerlist[i]);
		GUIC.updateBalance(playerlist[i].getName(), playerlist[i].account.getScore());
		}
	}
	
	
	public void landOnTerritory(int currentPlayer) {
		// If no owner
		if (gameboard.getField(playerlist[currentPlayer].getPosition()).getOwner() == null) {
			// If affordable
			if (playerlist[currentPlayer].account.getScore() >= gameboard.getField(playerlist[currentPlayer].getPosition()).getPrice()) {
				// Player chooses if he wants to buy the field
				boolean buyfield = GUIC.buyField(gameboard.getField(playerlist[currentPlayer].getPosition()).getName(), 
				gameboard.getField(playerlist[currentPlayer].getPosition()).getPrice());
				gameboard.getField(playerlist[currentPlayer].getPosition()).setBuyfield(buyfield);
				gameboard.getField(playerlist[currentPlayer].getPosition()).landOnField(playerlist[currentPlayer]);
				
				// Field status on GUI
				if (buyfield) {
					GUIC.fieldBought(gameboard.getField(playerlist[currentPlayer].getPosition()).getName());
					GUIC.setOwner(playerlist[currentPlayer]);
					GUIC.updateBalance(playerlist[currentPlayer].getName(), playerlist[currentPlayer].account.getScore());
				} else
					GUIC.fieldRefused(gameboard.getField(playerlist[currentPlayer].getPosition()).getName());
				} else
					GUIC.fieldRefusedPrice(gameboard.getField(playerlist[currentPlayer].getPosition()).getName());
		} 
		// If its your own field
		else if (gameboard.getField(playerlist[currentPlayer].getPosition()).getOwner() == playerlist[currentPlayer]) {
			GUIC.fieldOwnedByPlayer(gameboard.getField(playerlist[currentPlayer].getPosition()).getName());
		}
		// If someone else owns the field
		else {
			// If affordable rent
			if (gameboard.getField(playerlist[currentPlayer].getPosition()).checkPayDoubleRent(playerlist[currentPlayer])) {
				if(playerlist[currentPlayer].account.getScore() >= gameboard.getField(playerlist[currentPlayer].getPosition()).getRent(0)*2)
					GUIC.fieldTax(gameboard.getField(playerlist[currentPlayer].getPosition()).getName(), 
							gameboard.getField(playerlist[currentPlayer].getPosition()).getOwner().getName(), 
							gameboard.getField(playerlist[currentPlayer].getPosition()).getRent(0)*2);
				else
					GUIC.insufficiantFunds(gameboard.getField(playerlist[currentPlayer].getPosition()).getName(), 
							gameboard.getField(playerlist[currentPlayer].getPosition()).getOwner().getName(), 
							playerlist[currentPlayer].account.getScore());
					gameboard.getField(playerlist[currentPlayer].getPosition()).landOnField(playerlist[currentPlayer]);
			
			}else if (playerlist[currentPlayer].account.getScore() >= 
					gameboard.getField(playerlist[currentPlayer].getPosition()).getRent(
							gameboard.getField(playerlist[currentPlayer].getPosition()).getNumberofhouses())){
				GUIC.fieldTax(gameboard.getField(playerlist[currentPlayer].getPosition()).getName(), 
						gameboard.getField(playerlist[currentPlayer].getPosition()).getOwner().getName(), 
						gameboard.getField(playerlist[currentPlayer].getPosition()).getRent
						(gameboard.getField(playerlist[currentPlayer].getPosition()).getNumberofhouses()));;
						gameboard.getField(playerlist[currentPlayer].getPosition()).landOnField(playerlist[currentPlayer]);
			// if insufficient funds
			} else {
				GUIC.insufficiantFunds(gameboard.getField(playerlist[currentPlayer].getPosition()).getName(), 
						gameboard.getField(playerlist[currentPlayer].getPosition()).getOwner().getName(), 
						playerlist[currentPlayer].account.getScore());
				gameboard.getField(playerlist[currentPlayer].getPosition()).landOnField(playerlist[currentPlayer]);
			}
				
			GUIC.updateBalance(gameboard.getField(playerlist[currentPlayer].getPosition()).getOwner().getName(), 
					gameboard.getField(playerlist[currentPlayer].getPosition()).getOwner().account.getScore());
			GUIC.updateBalance(playerlist[currentPlayer].getName(), playerlist[currentPlayer].account.getScore());
		
		}
	}
	
	public void landOnFleet(int currentPlayer) {
		// If no owner
		if (gameboard.getField(playerlist[currentPlayer].getPosition()).getOwner() == null) {
			// If affordable
			if (playerlist[currentPlayer].account.getScore() >= gameboard.getField(playerlist[currentPlayer].getPosition()).getPrice()) {
				// Player chooses if he wants to buy the field
				boolean buyfield = GUIC.buyField(gameboard.getField(playerlist[currentPlayer].getPosition()).getName(), 
						gameboard.getField(playerlist[currentPlayer].getPosition()).getPrice());
				gameboard.getField(playerlist[currentPlayer].getPosition()).setBuyfield(buyfield);
				gameboard.getField(playerlist[currentPlayer].getPosition()).landOnField(playerlist[currentPlayer]);
				
				// Field status on GUI
				if (buyfield) {
					GUIC.fieldBought(gameboard.getField(playerlist[currentPlayer].getPosition()).getName());
					GUIC.setOwner(playerlist[currentPlayer]);
					GUIC.updateBalance(playerlist[currentPlayer].getName(), playerlist[currentPlayer].account.getScore());
				} else
					GUIC.fieldRefused(gameboard.getField(playerlist[currentPlayer].getPosition()).getName());
				} else
					GUIC.fieldRefusedPrice(gameboard.getField(playerlist[currentPlayer].getPosition()).getName());
		} 
		// If its your own field
		else if (gameboard.getField(playerlist[currentPlayer].getPosition()).getOwner() == playerlist[currentPlayer]) {
			GUIC.fieldOwnedByPlayer(gameboard.getField(playerlist[currentPlayer].getPosition()).getName());
		}
		// If someone else owns the field
		else {
			// If affordable rent
			if (playerlist[currentPlayer].account.getScore() >= 
					gameboard.getField(playerlist[currentPlayer].getPosition()).getRent(
							gameboard.getField(playerlist[currentPlayer].getPosition()).getNumberofhouses())){
				GUIC.fieldTax(gameboard.getField(playerlist[currentPlayer].getPosition()).getName(), 
						gameboard.getField(playerlist[currentPlayer].getPosition()).getOwner().getName(), 
						gameboard.getField(playerlist[currentPlayer].getPosition()).getRent
						(gameboard.getField(playerlist[currentPlayer].getPosition()).getOwner().getFleets()-1));
				gameboard.getField(playerlist[currentPlayer].getPosition()).landOnField(playerlist[currentPlayer]);
			// if insufficient funds
			} else {
				GUIC.insufficiantFunds(gameboard.getField(playerlist[currentPlayer].getPosition()).getName(), 
						gameboard.getField(playerlist[currentPlayer].getPosition()).getOwner().getName(), 
						playerlist[currentPlayer].account.getScore());
				gameboard.getField(playerlist[currentPlayer].getPosition()).landOnField(playerlist[currentPlayer]);
			}
				
			GUIC.updateBalance(gameboard.getField(playerlist[currentPlayer].getPosition()).getOwner().getName(), 
					gameboard.getField(playerlist[currentPlayer].getPosition()).getOwner().account.getScore());
			GUIC.updateBalance(playerlist[currentPlayer].getName(), playerlist[currentPlayer].account.getScore());
		}
	}
	
	public void landOnLaborCamp(int currentPlayer) {
		// If no owner
		if (gameboard.getField(playerlist[currentPlayer].getPosition()).getOwner() == null) {
			// If affordable
			if (playerlist[currentPlayer].account.getScore() >= gameboard.getField(playerlist[currentPlayer].getPosition()).getPrice()) {
				// Player chooses if he wants to buy the field
				boolean buyfield = GUIC.buyField(gameboard.getField(playerlist[currentPlayer].getPosition()).getName(), 
						gameboard.getField(playerlist[currentPlayer].getPosition()).getPrice());
				gameboard.getField(playerlist[currentPlayer].getPosition()).setBuyfield(buyfield);
				gameboard.getField(playerlist[currentPlayer].getPosition()).landOnField(playerlist[currentPlayer]);
				
				// Field status on GUI
				if (buyfield) {
					GUIC.fieldBought(gameboard.getField(playerlist[currentPlayer].getPosition()).getName());
					GUIC.setOwner(playerlist[currentPlayer]);
					GUIC.updateBalance(playerlist[currentPlayer].getName(), playerlist[currentPlayer].account.getScore());
				} else
					GUIC.fieldRefused(gameboard.getField(playerlist[currentPlayer].getPosition()).getName());
				} else
					GUIC.fieldRefusedPrice(gameboard.getField(playerlist[currentPlayer].getPosition()).getName());
		} 
		// If its your own field
		else if (gameboard.getField(playerlist[currentPlayer].getPosition()).getOwner() == playerlist[currentPlayer]) {
			GUIC.fieldOwnedByPlayer(gameboard.getField(playerlist[currentPlayer].getPosition()).getName());
		}
		// If someone else owns the field
		else {
			// If affordable rent
			if (playerlist[currentPlayer].account.getScore() >= 
					gameboard.getField(playerlist[currentPlayer].getPosition()).getRent(
							gameboard.getField(playerlist[currentPlayer].getPosition()).getOwner().getLaborCamp())){
				GUIC.fieldTax(gameboard.getField(playerlist[currentPlayer].getPosition()).getName(), 
						gameboard.getField(playerlist[currentPlayer].getPosition()).getOwner().getName(), 
						gameboard.getField(playerlist[currentPlayer].getPosition()).getRent
						(gameboard.getField(playerlist[currentPlayer].getPosition()).getOwner().getLaborCamp()));
				gameboard.getField(playerlist[currentPlayer].getPosition()).landOnField(playerlist[currentPlayer]);
			// if insufficient funds
			} else {
				GUIC.insufficiantFunds(gameboard.getField(playerlist[currentPlayer].getPosition()).getName(), 
						gameboard.getField(playerlist[currentPlayer].getPosition()).getOwner().getName(), 
						playerlist[currentPlayer].account.getScore());
				gameboard.getField(playerlist[currentPlayer].getPosition()).landOnField(playerlist[currentPlayer]);
			}
				
			GUIC.updateBalance(gameboard.getField(playerlist[currentPlayer].getPosition()).getOwner().getName(), 
					gameboard.getField(playerlist[currentPlayer].getPosition()).getOwner().account.getScore());
			GUIC.updateBalance(playerlist[currentPlayer].getName(), playerlist[currentPlayer].account.getScore());
		}
	}
	public void landOnTax(int currentPlayer) {
				if (gameboard.getField(playerlist[currentPlayer].getPosition()).isOption()) {
					boolean paypercent = GUIC.taxPick(gameboard.getField(playerlist[currentPlayer].getPosition()).getName());
					if(paypercent) {
						gameboard.getField(playerlist[currentPlayer].getPosition()).setPaypercent(true);	
					GUIC.messageTax10percent();
					} else if (playerlist[currentPlayer].account.getScore() >= 
							gameboard.getField(playerlist[currentPlayer].getPosition()).getPrice()) {
						gameboard.getField(playerlist[currentPlayer].getPosition()).setPaypercent(false);
						GUIC.taxMessageNoOption(gameboard.getField(playerlist[currentPlayer].getPosition()).getPrice());
					} else
						GUIC.insufficiantFundsTax();
				} else {
						if (playerlist[currentPlayer].account.getScore() >= 
							gameboard.getField(playerlist[currentPlayer].getPosition()).getPrice()) {
							GUIC.taxMessageNoOption(gameboard.getField(playerlist[currentPlayer].getPosition()).getPrice());
			}			else
						GUIC.insufficiantFundsTax();
				}
				gameboard.getField(playerlist[currentPlayer].getPosition()).landOnField(playerlist[currentPlayer]);
				GUIC.updateBalance(playerlist[currentPlayer].getName(), playerlist[currentPlayer].account.getScore());
			}
	public void landOnRefuge(int currentPlayer) {
		GUIC.bonusMessage(playerlist[currentPlayer].getName(), gameboard.getField(playerlist[currentPlayer].getPosition()).getRent(0));
		gameboard.getField(playerlist[currentPlayer].getPosition()).landOnField(playerlist[currentPlayer]);
		GUIC.updateBalance(playerlist[currentPlayer].getName(), playerlist[currentPlayer].account.getScore());
	}

}
