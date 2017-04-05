package tilePuzzle;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class StartMenu implements ActionListener {
	private JFrame frame;
	private JPanel pane, upperPane, lowerPane;
	private JButton quickButton, menuButton, quitButton;
	private JLabel title;
	
	StartMenu() {
		//Label properties
		title = new JLabel("TILE PUZZLE");
		title.setPreferredSize(new Dimension(650,450));
		title.setFont(new Font("ARIAL", Font.BOLD, 90));
		title.setForeground(Color.ORANGE);
		
		//Button properties
		quickButton = new JButton("QuickPlay");
		quickButton.setPreferredSize(new Dimension(400,90));
		quickButton.setFont(new Font("ARIAL", Font.BOLD, 40));
		quickButton.setForeground(Color.WHITE);
		quickButton.setBackground(Color.BLACK);
		quickButton.setBorderPainted(false);
		quickButton.setFocusPainted(false);
		quickButton.setActionCommand("QuickPlay");
		
		menuButton = new JButton("Main Menu");
		menuButton.setPreferredSize(new Dimension(400,90));
		menuButton.setFont(new Font("ARIAL", Font.BOLD, 40));
		menuButton.setForeground(Color.WHITE);
		menuButton.setBackground(Color.BLACK);
		menuButton.setBorderPainted(false);
		menuButton.setFocusPainted(false);
		menuButton.setActionCommand("Main Menu");
		
		quitButton = new JButton("Quit");
		quitButton.setPreferredSize(new Dimension(400,90));
		quitButton.setFont(new Font("ARIAL", Font.BOLD, 40));
		quitButton.setForeground(Color.WHITE);
		quitButton.setBackground(Color.BLACK);
		quitButton.setBorderPainted(false);
		quitButton.setFocusPainted(false);
		quitButton.setActionCommand("Quit");
		
		//Panel properties
		lowerPane = new JPanel(new FlowLayout());
		lowerPane.setPreferredSize(new Dimension(800,350));
		lowerPane.setBackground(Color.BLACK);
		lowerPane.add(quickButton);lowerPane.add(menuButton);lowerPane.add(quitButton);
		
		upperPane = new JPanel(new FlowLayout());
		upperPane.setPreferredSize(new Dimension(800,450));
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
		quickButton.setActionCommand("QuickPlay");
		menuButton.setActionCommand("Main Menu");
		quitButton.setActionCommand("Quit");
		quickButton.addActionListener(this);
		menuButton.addActionListener(this);
		quitButton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("QuickPlay")) {
			Driver getMode = new Driver();
			getMode.QuickPlay();
			frame.setVisible(false);
		}
		else if(e.getActionCommand().equals("Main Menu")) {
			Driver getMode = new Driver();
			getMode.MainMenu();
			frame.setVisible(false);
		}
		else if(e.getActionCommand().equals("Quit")) {
			frame.dispose();
		}
	}
}