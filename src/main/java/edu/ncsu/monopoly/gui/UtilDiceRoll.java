package edu.ncsu.monopoly.gui;

import java.awt.BorderLayout;

import java.awt.Container;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.ncsu.monopoly.GameMaster;

public class UtilDiceRoll extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("deprecation")
	public static int showDialog() {
		UtilDiceRoll dialog = new UtilDiceRoll();
		dialog.show();
		return dialog.diceValue;
	}
	JButton btnDice = new JButton("Roll the Dice!");
	private JButton btnOK = new JButton("OK");
	private int diceValue;
	private JLabel lblPrompt = new JLabel();

	public UtilDiceRoll() {
		setModal(true);
		btnOK.setEnabled(false);
		lblPrompt.setText("Please roll the dice to determine your utility bill.");
		Container contentPane = getContentPane();
		JPanel pnlButtons = new JPanel();
		pnlButtons.add(btnDice);
		pnlButtons.add(btnOK);
		contentPane.setLayout(new BorderLayout());
		contentPane.add(lblPrompt, BorderLayout.CENTER);
		contentPane.add(pnlButtons, BorderLayout.SOUTH);
		
		btnDice.addActionListener(arg0 ->rollDice());
		
		btnOK.addActionListener(arg0 ->okClicked() );
		
		this.pack();
	}
	
	public void okClicked(){
		this.dispose();
	}
	
	public void rollDice() {
		int[] diceRoll = GameMaster.instance().rollDice();
		this.diceValue = diceRoll[0] + diceRoll[1];
		lblPrompt.setText("You rolled " + diceValue);
		btnDice.setEnabled(false);
		btnOK.setEnabled(true);
	}
}
