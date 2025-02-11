package edu.ncsu.monopoly;

public class GameBoardRailRoad extends GameBoard {
	public GameBoardRailRoad() {
		super();
		PropertyCell blue1 = new PropertyCell();
		
		PropertyCell green1 = new PropertyCell();
		
		JailCell jail = new JailCell();
		GoToJailCell goToJail = new GoToJailCell();
		FreeParkingCell freeParking = new FreeParkingCell();
		Cell rr1 = new RailRoadCell();
		Cell rr2 = new RailRoadCell();
		Cell rr3 = new RailRoadCell();
		Cell rr4 = new RailRoadCell();
		
		blue1.setName("Blue 1");
		
		green1.setName("Green 1");
		
		
		blue1.setColorGroup("blue");
	
		green1.setColorGroup("green");
	
		
		rr1.setName("Railroad A");
		rr2.setName("Railroad B");
		rr3.setName("Railroad C");
		rr4.setName("Railroad D");
		RailRoadCell.setPrice(200);
		RailRoadCell.setBaseRent(25);
		
		blue1.setPrice(100);
	
		green1.setPrice(200);
	
		blue1.setRent(10);
	
		green1.setRent(20);
		
		
		blue1.setHousePrice(50);
		
		green1.setHousePrice(70);
		
		
		addCell(rr1);
		addCell(blue1);
		addCell(jail);
		addCell(rr2);
		
		addCell(freeParking);
		addCell(green1);
		addCell(rr3);
		addCell(goToJail);
		
		addCell(rr4);
	}
}
