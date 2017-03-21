package tilePuzzle;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FreePlayGUI extends JFrame{
	private JButton smallButton;
	private JButton mediumButton;
	private JButton largeButton;
	private JButton backButton;
	
	public void FreePlayGUI(){
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
					MainMenuGUI main = new MainMenuGUI();
					main.MainMenuGUI();
				}
				else if(e.getSource() == smallButton){
					setVisible(false);
					SmallGrid small = new SmallGrid();
					small.SmallGrid();
					dispose();
				}
				else if(e.getSource() == mediumButton){
					setVisible(false);
					MediumGrid medium = new MediumGrid();
					medium.MediumGrid();
					dispose();
				}
				else if(e.getSource() == largeButton){
					setVisible(false);
					HardGrid hard = new HardGrid();
					hard.HardGrid();
					dispose();
				}
			}
		};
		backButton.addActionListener(listener);
		smallButton.addActionListener(listener);
		mediumButton.addActionListener(listener);
		largeButton.addActionListener(listener);
	}
}