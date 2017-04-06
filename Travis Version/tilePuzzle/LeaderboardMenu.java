package tilePuzzle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LeaderboardMenu implements ActionListener {
	private JFrame frame;
	private JPanel pane, upperPane, lowerPane;
	private JButton moveScoreButton, timeScoreButton, leaderButton, backButton;
	private JLabel title;
	
	LeaderboardMenu() {
		//Label properties
		title = new JLabel("Leaderboards");
		title.setFont(new Font("ARIAL", Font.BOLD, 50));
		title.setForeground(Color.GREEN);
		
		//Button properties
		moveScoreButton = new JButton("Move Scores");
		moveScoreButton.setPreferredSize(new Dimension(400,90));
		moveScoreButton.setFont(new Font("ARIAL", Font.BOLD, 40));
		moveScoreButton.setForeground(Color.WHITE);
		moveScoreButton.setBackground(Color.BLACK);
		moveScoreButton.setBorderPainted(false);
		moveScoreButton.setFocusPainted(false);
		
		timeScoreButton = new JButton("Time Scores");
		timeScoreButton.setPreferredSize(new Dimension(400,90));
		timeScoreButton.setFont(new Font("ARIAL", Font.BOLD, 40));
		timeScoreButton.setForeground(Color.WHITE);
		timeScoreButton.setBackground(Color.BLACK);
		timeScoreButton.setBorderPainted(false);
		timeScoreButton.setFocusPainted(false);
		
		backButton = new JButton("Back");
		backButton.setPreferredSize(new Dimension(400,90));
		backButton.setFont(new Font("ARIAL", Font.BOLD, 40));
		backButton.setForeground(Color.WHITE);
		backButton.setBackground(Color.BLACK);
		backButton.setBorderPainted(false);
		backButton.setFocusPainted(false);
		
		//Panel properties
		lowerPane = new JPanel(new FlowLayout());
		lowerPane.setPreferredSize(new Dimension(800,500));
		lowerPane.setBackground(Color.BLACK);
		lowerPane.add(moveScoreButton);lowerPane.add(timeScoreButton);lowerPane.add(backButton);
		
		upperPane = new JPanel(new FlowLayout());
		upperPane.setPreferredSize(new Dimension(800,300));
		upperPane.setBackground(Color.BLACK);
		upperPane.add(title);
		
		pane = new JPanel(new BorderLayout());
		pane.setBackground(Color.BLACK);
		pane.add(lowerPane, BorderLayout.PAGE_END);pane.add(upperPane, BorderLayout.PAGE_START);
		
		//Frame properties
		frame = new JFrame("TILE PUZZLE GAME");
		frame.setSize(800,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(pane);
		
		//Add action commands and action listeners
		moveScoreButton.setActionCommand("Move Scores");
		timeScoreButton.setActionCommand("Time Scores");
		backButton.setActionCommand("Back");
		moveScoreButton.addActionListener(this);
		timeScoreButton.addActionListener(this);
		backButton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Move Scores")) {
			Driver getMode = new Driver();
			getMode.Leaderboards();
			frame.setVisible(false);
		}
		else if(e.getActionCommand().equals("Time Scores")) {
			Driver getMode = new Driver();
			getMode.Leaderboards();
			frame.setVisible(false);
		}
		else if(e.getActionCommand().equals("Back")) {
			Driver getMode = new Driver();
			getMode.MainMenu();
			frame.setVisible(false);
		}
	}
}