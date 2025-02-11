package edu.ncsu.monopoly.gui;

import java.awt.*;



import javax.swing.*;

import edu.ncsu.monopoly.RespondDialog;
import edu.ncsu.monopoly.TradeDeal;


public class GUIRespondDialog extends JDialog implements RespondDialog {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean response;
    JTextArea txtMessage = new JTextArea();
    
    @SuppressWarnings("deprecation")
	public GUIRespondDialog() {
        JButton btnYes = new JButton("Yes");
        JButton btnNo = new JButton("No");
        txtMessage.setPreferredSize(new Dimension(300, 200));
        txtMessage.setEditable(false);
        txtMessage.setLineWrap(true);
        
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(txtMessage, BorderLayout.CENTER);
        JPanel pnlButtons = new JPanel();
        pnlButtons.add(btnYes);
        pnlButtons.add(btnNo);
        contentPane.add(pnlButtons, BorderLayout.SOUTH);
        
        btnYes.addActionListener(e-> {response = true;
        hide();});
        
        btnNo.addActionListener(e->{response = false;
        hide();});
        
    
        setModal(true);
        pack();
    }

    public boolean getResponse() {
        return response;
    }
    
    public void setDeal(TradeDeal deal) {
        txtMessage.setText(deal.makeMessage());
    }

}
