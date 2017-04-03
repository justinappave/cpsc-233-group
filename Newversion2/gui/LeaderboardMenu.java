/** This menu is for selecting which leaderboard you want to view.
The move score leaderboard shows who has done the least moves
The time soore eaderboard shows who has done the least time.
It prints these to the console currently
*/

package gui;

import highscores.*;
import gridgameplay.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeaderboardMenu extends JFrame{
	private JButton moveScoreButton;
	private JButton timeScoreButton;
	private JButton backButton;
	
	public LeaderboardMenu(){
		JPanel panel = new JPanel();
		moveScoreButton = new JButton("Move Score");
		timeScoreButton = new JButton("Time Score");
		backButton = new JButton("Back");
		panel.setLayout(null);
			
		//button.setBounds(x,y,width,height);
		moveScoreButton.setBounds(170,50,150,50);
		timeScoreButton.setBounds(170,110,150,50);
		backButton.setBounds(170,170,150,50);
		panel.add(moveScoreButton);
		panel.add(timeScoreButton);
		panel.add(backButton);
			
		getContentPane().add(panel);
			
		//Frame Properties
		setDefaultCloseOperation(3);
		setSize(500,500);
		setVisible(true);
		setTitle("Leaderboards");
		panel.setBackground(Color.BLACK);
        
        moveScoreButton.setActionCommand("movescore");
        timeScoreButton.setActionCommand("timescore");
        backButton.setActionCommand("backtomainmenu");
        
        MenuListener listener = new MenuListener();
        moveScoreButton.addActionListener(listener);
        timeScoreButton.addActionListener(listener);
        backButton.addActionListener(listener);
	}
}