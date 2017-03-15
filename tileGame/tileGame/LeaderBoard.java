package tileGame;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class LeaderBoard {
	public void leaderBoard(){
		JFrame leaderFrame = new JFrame("Leaderboards");
		leaderFrame.setSize(500,500);
		leaderFrame.setVisible(true);
		JLabel label = new JLabel("Show leaderboards here...");
		JPanel panel = new JPanel();
		leaderFrame.add(panel);
		panel.add(label);
		
		JButton backButton = new JButton("Back");
		
		panel.add(backButton);
		
		ActionListener listener = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == backButton){
					MainMenu menu = new MainMenu();
					menu.mainMenu();
					leaderFrame.setVisible(false);;
				}
			}
		};
		backButton.addActionListener(listener);
	}

}
