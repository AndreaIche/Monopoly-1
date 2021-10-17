package edu.ncsu.monopoly;

public class MockGUI implements MonopolyGUI {
    private boolean btnDrawCardState;
    private boolean btnEndTurnState;
    private boolean btnGetOutOfJailState;
    private boolean[] btnTradeState = new boolean[2];

    public void enableEndTurnBtn(int playerIndex) {
    	//Do nothing
    }

    public void enablePlayerTurn(int playerIndex) {
    	//Do nothing
    }

    public void enablePurchaseBtn(int playerIndex) {
    	//Do nothing
    }
	public int[] getDiceRoll() {
		int[] roll = new int[2];
		roll[0] = 2;
		roll[1] = 3;
		return roll;
	}

    public boolean isDrawCardButtonEnabled() {
        return btnDrawCardState;
    }

    public boolean isEndTurnButtonEnabled() {
        return btnEndTurnState;
    }
	
	public boolean isGetOutOfJailButtonEnabled() {
		return btnGetOutOfJailState;
	}

    public boolean isTradeButtonEnabled(int i) {
        return btnTradeState[i];
    }

    public void movePlayer(int index, int from, int to) {
    	//Do nothing
    }

    public RespondDialog openRespondDialog(TradeDeal deal) {
       
        return  new MockRespondDialog(deal);
    }

    public TradeDialog openTradeDialog() {
       
    	return new MockTradeDialog();
    }

    public void setBuyHouseEnabled(boolean b) {
    	//Do nothing
    }

    public void setDrawCardEnabled(boolean b) {
        btnDrawCardState = b;
    }

    public void setEndTurnEnabled(boolean enabled) {
        btnEndTurnState = enabled;
    }

    public void setGetOutOfJailEnabled(boolean b) {
    	this.btnGetOutOfJailState = b;
    }

    public void setPurchasePropertyEnabled(boolean enabled) {
    	//Do nothing
    }

    public void setRollDiceEnabled(boolean b) {
    	//Do nothing
    }

    public void setTradeEnabled(int index, boolean b) {
        this.btnTradeState[index] = b;
    }

    public void showBuyHouseDialog(Player currentPlayer) {
    	//Do nothing
    }

    public void showMessage(String string) {
    	//Do nothing
    }

	public int showUtilDiceRoll() {

		return 10;
	}

    public void startGame() {
    	//Do nothing
    }

	public void update() {
		//Do nothing
	}
}
