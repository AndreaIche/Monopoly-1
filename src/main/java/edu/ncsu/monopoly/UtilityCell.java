package edu.ncsu.monopoly;

public class UtilityCell extends Cell {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String COLOR_GROUP = "UTILITY";
	private static int price1;

	public static void setPrice1(int price) {
		UtilityCell.price1 = price;
	}

	@Override
	public int getPrice() {
		return UtilityCell.price1;
	}

	public int getRent(int diceRoll) {
		if(owner.numberOfUtil() == 1) {
			return diceRoll * 4;
		} else if (owner.numberOfUtil() >= 2) {
			return diceRoll * 10;
		}
		return 0;
	}

	public void playAction() {
		Player currentPlayer = null;
		if(!isAvailable()) {
			currentPlayer = GameMaster.instance().getCurrentPlayer();
			if(owner != currentPlayer) {
				GameMaster.instance().utilRollDice();
				int diceRoll = GameMaster.instance().getUtilDiceRoll();
				currentPlayer.payRentTo(owner, getRent(diceRoll));
			}
		}
	}
}
