//********************************************************************
//  Player.java       Authors: Group 57
//
//  A class to hold information and methods regarding the player in CDIO part 3
//********************************************************************

package game;

public class Player {
	private String name;
	private int position, fleets, laborCamp,
	fieldammount_blue,fieldammount_pink,fieldammount_green,fieldammount_grey,
	fieldammount_red,fieldammount_white,fieldammount_yellow,fieldammount_purple,
	houseammount,hotelammount;
	private boolean lost, outofjailcard,jailed;
	public Account account = new Account();

	// Object that stores the name and position of a player
	public Player(String name) {
		position = 0;
		fleets = 0;
		laborCamp = 0;
		lost = false;
		outofjailcard = false;
		jailed = false;
		fieldammount_blue = 0;
		fieldammount_pink = 0;
		fieldammount_grey = 0;
		fieldammount_green = 0;
		fieldammount_red = 0;
		fieldammount_white = 0;
		fieldammount_yellow = 0;
		fieldammount_purple = 0;
		houseammount = 0;
		hotelammount = 0;
		this.name = name;
	}

	// Method that returns the name of the player
	public String getName() {
		return name;
	}

	// Method that sets the position of the player
	public void setPosition(int roll) {
		if (position + roll > 21) {
			position = position + roll - 22;
		} else {
			position += roll;
		}
	}
	// Method that returns the position of the player
	public int getPosition() {
		return position;
	}
	// Adds a fleet to the players owned fleets
	public void setFleets(int fleets) {
		this.fleets = fleets;
	}
	
	public void addFleet(){
		fleets++;
	}
	
	// Returns the number of the players owned fleets
	public int getFleets() {
		return fleets;
	}
	public void addLaborCamp(){
		laborCamp++;
	}
	
	public void setLaborCamp(int laborcamp){
		this.laborCamp = laborcamp;
	}
	
	public int getLaborCamp(){ 
		return laborCamp;
	}
	public void setStatus(boolean lost) {
		this.lost = lost;
	}
	public boolean getStatus() {
		return lost;
	}

	// Getters and setters for Fieldammount below.
	public int getFieldammount_blue() {
		return fieldammount_blue;
	}

	public void setFieldammount_blue(int fieldammount_blue) {
		this.fieldammount_blue = fieldammount_blue;
	}

	public void addFieldammount_blue(){
		fieldammount_blue++;
	}
	
	public int getFieldammount_pink() {
		return fieldammount_pink;
	}

	public void setFieldammount_pink(int fieldammount_pink) {
		this.fieldammount_pink = fieldammount_pink;
	}
	
	public void addFieldammount_pink(){
		fieldammount_pink++;
	}

	public int getFieldammount_green() {
		return fieldammount_green;
	}

	public void setFieldammount_green(int fieldammount_green) {
		this.fieldammount_green = fieldammount_green;
	}

	public void addFieldammount_green(){
		fieldammount_green++;
	}
	
	public int getFieldammount_grey() {
		return fieldammount_grey;
	}

	public void setFieldammount_grey(int fieldammount_grey) {
		this.fieldammount_grey = fieldammount_grey;
	}
	
	public void addFieldammount_grey(){
		fieldammount_grey++;
	}

	public int getFieldammount_red() {
		return fieldammount_red;
	}

	public void setFieldammount_red(int fieldammount_red) {
		this.fieldammount_red = fieldammount_red;
	}

	public void addFieldammount_red(){
		fieldammount_red++;
	}
	
	public int getFieldammount_white() {
		return fieldammount_white;
	}

	public void setFieldammount_white(int fieldammount_white) {
		this.fieldammount_white = fieldammount_white;
	}

	public void addFieldammount_white(){
		fieldammount_white++;
	}
	
	public int getFieldammount_yellow() {
		return fieldammount_yellow;
	}

	public void setFieldammount_yellow(int fieldammount_yellow) {
		this.fieldammount_yellow = fieldammount_yellow;
	}
	
	public void addFieldammount_yellow(){
		fieldammount_yellow++;
	}

	public int getFieldammount_purple() {
		return fieldammount_purple;
	}

	public void setFieldammount_purple(int fieldammount_purple) {
		this.fieldammount_purple = fieldammount_purple;
	}

	public void addFieldammount_purple(){
		fieldammount_purple++;
	}
	
	public int getHouseammount() {
		return houseammount;
	}

	public void setHouseammount(int houseammount) {
		this.houseammount = houseammount;
	}
	
	public void addHouseammount(){
		houseammount++;
	}

	public int getHotelammount() {
		return hotelammount;
	}

	public void setHotelammount(int hotelammount) {
		this.hotelammount = hotelammount;
	}

	public void addHotelammount(){
		hotelammount++;
	}
	
	public boolean haveOutofjailcard() {
		return outofjailcard;
	}

	public void setOutofjailcard(boolean outofjailcard) {
		this.outofjailcard = outofjailcard;
	}

	public void removeOutofjailcard(){
		outofjailcard = false;
	}
	
	public boolean isJailed() {
		return jailed;
	}

	public void setJailed(boolean jailed) {
		this.jailed = jailed;
	}
	
}
