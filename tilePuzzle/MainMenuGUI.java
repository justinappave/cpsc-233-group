package tilePuzzle;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuGUI extends JFrame{
	private JButton freeButton;
	private JButton timeButton;
	private JButton leaderButton;
	private JButton backButton;
	
	public void MainMenuGUI(){
		JPanel panel = new JPanel();
		freeButton = new JButton("FreePlay");
		timeButton = new JButton("TimePlay");
		leaderButton = new JButton("Leaderboards");
		backButton = new JButton("Back");
		panel.setLayout(null);
		
		//button.setBounds(x,y,width,height);
		freeButton.setBounds(170,50,150,50);
		timeButton.setBounds(170,110,150,50);
		leaderButton.setBounds(170,170,150,50);
		backButton.setBounds(170,230,150,50);
		panel.add(freeButton);
		panel.add(timeButton);
		panel.add(leaderButton);
		panel.add(backButton);
		
		getContentPane().add(panel);
		
		//Frame Properties
		setDefaultCloseOperation(3);
		setSize(500,500);
		setVisible(true);
		setTitle("Main Menu");
		panel.setBackground(Color.BLACK);
		
		ActionListener listener = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == freeButton){
					setVisible(false);
					FreePlayGUI free = new FreePlayGUI();
					free.FreePlayGUI();
				}
				else if(e.getSource() == timeButton){
					setVisible(false);
					TimePlayGUI time = new TimePlayGUI();
					time.TimePlayGUI();
				}
				else if(e.getSource() == leaderButton){
					//setVisible(false);
					//HighscoreManagerTest leader = new HighscoreManagerTest();
					//leader.HighscoreManagerTest();
				}
				else if(e.getSource() == backButton){
					setVisible(false);
					MenuGUI start = new MenuGUI();
					start.MenuGUI();
				}
			}
		};
		freeButton.addActionListener(listener);
		timeButton.addActionListener(listener);
		leaderButton.addActionListener(listener);
		backButton.addActionListener(listener);
		}
	}