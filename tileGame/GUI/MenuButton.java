package tileGame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class MenuButton {
	public static void main(String[] args){
		JFrame startFrame = new JFrame("Tile Game");
		startFrame.setSize(500,500);
		startFrame.setLayout(new GridBagLayout());
		startFrame.setVisible(true);
		
		JPanel panel = new JPanel();
		startFrame.add(panel);
		
		JButton quickButton = new JButton("Quickplay");
		JButton mainButton = new JButton("Main Menu");
		JButton quitButton = new JButton("Quit");
		
		panel.add(quickButton);
		panel.add(mainButton);
		panel.add(quitButton);
		
		ActionListener listener = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == quickButton){
					QuickPlay quick = new QuickPlay();
					quick.playQuick();
					startFrame.setVisible(false);
				}
				else if(e.getSource() == mainButton){
					MainMenu main = new MainMenu();
					main.mainMenu();
					startFrame.setVisible(false);
				}
				else if(e.getSource() == quitButton){
					startFrame.dispose();
				}
			}
		};
		quickButton.addActionListener(listener);
		mainButton.addActionListener(listener);
		quitButton.addActionListener(listener);
	}

}
