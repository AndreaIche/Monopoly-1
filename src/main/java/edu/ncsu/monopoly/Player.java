package edu.ncsu.monopoly;

import java.io.Serializable;

import java.util.ArrayList;

import java.util.Enumeration;

import java.util.Hashtable;



public class Player implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//the key of colorGroups is the name of the color group.
	private Hashtable<String, Integer> colorGroups = new Hashtable<>();
	private boolean inJail;
	private int money;
	private String name;
	public static final String COLORGROUP = "RAILROAD";
	private Cell position;
	private ArrayList<PropertyCell> properties = new ArrayList<>();
	private ArrayList<Cell> railroads = new ArrayList<>();
	private ArrayList<Cell> utilities = new ArrayList<>();
	
	public Player() {
		GameBoard gb = GameMaster.instance().getGameBoard();
		inJail = false;
		if(gb != null) {
			position = gb.queryCell("Go");
		}
	}

    public void buyProperty(Cell property, int amount) {
        property.setOwner(this);
        if(property instanceof PropertyCell) {
            PropertyCell cell = (PropertyCell)property;
            properties.add(cell);
            colorGroups.put(
                    cell.getColorGroup(), 
                    Integer.valueOf(getPropertyNumberForColor(cell.getColorGroup())+1));
        }
        if(property instanceof RailRoadCell) {
            railroads.add(property);
            colorGroups.put(
                    Cell.getColorGroup1(), 
                    Integer.valueOf(getPropertyNumberForColor(Cell.getColorGroup1())+1));
        }
        if(property instanceof UtilityCell) {
            utilities.add(property);
            colorGroups.put(
                    UtilityCell.COLOR_GROUP, 
                    Integer.valueOf(getPropertyNumberForColor(UtilityCell.COLOR_GROUP)+1));
        }
        setMoney(getMoney() - amount);
    }
	
	public boolean canBuyHouse() {
		return (getMonopolies().length != 0);
	}

	public boolean checkProperty(String property) {
		for(int i=0;i<properties.size();i++) {
			Cell cell = properties.get(i);
			if(cell.getName().equals(property)) {
				return true;
			}
		}
		return false;
		
	}
	
	public void exchangeProperty(Player player) {
		for(int i = 0; i < getPropertyNumber(); i++ ) {
			PropertyCell cell = getProperty(i);
			cell.setOwner(player);
			if(player == null) {
				cell.setAvailable(true);
				cell.setNumHouses(0);
			}
			else {
				player.properties.add(cell);
				colorGroups.put(
						cell.getColorGroup(), 
						Integer.valueOf(getPropertyNumberForColor(cell.getColorGroup())+1));
			}
		}
		properties.clear();
	}
    
    public Cell[] getAllProperties() {
        ArrayList<Cell> list = new ArrayList<>();
        list.addAll(properties);
        list.addAll(utilities);
        list.addAll(railroads);
        return list.toArray(new Cell[list.size()]);
    }

	public int getMoney() {
		return this.money;
	}
	
	public String[] getMonopolies() {
		ArrayList<String> monopolies = new ArrayList<>();
		
		Enumeration<String> colors =   colorGroups.keys();
		while(colors.hasMoreElements()) {
			String color = colors.nextElement();
            if(!(color.equals(Cell.getColorGroup1())) && !(color.equals(UtilityCell.COLOR_GROUP))) {
    			Integer num = colorGroups.get(color);
    			GameBoard gameBoard = GameMaster.instance().getGameBoard();
    			if(num.intValue() == gameBoard.getPropertyNumberForColor(color)) {
    				monopolies.add(color);
    			}
            }
		}
		return monopolies.toArray(new String[monopolies.size()]);
	}

	public String getName() {
		return name;
	}

	public void getOutOfJail() {
		money -= JailCell.BAIL;
		if(isBankrupt()) {
			money = 0;
			exchangeProperty(null);
		}
		inJail = false;
		GameMaster.instance().updateGUI();
	}

	public Cell getPosition() {
		return this.position;
	}
	
	public PropertyCell getProperty(int index) {
		return properties.get(index);
	}
	
	public int getPropertyNumber() {
		return properties.size();
	}

	private int getPropertyNumberForColor(String name) {
		Integer number = colorGroups.get(name);
		if(number != null) {
			return number.intValue();
		}
		return 0;
	}

	public boolean isBankrupt() {
		return money <= 0;
	}

	public boolean isInJail() {
		return inJail;
	}

	public int numberOfRR() {
		return getPropertyNumberForColor(Cell.getColorGroup1());
	}

	public int numberOfUtil() {
		return getPropertyNumberForColor(UtilityCell.COLOR_GROUP);
	}
	
	public void payRentTo(Player owner, int rentValue) {
		if(money < rentValue) {
			owner.money += money;
			money -= rentValue;
		}
		else {
			money -= rentValue;
			owner.money +=rentValue;
		}
		if(isBankrupt()) {
			money = 0;
			exchangeProperty(owner);
		}
	}
	
	public void purchase() {
		if(getPosition().isAvailable()) {
			Cell c = getPosition();
			c.setAvailable(false);
			if(c instanceof PropertyCell) {
				PropertyCell cell = (PropertyCell)c;
				purchaseProperty(cell);
			}
			if(c instanceof RailRoadCell) {
				Cell cell = c;
				purchaseRailRoad(cell);
			}
			if(c instanceof UtilityCell) {
				UtilityCell cell = (UtilityCell)c;
				purchaseUtility(cell);
			}
		}
	}
	
	public void purchaseHouse(String selectedMonopoly, int houses) {
		GameBoard gb = GameMaster.instance().getGameBoard();
		PropertyCell[] cells = gb.getPropertiesInMonopoly(selectedMonopoly);
		if((money >= (cells.length * (cells[0].getHousePrice() * houses)))) {
			for(int i = 0; i < cells.length; i++) {
				int newNumber = cells[i].getNumHouses() + houses;
				if (newNumber <= 5) {
					cells[i].setNumHouses(newNumber);
					this.setMoney(money - (cells[i].getHousePrice() * houses));
					GameMaster.instance().updateGUI();
				}
			}
		}
	}
	
	private void purchaseProperty(PropertyCell cell) {
        buyProperty(cell, cell.getPrice());
	}

	private void purchaseRailRoad(Cell cell) {
	    buyProperty(cell, cell.getPrice());
	}

	private void purchaseUtility(UtilityCell cell) {
	    buyProperty(cell, cell.getPrice());
	}

    public void sellProperty(Cell property, int amount) {
        property.setOwner(null);
        if(property instanceof PropertyCell) {
            properties.remove(property);
        }
        if(property instanceof RailRoadCell) {
            railroads.remove(property);
        }
        if(property instanceof UtilityCell) {
            utilities.remove(property);
        }
        setMoney(getMoney() + amount);
    }

	public void setInJail(boolean inJail) {
		this.inJail = inJail;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPosition(Cell newPosition) {
		this.position = newPosition;
	}

    public String toString() {
        return name;
    }
    
    public void resetProperty() {
    	properties = new ArrayList<>();
    	railroads = new ArrayList<>();
    	utilities = new ArrayList<>();
	}
}
