package control;

import fields.GameBoard;
import game.DiceBox;
import game.Player;
import boundary.GUIcontroller;

public class FieldController {
	private GUIcontroller GUIC;
	private GameBoard gameboard;
	private Player[] playerlist;
	
	public FieldController(GUIcontroller GUIC, GameBoard gameboard, DiceBox box, Player[] playerlist) {
		this.GUIC = GUIC;
		this.gameboard = gameboard;
		this.playerlist = playerlist;
	}
	
	public void landOnField(Player[] playerlist, int currentPlayer) {
		// For Territories
		if (gameboard.getField(playerlist[currentPlayer].getPosition()) instanceof fields.Territory)
			landOnTerritory(playerlist, currentPlayer);
		// For Fleets
		else if (gameboard.getField(playerlist[currentPlayer].getPosition()) instanceof fields.Fleet)
			landOnFleet(playerlist, currentPlayer);
		// For LaborCamps
		else if (gameboard.getField(playerlist[currentPlayer].getPosition()) instanceof fields.LaborCamp)
			landOnLaborCamp(playerlist, currentPlayer);
		// For every other fields
		else
			gameboard.getField(playerlist[currentPlayer].getPosition()).landOnField(playerlist[currentPlayer]);
		
		// Update on GUI
		GUIC.newPositon(playerlist[currentPlayer]);
	}
	
	
	/** 
	 * fieldtax is the only thing that varies
	 * 
	 */
	public void landOnTerritory(Player[] playerlist, int currentPlayer) {
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
				GUIC.fieldTax(gameboard.getField(playerlist[currentPlayer].getPosition()).getName(), playerlist[currentPlayer].getName(), 
						gameboard.getField(playerlist[currentPlayer].getPosition()).getRent
						(gameboard.getField(playerlist[currentPlayer].getPosition()).getNumberofhouses()));;
			// if insufficient funds
			} else {
				GUIC.insufficiantFunds(gameboard.getField(playerlist[currentPlayer].getPosition()).getName(), 
						gameboard.getField(playerlist[currentPlayer].getPosition()).getOwner().getName(), 
						playerlist[currentPlayer].account.getScore());
			}
				
			GUIC.updateBalance(gameboard.getField(playerlist[currentPlayer].getPosition()).getOwner().getName(), 
					gameboard.getField(playerlist[currentPlayer].getPosition()).getOwner().account.getScore());
			GUIC.updateBalance(playerlist[currentPlayer].getName(), playerlist[currentPlayer].account.getScore());
		}
	}
	
	public void landOnFleet(Player[] playerlist, int currentPlayer) {
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
				GUIC.fieldTax(gameboard.getField(playerlist[currentPlayer].getPosition()).getName(), playerlist[currentPlayer].getName(), 
						gameboard.getField(playerlist[currentPlayer].getPosition()).getRent
						(gameboard.getField(playerlist[currentPlayer].getPosition()).getOwner().getFleets()));
			// if insufficient funds
			} else {
				GUIC.insufficiantFunds(gameboard.getField(playerlist[currentPlayer].getPosition()).getName(), 
						gameboard.getField(playerlist[currentPlayer].getPosition()).getOwner().getName(), 
						playerlist[currentPlayer].account.getScore());
			}
				
			GUIC.updateBalance(gameboard.getField(playerlist[currentPlayer].getPosition()).getOwner().getName(), 
					gameboard.getField(playerlist[currentPlayer].getPosition()).getOwner().account.getScore());
			GUIC.updateBalance(playerlist[currentPlayer].getName(), playerlist[currentPlayer].account.getScore());
		}
	}
	
	public void landOnLaborCamp(Player[] playerlist, int currentPlayer) {
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
				GUIC.fieldTax(gameboard.getField(playerlist[currentPlayer].getPosition()).getName(), playerlist[currentPlayer].getName(), 
						gameboard.getField(playerlist[currentPlayer].getPosition()).getRent
						(gameboard.getField(playerlist[currentPlayer].getPosition()).getOwner().getLaborCamp()));
			// if insufficient funds
			} else {
				GUIC.insufficiantFunds(gameboard.getField(playerlist[currentPlayer].getPosition()).getName(), 
						gameboard.getField(playerlist[currentPlayer].getPosition()).getOwner().getName(), 
						playerlist[currentPlayer].account.getScore());
			}
				
			GUIC.updateBalance(gameboard.getField(playerlist[currentPlayer].getPosition()).getOwner().getName(), 
					gameboard.getField(playerlist[currentPlayer].getPosition()).getOwner().account.getScore());
			GUIC.updateBalance(playerlist[currentPlayer].getName(), playerlist[currentPlayer].account.getScore());
		}
	}

}
