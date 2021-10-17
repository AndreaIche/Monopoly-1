package edu.ncsu.monopoly;

import java.io.Serializable;

public abstract class Cell implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String colorGroup1 = "RAILROAD";
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

    public static String getColorGroup1() {
		return colorGroup1;
	}

	public static void setColorGroup1(String colorGroup) {
		Cell.colorGroup1 = colorGroup;
	}
}
