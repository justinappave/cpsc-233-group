

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MainMenu extends JFrame implements ActionListener {
	private JPanel upperPane, lowerPane;
	private JButton pictureButton, freeButton, timeButton, leaderButton, quitButton;
	private JLabel background, gameTitle;
	private ImageIcon image;
    private JFrame game;
	//window.setVisable(true)
	public MainMenu() {
        setTitle("TILE PUZZLE");
		setSize(800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
		gameTitle = new JLabel("TILE PUZZLE");
		gameTitle.setPreferredSize(new Dimension(650,450));
		gameTitle.setFont(new Font("Arial", Font.BOLD, 95));
		gameTitle.setForeground(Color.ORANGE);
		
		//buttons
		pictureButton = new JButton("PicturePlay");
		pictureButton.setPreferredSize(new Dimension(200,50));
		pictureButton.setFont(new Font("Arial", Font.BOLD, 25));
		pictureButton.setForeground(Color.ORANGE);
		
		freeButton = new JButton("FreePlay");
		freeButton.setPreferredSize(new Dimension(200,50));
		freeButton.setFont(new Font("Arial", Font.BOLD, 25));
		freeButton.setForeground(Color.ORANGE);
		
		timeButton = new JButton("TimePlay");
		timeButton.setPreferredSize(new Dimension(200,50));
		timeButton.setFont(new Font("Arial", Font.BOLD, 25));
		timeButton.setForeground(Color.ORANGE);
		
		leaderButton = new JButton("Leaderboards");
		leaderButton.setPreferredSize(new Dimension(200,50));
		leaderButton.setFont(new Font("Arial", Font.BOLD, 25));
		leaderButton.setForeground(Color.ORANGE);
		
		quitButton = new JButton("Quit");
		quitButton.setPreferredSize(new Dimension(200,50));
		quitButton.setFont(new Font("Arial", Font.BOLD, 25));
		quitButton.setForeground(Color.ORANGE);
		
		//panels
		upperPane = new JPanel(new FlowLayout());
		upperPane.setPreferredSize(new Dimension(800,500));
		upperPane.setOpaque(false);
		upperPane.add(gameTitle);
		
		lowerPane = new JPanel(new FlowLayout());
		lowerPane.setPreferredSize(new Dimension(800,300));
		lowerPane.setOpaque(false);
		lowerPane.add(pictureButton);
        lowerPane.add(freeButton);
        lowerPane.add(timeButton);
        lowerPane.add(leaderButton);
        lowerPane.add(quitButton);
		
		//labels
		image = new ImageIcon("resources/MenuBackground.jpg");
		background = new JLabel(image);
		background.setLayout(new BorderLayout());
		background.add(upperPane, BorderLayout.PAGE_START);
		background.add(lowerPane, BorderLayout.PAGE_END);
		
        add(background);
        pack();
		
		pictureButton.addActionListener(this);
		freeButton.addActionListener(this);
		timeButton.addActionListener(this);
		leaderButton.addActionListener(this);
		quitButton.addActionListener(this);
		
		pictureButton.setActionCommand("PicturePlay");
		freeButton.setActionCommand("FreePlay");
		timeButton.setActionCommand("TimePlay");
		leaderButton.setActionCommand("Leaderboards");
		quitButton.setActionCommand("Quit");
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("PicturePlay")) {
			Driver getMode = new Driver();
			getMode.PicturePlay();
		}
		else if(e.getActionCommand().equals("FreePlay")) {
			Driver getMode = new Driver();
			getMode.FreePlay();
		}
		else if(e.getActionCommand().equals("TimePlay")) {
			Driver getMode = new Driver();
			getMode.TimePlay();
		}
		else if(e.getActionCommand().equals("Leaderboards")) {
			Driver getMenu = new Driver();
			getMenu.LeaderboardMenu();
		}
		else if(e.getActionCommand().equals("Quit")) {
			dispose();
		}
	}
}