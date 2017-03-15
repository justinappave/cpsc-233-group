package tileGame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu {
	public void mainMenu(){
		JFrame mainFrame = new JFrame("Main Menu");
		mainFrame.setSize(500,500);
		mainFrame.setLayout(new GridBagLayout());
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		mainFrame.add(panel);
		
		JButton freeButton = new JButton("FreePlay");
		JButton timeButton = new JButton("TimePlay");
		JButton leaderButton = new JButton("Leaderboards");
		JButton backButton = new JButton("Back");
		JButton quitButton = new JButton("Quit");
		
		panel.add(freeButton);
		panel.add(timeButton);
		panel.add(leaderButton);
		panel.add(backButton);
		panel.add(quitButton);
		
		ActionListener listener = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == freeButton){
					FreePlay free = new FreePlay();
					free.playFree();
					mainFrame.setVisible(false);
				}
				else if(e.getSource() == timeButton){
					TimePlay time = new TimePlay();
					time.playTime();
					mainFrame.setVisible(false);
				}
				else if(e.getSource() == leaderButton){
					LeaderBoard leader = new LeaderBoard();
					leader.leaderBoard();
					mainFrame.setVisible(false);
				}
				else if(e.getSource() == quitButton){
					mainFrame.dispose();
				}
			}
		};
		freeButton.addActionListener(listener);
		timeButton.addActionListener(listener);
		leaderButton.addActionListener(listener);
		backButton.addActionListener(listener);
		quitButton.addActionListener(listener);
	}
}