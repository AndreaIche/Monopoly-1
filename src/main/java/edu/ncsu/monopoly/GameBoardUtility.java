package edu.ncsu.monopoly;

public class GameBoardUtility extends GameBoard {
	public GameBoardUtility() {
		super();
		PropertyCell blue1 = new PropertyCell();
		
		PropertyCell green1 = new PropertyCell();
		
		JailCell jail = new JailCell();
		GoToJailCell goToJail = new GoToJailCell();
		FreeParkingCell freeParking = new FreeParkingCell();
		Cell rr1 = new RailRoadCell();
		Cell rr3 = new RailRoadCell();
		UtilityCell u1 = new UtilityCell();
		UtilityCell u2 = new UtilityCell();
		
		blue1.setName("Blue 1");
		
		green1.setName("Green 1");
		
		
		blue1.setColorGroup("blue");
		
		green1.setColorGroup("green");
		
		
		rr1.setName("Railroad A");
		rr3.setName("Railroad C");
		RailRoadCell.setPrice(200);
		RailRoadCell.setBaseRent(25);
		
		u1.setName("Utility 1");
		u2.setName("Utility 2");
		UtilityCell.setPrice(150);
		
		blue1.setPrice(100);
		
		green1.setPrice(200);
		
		
		blue1.setRent(10);
		
		green1.setRent(20);
		
		
		blue1.setHousePrice(50);
		
		green1.setHousePrice(70);
		
		
		addCell(rr1);
		addCell(blue1);
		addCell(jail);
		addCell(u1);
		
		addCell(freeParking);
		addCell(green1);
		addCell(rr3);
		addCell(goToJail);
		
		addCell(u2);
	}
}
