package mainpkg;
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainClass implements ActionListener {
	static int numCoins, numHeads, numTails;
	static JFrame mainFrame;
	static JButton b;
	static JPanel imgPanel;
	static JLabel headsLabel, tailsLabel;
	JTextField coinFlipField;

	//remote stash change
	
	/**
	 * This constructor initializes the GUI components for the coin flip application.
	 */
	MainClass () {
		ImageIcon headsImg = new ImageIcon(new ImageIcon("Heads.jpg").getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
		ImageIcon tailsImg = new ImageIcon(new ImageIcon("Tails.png").getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
		
		b = new JButton("Flip");
		b.addActionListener(this);
		b.setPreferredSize(new Dimension(100, 100));
		
		JPanel bPanel = new JPanel();
		bPanel.add(b);
		
		headsLabel = new JLabel();
		headsLabel.setPreferredSize(new Dimension(100, 100));
		headsLabel.setIcon(headsImg);
		headsLabel.setVisible(false);
		
		tailsLabel = new JLabel();
		tailsLabel.setPreferredSize(new Dimension(100, 100));
		tailsLabel.setIcon(tailsImg);
		tailsLabel.setVisible(false);
	
		imgPanel = new JPanel();
		imgPanel.add(headsLabel);
		imgPanel.add(tailsLabel);
		
		coinFlipField = new JTextField();
		coinFlipField.setPreferredSize(new Dimension(100, 50));
		
		JLabel coinFlipLabel = new JLabel("Enter number of coin flips:");
		coinFlipLabel.setHorizontalAlignment(SwingConstants.CENTER);
		coinFlipLabel.setPreferredSize(new Dimension(100, 50));
		
		JPanel coinFlipPanel = new JPanel();
		coinFlipPanel.setLayout(new GridLayout(2, 1));
		coinFlipPanel.setPreferredSize(new Dimension(200, 100));
		coinFlipPanel.add(coinFlipLabel);
		coinFlipPanel.add(coinFlipField);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(2, 1));
		
		centerPanel.add(coinFlipPanel);
		centerPanel.add(imgPanel, BorderLayout.CENTER);
		
		mainFrame = new JFrame();
		mainFrame.setSize(500, 500);
		mainFrame.setLayout(new BorderLayout());
		mainFrame.add(bPanel, BorderLayout.SOUTH);
		mainFrame.add(centerPanel, BorderLayout.CENTER);
		mainFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		numCoins = 0; // Ensure a non-negative number of coins
		numHeads = 0;
		numTails = 0;
		
		MainClass m = new MainClass();
	}
	
	/**
	 * This method simulates flipping a coin, updates the counts of heads and tails, and updates the images.
	 */
	static void flipCoin() {
		Random rand = new Random();
		boolean isHeads = rand.nextBoolean();
		
	    if (isHeads) {
	    	numHeads++;
            headsLabel.setVisible(true);
            tailsLabel.setVisible(false);
        } else {
            numTails++;
            tailsLabel.setVisible(true);
            headsLabel.setVisible(false);
        }
	    numCoins++;
	}
	
	/**
	 * handles the button click event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == b) {	
			for (int i = 0; i < Integer.parseInt(coinFlipField.getText()); i++) {
				flipCoin();
			}
			
			JOptionPane.showMessageDialog(null, "Number of coins: " + numCoins + "\n" + 
					("Percentage of coinflips that landed on tails: " + (((float)numTails / numCoins) * 100) + "%") + "\n" +
					("Percentage of coinflips that landed on heads: " + (((float)numHeads / numCoins) * 100) + "%"));
		}
	}
}
