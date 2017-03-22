package tilePuzzle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FreePlayMenu extends JFrame{
	private JButton smallButton;
	private JButton mediumButton;
	private JButton largeButton;
	private JButton backButton;
	
	public void FreePlayMenu(){
		//Button properties
		smallButton = new JButton("3x3");
		mediumButton = new JButton("4x4");
		largeButton = new JButton("5x5");
		backButton = new JButton("Back");
		smallButton.setBounds(165,60,150,60);
		mediumButton.setBounds(165,130,150,60);
		largeButton.setBounds(165,200,150,60);
		backButton.setBounds(165,270,150,60);
		
		//Panel properties
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		getContentPane().add(panel);
		panel.add(smallButton);
		panel.add(mediumButton);
		panel.add(largeButton);
		panel.add(backButton);
		
		//Frame properties
		setDefaultCloseOperation(3);
		setSize(500,500);
		setTitle("FreePlay");
		setVisible(true);
		
		//Action listeners
		ActionListener listener = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == smallButton){
					dispose();
					FreePlay small = new FreePlay();
					small.SmallPuzzle();
				}
				else if(e.getSource() == mediumButton){
					dispose();
					FreePlay medium = new FreePlay();
					medium.MediumPuzzle();
				}
				else if(e.getSource() == largeButton){
					dispose();
					FreePlay large = new FreePlay();
					large.LargePuzzle();
				}
				else if(e.getSource() == backButton){
					dispose();
					MainMenu menu = new MainMenu();
					menu.MainMenu();
				}
			}
		};
		smallButton.addActionListener(listener);
		mediumButton.addActionListener(listener);
		largeButton.addActionListener(listener);
		backButton.addActionListener(listener);
	}
}