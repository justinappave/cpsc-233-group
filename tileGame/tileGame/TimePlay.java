package tileGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.color.*;

public class TimePlay extends JFrame{
	private JButton easyButton;
	private JButton mediumButton;
	private JButton hardButton;
	private JButton backButton;
	
	public void TimePlay(){
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
	}
	
}