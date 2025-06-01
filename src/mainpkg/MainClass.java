package mainpkg;
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainClass implements ActionListener {
	static int numCoins, numHeads, numTails;
	static JFrame mainFrame;
	static JButton b;
	static JPanel imgPanel;
	static JLabel headsLabel, tailsLabel;
	
	MainClass () {
		ImageIcon headsImg =new ImageIcon(new ImageIcon("Heads.jpg").getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
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
		
		mainFrame = new JFrame();
		mainFrame.setSize(500, 500);
		mainFrame.setLayout(new BorderLayout());
		mainFrame.add(bPanel, BorderLayout.SOUTH);
		mainFrame.add(imgPanel, BorderLayout.CENTER);
		mainFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		numCoins = 0; // Ensure a non-negative number of coins
		numHeads = 0;
		numTails = 0;
		
		MainClass m = new MainClass();
	}
	
	static void flipCoin() {
		Random rand = new Random();
		boolean isHeads = rand.nextBoolean();
		
	    if (isHeads) {
	    	numHeads++;
            System.out.println("Heads");
            headsLabel.setVisible(true);
            tailsLabel.setVisible(false);
        } else {
            numTails++;
            System.out.println("Tails");
            tailsLabel.setVisible(true);
            headsLabel.setVisible(false);
        }
	    numCoins++;
	    
	    imgPanel.revalidate();
	    imgPanel.repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == b) {	
			flipCoin();
			
			System.out.println("Number of coins: " + numCoins);
			System.out.println("Percentage of coinflips that landed on heads: " + (((float)numHeads / numCoins) * 100) + "%");
			System.out.println("Percentage of coinflips that landed on tails: " + (((float)numTails / numCoins) * 100) + "%");
		}
	}
}
