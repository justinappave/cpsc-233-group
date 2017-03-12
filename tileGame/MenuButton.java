package swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * after each button click, the previous, frame should close
 */

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
	exitButton.addActionListener(new exitAction());
}
	static class quickAction implements ActionListener{
		public void actionPerformed (ActionEvent e){
			JFrame quickFrame = new JFrame("Quickplay");
			quickFrame.setVisible(true);
			quickFrame.setSize(500,500);
			JLabel label = new JLabel("Starting Quickplay...");
			JPanel panel = new JPanel();
			quickFrame.add(panel);
			panel.add(label);
		}
	}
	static class menuAction implements ActionListener{
		public void actionPerformed (ActionEvent e){
			JFrame menuFrame = new JFrame("Main Menu");
			menuFrame.setVisible(true);
			menuFrame.setSize(500,500);
			JPanel panel = new JPanel();
			menuFrame.add(panel);
			
			JButton freeButton = new JButton("Freeplay");
			JButton timeButton = new JButton("Timeplay");
			JButton leaderButton = new JButton("Leaderboards");
			JButton exitButton = new JButton("Exit");
			
			panel.add(freeButton);
			panel.add(timeButton);
			panel.add(leaderButton);
			panel.add(exitButton);
			
			freeButton.addActionListener(new freeAction());
			timeButton.addActionListener(new timeAction());
			leaderButton.addActionListener(new leaderAction());
			exitButton.addActionListener(new exitAction());
		}
	}
	static class freeAction implements ActionListener{
		public void actionPerformed (ActionEvent e){
			JFrame freeFrame = new JFrame("Freeplay");
			freeFrame.setVisible(true);
			freeFrame.setSize(500,500);
			JLabel label = new JLabel("Starting Freeplay...");
			JPanel panel = new JPanel();
			freeFrame.add(panel);
			panel.add(label);
		}
	}
	static class timeAction implements ActionListener{
		public void actionPerformed (ActionEvent e){
			JFrame timeFrame = new JFrame("Timeplay");
			timeFrame.setVisible(true);
			timeFrame.setSize(500,500);
			JLabel label = new JLabel("Starting Timeplay...");
			JPanel panel = new JPanel();
			timeFrame.add(panel);
			panel.add(label);
		}
	}
	static class leaderAction implements ActionListener{
		public void actionPerformed (ActionEvent e){
			JFrame leaderFrame = new JFrame("Leaderboards");
			leaderFrame.setVisible(true);
			leaderFrame.setSize(500,500);
			JLabel label = new JLabel("Showing leaderboards...");
			JPanel panel = new JPanel();
			leaderFrame.add(panel);
			panel.add(label);
		}
	}
	static class exitAction implements ActionListener{
		public void actionPerformed (ActionEvent e){
			//still needs exit action
		}
	}
}
