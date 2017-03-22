package tilePuzzle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainMenu extends JFrame{
	private JButton freeButton;
	private JButton timeButton;
	private JButton leaderButton;
	private JButton backButton;
	
	public void MainMenu(){
		//Button properties
		freeButton = new JButton("FreePlay");
		timeButton = new JButton("TimePlay");
		leaderButton = new JButton("Leaderboards");
		backButton = new JButton("Back");
		freeButton.setBounds(165,60,150,60);
		timeButton.setBounds(165,130,150,60);
		leaderButton.setBounds(165,200,150,60);
		backButton.setBounds(165,270,150,60);
		
		//Panel properties
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		getContentPane().add(panel);
		panel.add(freeButton);
		panel.add(timeButton);
		panel.add(leaderButton);
		panel.add(backButton);
		
		//Frame properties
		setDefaultCloseOperation(3);
		setSize(500,500);
		setTitle("Main Menu");
		setVisible(true);
		
		//Action listeners
		ActionListener listener = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == freeButton){
					dispose();
					FreePlayMenu free = new FreePlayMenu();
					free.FreePlayMenu();
				}
				else if(e.getSource() == timeButton){
					dispose();
					TimePlayMenu time = new TimePlayMenu();
					time.TimePlayMenu();
				}
				else if(e.getSource() == leaderButton){
					dispose();
				}
				else if(e.getSource() == backButton){
					dispose();
					Menu menu = new Menu();
					menu.Menu();
				}
			}
		};
		freeButton.addActionListener(listener);
		timeButton.addActionListener(listener);
		//leaderButton.addActionListener(listener);
		backButton.addActionListener(listener);
	}
}