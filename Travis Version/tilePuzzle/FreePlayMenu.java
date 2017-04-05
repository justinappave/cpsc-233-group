package tilePuzzle;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FreePlayMenu implements ActionListener {
	private JFrame frame;
	private JPanel pane, upperPane, lowerPane;
	private JButton smallButton, mediumButton, largeButton, backButton;
	private JLabel title;
	
	FreePlayMenu() {
		//Label properties
		title = new JLabel("FreePlay");
		title.setFont(new Font("ARIAL", Font.BOLD, 50));
		title.setForeground(Color.GREEN);
		
		//Button properties
		smallButton = new JButton("3 x 3 Grid");
		smallButton.setPreferredSize(new Dimension(400,90));
		smallButton.setFont(new Font("ARIAL", Font.BOLD, 40));
		smallButton.setForeground(Color.WHITE);
		smallButton.setBackground(Color.BLACK);
		smallButton.setBorderPainted(false);
		smallButton.setFocusPainted(false);
		
		mediumButton = new JButton("4 x 4 Grid");
		mediumButton.setPreferredSize(new Dimension(400,90));
		mediumButton.setFont(new Font("ARIAL", Font.BOLD, 40));
		mediumButton.setForeground(Color.WHITE);
		mediumButton.setBackground(Color.BLACK);
		mediumButton.setBorderPainted(false);
		mediumButton.setFocusPainted(false);
		
		largeButton = new JButton("5 x 5 Grid");
		largeButton.setPreferredSize(new Dimension(400,90));
		largeButton.setFont(new Font("ARIAL", Font.BOLD, 40));
		largeButton.setForeground(Color.WHITE);
		largeButton.setBackground(Color.BLACK);
		largeButton.setBorderPainted(false);
		largeButton.setFocusPainted(false);
		
		backButton = new JButton("Back");
		backButton.setPreferredSize(new Dimension(400,90));
		backButton.setFont(new Font("ARIAL", Font.BOLD, 40));
		backButton.setForeground(Color.WHITE);
		backButton.setBackground(Color.BLACK);
		backButton.setBorderPainted(false);
		backButton.setFocusPainted(false);
		
		//Panel properties
		lowerPane = new JPanel(new FlowLayout());
		lowerPane.setPreferredSize(new Dimension(800,500));
		lowerPane.setBackground(Color.BLACK);
		lowerPane.add(smallButton);lowerPane.add(mediumButton);lowerPane.add(largeButton);lowerPane.add(backButton);
		
		upperPane = new JPanel(new FlowLayout());
		upperPane.setPreferredSize(new Dimension(800,300));
		upperPane.setBackground(Color.BLACK);
		upperPane.add(title);
		
		pane = new JPanel(new BorderLayout());
		pane.setBackground(Color.BLACK);
		pane.add(lowerPane, BorderLayout.PAGE_END);pane.add(upperPane, BorderLayout.PAGE_START);
		
		//Frame properties
		frame = new JFrame("TILE PUZZLE GAME");
		frame.setSize(800,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(pane);
		
		//Add action commands and action listeners
		smallButton.setActionCommand("3 x 3 Grid");
		mediumButton.setActionCommand("4 x 4 Grid");
		largeButton.setActionCommand("5 x 5 Grid");
		backButton.setActionCommand("Back");
		smallButton.addActionListener(this);
		mediumButton.addActionListener(this);
		largeButton.addActionListener(this);
		backButton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("3 x 3 Grid")) {
			Driver getMode = new Driver();
			getMode.SmallPlay();
			frame.setVisible(false);
		}
		else if(e.getActionCommand().equals("4 x 4 Grid")) {
			Driver getMode = new Driver();
			getMode.MediumPlay();
			frame.setVisible(false);
		}
		else if(e.getActionCommand().equals("5 x 5 Grid")) {
			Driver getMode = new Driver();
			getMode.LargePlay();
			frame.setVisible(false);
		}
		else if(e.getActionCommand().equals("Back")) {
			Driver getMode = new Driver();
			getMode.MainMenu();
			frame.setVisible(false);
		}
	}
}