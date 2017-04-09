//package tilePuzzle;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainMenu implements ActionListener {
	private JFrame frame;
	private JPanel pane, upperPane, lowerPane;
	private JButton freeButton, timeButton, leaderButton, backButton;
	private JLabel title;
	
	MainMenu() {
		//Label properties
		title = new JLabel("Main Menu");
		title.setFont(new Font("ARIAL", Font.BOLD, 50));
		title.setForeground(Color.GREEN);
		
		//Button properties
		freeButton = new JButton("FreePlay");
		freeButton.setPreferredSize(new Dimension(400,90));
		freeButton.setFont(new Font("ARIAL", Font.BOLD, 40));
		freeButton.setForeground(Color.WHITE);
		freeButton.setBackground(Color.BLACK);
		freeButton.setBorderPainted(false);
		freeButton.setFocusPainted(false);
		freeButton.setToolTipText("PLAY DIFFERENT SIZE GRIDS");
		
		timeButton = new JButton("TimePlay");
		timeButton.setPreferredSize(new Dimension(400,90));
		timeButton.setFont(new Font("ARIAL", Font.BOLD, 40));
		timeButton.setForeground(Color.WHITE);
		timeButton.setBackground(Color.BLACK);
		timeButton.setBorderPainted(false);
		timeButton.setFocusPainted(false);
		timeButton.setToolTipText("RACE AGAINST THE TIMER");
		
		leaderButton = new JButton("Leaderboards");
		leaderButton.setPreferredSize(new Dimension(400,90));
		leaderButton.setFont(new Font("ARIAL", Font.BOLD, 40));
		leaderButton.setForeground(Color.WHITE);
		leaderButton.setBackground(Color.BLACK);
		leaderButton.setBorderPainted(false);
		leaderButton.setFocusPainted(false);
		
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
		lowerPane.add(freeButton);lowerPane.add(timeButton);lowerPane.add(leaderButton);lowerPane.add(backButton);
		
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
		freeButton.setActionCommand("FreePlay");
		timeButton.setActionCommand("TimePlay");
		leaderButton.setActionCommand("Leaderboards");
		backButton.setActionCommand("Back");
		freeButton.addActionListener(this);
		timeButton.addActionListener(this);
		leaderButton.addActionListener(this);
		backButton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("FreePlay")) {
			Driver getMode = new Driver();
			getMode.FreePlayMenu();
			frame.setVisible(false);
		}
		else if(e.getActionCommand().equals("TimePlay")) {
			Driver getMode = new Driver();
			getMode.TimePlayMenu();
			frame.setVisible(false);
		}
		else if(e.getActionCommand().equals("Back")) {
			Driver getMode = new Driver();
			getMode.StartMenu();
			frame.setVisible(false);
		}
	}
}