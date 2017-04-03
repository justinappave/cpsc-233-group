/** This menu is for selecting the difficulty of the freeplay mode (grid size)
*/

package gui;

import gridgameplay.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FreePlayGUI extends JFrame{
	private JButton smallButton;
	private JButton mediumButton;
	private JButton largeButton;
	private JButton backButton;
	
	public FreePlayGUI() {
		JPanel panel = new JPanel();
		smallButton = new JButton("3x3");
		mediumButton = new JButton("4x4");
		largeButton = new JButton("5x5");
		backButton = new JButton("Back");
		panel.setLayout(null);
		
		//button.setBounds(x,y,width,height);
		smallButton.setBounds(170,50,150,50);
		mediumButton.setBounds(170,110,150,50);
		largeButton.setBounds(170,170,150,50);
		backButton.setBounds(170,230,150,50);
		panel.add(smallButton);
		panel.add(mediumButton);
		panel.add(largeButton);
		panel.add(backButton);
		
		getContentPane().add(panel);
		
		//Frame Properties
		setDefaultCloseOperation(3);
		setSize(500,500);
		setVisible(true);
		setTitle("FreePlay");
		panel.setBackground(Color.BLACK);
		
		ActionListener listener = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == backButton){
					setVisible(false);
					MainMenu main = new MainMenu();
					main.MainMenu();
				}
				else if(e.getSource() == smallButton){
					setVisible(false);
					int size = 3;
                    FreePlay freeplay = new FreePlay(size);
					MenuGUI start = new MenuGUI();
					dispose();
					start.MenuGUI();
				}
				else if(e.getSource() == mediumButton){
					setVisible(false);
					int size = 4;
                    FreePlay freeplay = new FreePlay(size);
					MenuGUI start = new MenuGUI();
					dispose();
					start.MenuGUI();
				}
				else if(e.getSource() == largeButton){
					setVisible(false);
                    int size = 5;
                    FreePlay freeplay = new FreePlay(size);
					MenuGUI start = new MenuGUI();
					dispose();
					start.MenuGUI();
				}
			}
		};
		backButton.addActionListener(listener);
		smallButton.addActionListener(listener);
		mediumButton.addActionListener(listener);
		largeButton.addActionListener(listener);
	}
}