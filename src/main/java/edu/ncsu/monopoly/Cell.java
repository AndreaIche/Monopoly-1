package edu.ncsu.monopoly;

public abstract class Cell {
	private static String COLOR_GROUP = "RAILROAD";
	private boolean available = true;
	private String name;
	protected Player owner;
	static final int PRICE= 0;

	public String getName() {
		return name;
	}

	public Player getOwner() {
		return owner;
	}
	
	public int getPrice() {
		return PRICE; 
	}

	public boolean isAvailable() {
		return available;
	}
	
	public abstract void playAction();

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	void setName(String name) {
		this.name = name;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}
    
    public String toString() {
        return name;
    }

    public static String getCOLOR_GROUP() {
		return COLOR_GROUP;
	}

	public static void setCOLOR_GROUP(String colorGroup) {
		Cell.COLOR_GROUP = colorGroup;
	}
}
