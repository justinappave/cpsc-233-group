package tileGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.color.*;

public class Menu extends JFrame{
	private JButton quickButton;
	private JButton menuButton;
	private JButton quitButton;
	
	public void Menu(){
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
	}
}