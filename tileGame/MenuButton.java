package swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuButton {
public static void main(String[] args){
	
	JFrame frame = new JFrame("Tile Game");
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(500,500);
	JPanel panel = new JPanel();
	frame.add(panel);
	
	JButton quickButton = new JButton("Quickplay");
	JButton menuButton = new JButton("Menu");
	JButton exitButton = new JButton("Exit");
	
	panel.add(quickButton);
	panel.add(menuButton);
	panel.add(exitButton);
	
	quickButton.addActionListener(new quickAction());
	menuButton.addActionListener(new menuAction());
}
	static class quickAction implements ActionListener{
		public void actionPerformed (ActionEvent e){
			JFrame frame1 = new JFrame("Quickplay");
			frame1.setVisible(true);
			frame1.setSize(500,500);
			JLabel label = new JLabel("Starting Quickplay...");
			JPanel panel = new JPanel();
			frame1.add(panel);
			panel.add(label);
		}
	}
	static class menuAction implements ActionListener{
		public void actionPerformed (ActionEvent e){
			JFrame frame2 = new JFrame("Main Menu");
			frame2.setVisible(true);
			frame2.setSize(500,500);
			JLabel label = new JLabel("Moving to Main Menu...");
			JPanel panel = new JPanel();
			frame2.add(panel);
			panel.add(label);
		}
	}
}
