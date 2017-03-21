package tilePuzzle;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimePlayGUI extends JFrame{
	private JButton easyButton;
	private JButton mediumButton;
	private JButton hardButton;
	private JButton backButton;
	
	public void TimePlayGUI(){
		JPanel panel = new JPanel();
		easyButton = new JButton("Easy (5:00)");
		mediumButton = new JButton("Medium (3:00)");
		hardButton = new JButton("Hard (1:00)");
		backButton = new JButton("Back");
		panel.setLayout(null);
		
		//button.setBounds(x,y,width,height);
		easyButton.setBounds(170,50,150,50);
		mediumButton.setBounds(170,110,150,50);
		hardButton.setBounds(170,170,150,50);
		backButton.setBounds(170,230,150,50);
		panel.add(easyButton);
		panel.add(mediumButton);
		panel.add(hardButton);
		panel.add(backButton);
		
		getContentPane().add(panel);
		
		//Frame Properties
		setDefaultCloseOperation(3);
		setSize(500,500);
		setVisible(true);
		setTitle("TimePlay");
		panel.setBackground(Color.BLACK);
		
		ActionListener listener = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == backButton){
					setVisible(false);
					MainMenuGUI main = new MainMenuGUI();
					main.MainMenuGUI();
				}
				else if(e.getSource() == easyButton){
					//setVisible(false);
					//Gameplay time = new Gameplay();
					//time.timeplay(1);
					//Menu start = new Menu();
					//dispose();
					//start.Menu();
				}
				else if(e.getSource() == mediumButton){
					//setVisible(false);
					//Gameplay time = new Gameplay();
					//time.timeplay(2);
					//Menu start = new Menu();
					//dispose();
					//start.Menu();
				}
				else if(e.getSource() == hardButton){
					//setVisible(false);
					//Gameplay time = new Gameplay();
					//time.timeplay(3);
					//Menu start = new Menu();
					//dispose();
					//start.Menu();
				}
			}
		};
		backButton.addActionListener(listener);
		easyButton.addActionListener(listener);
		mediumButton.addActionListener(listener);
		hardButton.addActionListener(listener);
	}
}