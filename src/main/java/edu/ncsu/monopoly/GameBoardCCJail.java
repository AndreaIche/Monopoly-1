package edu.ncsu.monopoly;


public class GameBoardCCJail extends GameBoard {
    
    public GameBoardCCJail() {
		super();
		PropertyCell blue1 = new PropertyCell();
		
        CardCell cc1 = new CardCell(Card.TYPE_CC, "Community Chest 1");
        JailCell jail = new JailCell();
        CardCell chance1 = new CardCell(Card.TYPE_CHANCE, "Chance 1");
        
        Card ccCard1 = new JailCard(Card.TYPE_CC);
        blue1.setName("Blue 1");
		
		
		blue1.setColorGroup("blue");
		
		
		blue1.setPrice(100);
	
		
		blue1.setRent(10);
	
		blue1.setHousePrice(50);
		
		
		addCard(ccCard1);
		
		addCell(cc1);
		addCell(blue1);
		addCell(jail);
		
		addCell(chance1);
		
    }
}
