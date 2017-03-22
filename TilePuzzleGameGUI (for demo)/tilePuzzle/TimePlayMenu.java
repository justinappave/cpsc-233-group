package tilePuzzle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TimePlayMenu extends JFrame{
	private JButton easyButton;
	private JButton mediumButton;
	private JButton hardButton;
	private JButton backButton;
	
	public void TimePlayMenu(){
		//Button properties
		easyButton = new JButton("Easy (5:00)");
		mediumButton = new JButton("Medium (3:00)");
		hardButton = new JButton("Hard (1:00)");
		backButton = new JButton("Back");
		easyButton.setBounds(165,60,150,60);
		mediumButton.setBounds(165,130,150,60);
		hardButton.setBounds(165,200,150,60);
		backButton.setBounds(165,270,150,60);
		
		//Panel properties
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		getContentPane().add(panel);
		panel.add(easyButton);
		panel.add(mediumButton);
		panel.add(hardButton);
		panel.add(backButton);
		
		//Frame properties
		setDefaultCloseOperation(3);
		setSize(500,500);
		setTitle("TimePlay");
		setVisible(true);
		
		//Action listeners
		ActionListener listener = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == easyButton){
					dispose();
					FreePlay small = new FreePlay();
					small.SmallPuzzle();
				}
				else if(e.getSource() == mediumButton){
					dispose();
					FreePlay medium = new FreePlay();
					medium.MediumPuzzle();
				}
				else if(e.getSource() == hardButton){
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
		//easyButton.addActionListener(listener);
		//mediumButton.addActionListener(listener);
		//hardButton.addActionListener(listener);
		backButton.addActionListener(listener);
	}
}