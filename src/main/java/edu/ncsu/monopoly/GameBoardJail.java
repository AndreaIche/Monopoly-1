package edu.ncsu.monopoly;

public class GameBoardJail extends GameBoard {
	public GameBoardJail() {
		super();
		PropertyCell blue1 = new PropertyCell();
		
		PropertyCell green1 = new PropertyCell();
		
		JailCell jail = new JailCell();
		GoToJailCell goToJail = new GoToJailCell();
		
		blue1.setName("Blue 1");
		
		green1.setName("Green 1");
		
		
		blue1.setColorGroup("blue");
		
		green1.setColorGroup("green");
		
		
		blue1.setPrice(100);
	
		green1.setPrice(200);
		
		
		blue1.setRent(10);
		
		green1.setRent(20);
		
		
		blue1.setHousePrice(50);
		
		green1.setHousePrice(70);
		
		
		addCell(blue1);
		addCell(jail);
	
		addCell(green1);
		addCell(goToJail);
		
	}
}
