package tilePuzzle;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGUI extends JFrame{
	private JButton quickButton;
	private JButton menuButton;
	private JButton quitButton;
	
	public void MenuGUI(){
		JPanel panel = new JPanel();
		quickButton = new JButton("QuickPlay");
		menuButton = new JButton("Main Menu");
		quitButton = new JButton("Quit");
		panel.setLayout(null);
			
		//button.setBounds(x,y,width,height);
		quickButton.setBounds(170,50,150,50);
		menuButton.setBounds(170,110,150,50);
		quitButton.setBounds(170,170,150,50);
		panel.add(quickButton);
		panel.add(menuButton);
		panel.add(quitButton);
			
		getContentPane().add(panel);
			
		//Frame Properties
		setDefaultCloseOperation(3);
		setSize(500,500);
		setVisible(true);
		setTitle("Tile Game");
		panel.setBackground(Color.BLACK);

		ActionListener listener = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == quickButton){
					setVisible(false);
					QuickPlayGUI quick = new QuickPlayGUI();
					quick.QuickPlayGUI();
					dispose();
					}
				else if(e.getSource() == menuButton){
					setVisible(false);
					MainMenuGUI main = new MainMenuGUI();
					main.MainMenuGUI();
				}
				else if(e.getSource() == quitButton){
					dispose();
				}
			}
		};
		quickButton.addActionListener(listener);
		menuButton.addActionListener(listener);
		quitButton.addActionListener(listener);
		}
	}