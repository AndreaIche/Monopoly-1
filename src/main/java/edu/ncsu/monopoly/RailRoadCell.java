package edu.ncsu.monopoly;

public class RailRoadCell extends Cell {
	private static  int baseRent;
	private static  int price1;

	public static void setBaseRent(int baseRent) {
		RailRoadCell.baseRent = baseRent;
	}

	
	public static void setPrice(int price) {
		RailRoadCell.price1 = price;
	}
	
	@Override
	public int getPrice() {
		return RailRoadCell.price1;
	}

	public int getRent() {
		return RailRoadCell.baseRent * (int)Math.pow(2, owner.numberOfRR() - 1f);
	}
	
	public void playAction() {
		Player currentPlayer = null;
		if(!isAvailable()) {
			currentPlayer = GameMaster.instance().getCurrentPlayer();
			if(owner != currentPlayer) {
				currentPlayer.payRentTo(owner, getRent());
			}
		}
	}
}
