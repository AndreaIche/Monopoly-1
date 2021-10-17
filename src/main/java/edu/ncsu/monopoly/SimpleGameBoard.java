package edu.ncsu.monopoly;


public class SimpleGameBoard extends GameBoard {
	public SimpleGameBoard() {
		super();
		PropertyCell blue1 = new PropertyCell();
		
		PropertyCell green1 = new PropertyCell();
		
		
		blue1.setName("Blue 1");
		
		green1.setName("Green 1");
		
		
		blue1.setColorGroup("blue");
		
		green1.setColorGroup("green");
		
		
		blue1.setPrice(100);
		
		green1.setPrice(200);
		
		
		blue1.setRent(10);
		
		green1.setRent(1600);
		
		
		blue1.setHousePrice(50);
		
		green1.setHousePrice(70);
		
		
		addCell(blue1);
		
		
		addCell(green1);
		
	}
}
