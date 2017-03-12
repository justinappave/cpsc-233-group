package swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuButton {
public static void main(String[] args){
	
	JFrame frame = new JFrame("Test");
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(300,300);
	JPanel panel = new JPanel();
	frame.add(panel);
	JButton button = new JButton("Click here");
	panel.add(button);
	button.addActionListener(new Action());
}
	static class Action implements ActionListener{
		public void actionPerformed (ActionEvent e){
			JFrame frame2 = new JFrame("Clicked");
			frame2.setVisible(true);
			frame2.setSize(200,200);
			JLabel label = new JLabel("You clicked me!");
			JPanel panel = new JPanel();
			frame2.add(panel);
			panel.add(label);
		}
	}
}
