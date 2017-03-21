package tilePuzzle;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeaderboardMenu extends JFrame{
	private JButton moveScoreButton;
	private JButton timeScoreButton;
	private JButton backButton;
	
	public void LeaderboardMenu(){
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

		ActionListener listener = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			HighscoreManager hm = new HighscoreManager();
			if(e.getSource() == moveScoreButton){
				//setVisible(false);
				System.out.println(hm.readHighscore(1));
			}
			else if(e.getSource() == timeScoreButton){
				//setVisible(false);
				System.out.println(hm.readHighscore(2));
			}
			else if(e.getSource() == backButton){
				MainMenu menu = new MainMenu();
				menu.MainMenu();
				dispose();
			}
		}
	};
	moveScoreButton.addActionListener(listener);
	timeScoreButton.addActionListener(listener);
	backButton.addActionListener(listener);
	}
}