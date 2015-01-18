
package entity;

public class Player {
	private String name;
	private int position, fleets, laborCamp,
	fieldammount_blue,fieldammount_pink,fieldammount_green,fieldammount_grey,
	fieldammount_red,fieldammount_white,fieldammount_yellow,fieldammount_magenta,
	houseammount,hotelammount, jailcount;
	private boolean lost, outofjailcard,jailed,build_blue, build_pink, build_green,
			build_grey, build_red, build_white, build_yellow, build_magenta, paydoublefleet;
	public Account account = new Account();
		
	// Object that stores the name and position of a player
	public Player(String name) {
		position = 0;
		fleets = 0;
		laborCamp = 0;
		lost = false;
		outofjailcard = false;
		jailed = false;
		jailcount = 0;
		fieldammount_blue = 0;
		fieldammount_pink = 0;
		fieldammount_grey = 0;
		fieldammount_green = 0;
		fieldammount_red = 0;
		fieldammount_white = 0;
		fieldammount_yellow = 0;
		fieldammount_magenta = 0;
		houseammount = 0;
		hotelammount = 0;
		this.name = name;
		build_blue = false;
		build_pink = false;
		build_green = false;
		build_grey = false;
		build_red = false;
		build_white = false;
		build_yellow = false;
		build_magenta = false;
		paydoublefleet = false;
	}

	// Method that returns the name of the player
	public String getName() {
		return name;
	}

	// Method that sets the position of the player
	public void movePosition(int move) {
		if (position + move >= 40) {
			position = position + move - 40;
			passStart();
		} else {
			position += move;
		}
	}
	public void passStart(){
		account.addPoints(4000);
	}
	public void setPosition(int position){
		this.position=position;
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

	// Getters, setters and add for Fieldammount below.
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

	public int getFieldammount_magenta() {
		return fieldammount_magenta;
	}

	public void setFieldammount_magenta(int fieldammount_magenta) {
		this.fieldammount_magenta = fieldammount_magenta;
	}

	public void addFieldammount_magenta(){
		fieldammount_magenta++;
	}
	
	//getters and setters for buildings
	
	public boolean getBuy_Blue(){
		return build_blue;
	}
	
	public void setBuy_Blue(boolean khan){
		this.build_blue = khan;
	}
	
	public boolean getBuy_Pink(){
		return build_pink;
	}
	
	public void setBuy_Pink(boolean khan){
		this.build_pink = khan;
	}
	
	public boolean getBuy_Green(){
		return build_green;
	}
	
	public void setBuy_Green(boolean khan){
		this.build_green = khan;
	}
	
	public boolean getBuy_grey(){
		return build_grey;
	}
	
	public void setBuy_grey(boolean khan){
		this.build_grey = khan;
	}
	
	public boolean getBuy_Red(){
		return build_red;
	}
	
	public void setBuy_Red(boolean khan){
		this.build_red = khan;
	}
	
	public boolean getBuy_White(){
		return build_white;
	}
	
	public void setBuy_White(boolean khan){
		this.build_white = khan;
	}
	
	public boolean getBuy_Yellow(){
		return build_yellow;
	}
	
	public void setBuy_Yellow(boolean khan){
		this.build_yellow = khan;
	}
	
	public boolean getBuy_Magenta(){
		return build_magenta;
	}
	
	public void setBuy_Magenta(boolean khan){
		this.build_magenta = khan;
	}
	// Houseammount and hotelammount listed below
	
	public int getHouseammount() {
		return houseammount;
	}

	public void setHouseammount(int houseammount) {
		this.houseammount = houseammount;
	}
	
	public void addHouseammount(int houseAmount){
		houseammount += houseAmount;
	}

	public int getHotelammount() {
		return hotelammount;
	}

	public void setHotelammount(int hotelammount) {
		this.hotelammount = hotelammount;
	}

	public void addHotelammount(int hotelAmount){
		hotelammount+= hotelAmount;
	}
	
	// Jailcard and jail status

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

	public boolean hasOutofjailcard() {
		return outofjailcard;
	}

	public int getJailcount() {
		return jailcount;
	}

	public void setJailcount(int jailcount) {
		this.jailcount = jailcount;
	}
	public void addJailcount() {
		jailcount++;
	}

	public String getOwner() {
		return null;
	}

	public boolean isPaydoublefleet() {
		return paydoublefleet;
	}

	public void setPaydoublefleet(boolean paydoublefleet) {
		this.paydoublefleet = paydoublefleet;
	}
	
}
