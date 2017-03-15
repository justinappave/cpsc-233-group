package tileGame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class TimePlay {
	public void playTime(){
		JFrame timeFrame = new JFrame("TimePlay");
		timeFrame.setSize(600,500);
		timeFrame.setLayout(new GridBagLayout());
		timeFrame.setVisible(true);
		
		JPanel panel = new JPanel();
		timeFrame.add(panel);
		
		JButton easyButton = new JButton("Easy (5:00)");
		JButton mediumButton = new JButton("Medium (3:00)");
		JButton hardButton = new JButton("Hard (1:00)");
		JButton backButton = new JButton("Back");
		JButton quitButton = new JButton("Quit");
		
		panel.add(easyButton);
		panel.add(mediumButton);
		panel.add(hardButton);
		panel.add(backButton);
		panel.add(quitButton);
		
		ActionListener listener = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == backButton){
					MainMenu menu = new MainMenu();
					menu.mainMenu();
					timeFrame.setVisible(false);
				}
				else if(e.getSource() == quitButton){
					timeFrame.dispose();
				}
			}
		};
		backButton.addActionListener(listener);
		quitButton.addActionListener(listener);
	}
}