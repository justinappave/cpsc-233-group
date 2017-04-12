import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*
@Authors...
explain what class does...
parameters, returns
*/

public class LeaderboardMenu extends JFrame implements ActionListener {

	//Initialize frame components
	private JPanel upperPane, lowerPane;
	private JButton moveScoreButton, timeScoreButton, backButton;
	private JLabel background, gameTitle;
	private ImageIcon image;

	//Leaderboard menu constructor
	public LeaderboardMenu() {
		setTitle("LEADERBOARDS");
		setSize(800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		//Label properties (game title)
		gameTitle = new JLabel("LEADERBOARDS");
		gameTitle.setFont(new Font("Arial", Font.BOLD, 50));
		gameTitle.setForeground(Color.GREEN);

		//Button properties
		moveScoreButton = new JButton("Move Score");
		moveScoreButton.setPreferredSize(new Dimension(400,90));
		moveScoreButton.setFont(new Font("Arial", Font.BOLD, 40));
		moveScoreButton.setForeground(Color.WHITE);
		moveScoreButton.setContentAreaFilled(false);
		moveScoreButton.setBorderPainted(false);
		moveScoreButton.setFocusPainted(false);

		timeScoreButton = new JButton("Time Score");
		timeScoreButton.setPreferredSize(new Dimension(400,90));
		timeScoreButton.setFont(new Font("Arial", Font.BOLD, 40));
		timeScoreButton.setForeground(Color.WHITE);
		timeScoreButton.setContentAreaFilled(false);
		timeScoreButton.setBorderPainted(false);
		timeScoreButton.setFocusPainted(false);

		backButton = new JButton("Back");
		backButton.setPreferredSize(new Dimension(400,90));
		backButton.setFont(new Font("Arial", Font.BOLD, 40));
		backButton.setForeground(Color.WHITE);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		backButton.setFocusPainted(false);

		//Panel properties
		//Title panel
		upperPane = new JPanel(new FlowLayout());
		upperPane.setPreferredSize(new Dimension(800,300));
		upperPane.setOpaque(false);
		upperPane.add(gameTitle);

		//Button panel
		lowerPane = new JPanel(new FlowLayout());
		lowerPane.setPreferredSize(new Dimension(800,500));
		lowerPane.setOpaque(false);
		lowerPane.add(moveScoreButton);lowerPane.add(timeScoreButton);lowerPane.add(backButton);

		//Label properties (background image)
		image = new ImageIcon("resources/StarryBackground.jpg");
		background = new JLabel(image);
		background.setLayout(new BorderLayout());
		background.add(upperPane, BorderLayout.PAGE_START);
		background.add(lowerPane, BorderLayout.PAGE_END);
    add(background);
		pack();

		//add ActionListeners
		moveScoreButton.addActionListener(this);
		timeScoreButton.addActionListener(this);
		backButton.addActionListener(this);

		//add ActionCommands
		moveScoreButton.setActionCommand("Move Score");
		timeScoreButton.setActionCommand("Time Score");
		backButton.setActionCommand("Back");
	}

	//Action performed method (actions based on button pressed)
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Move Score")) {
			setVisible(false);
			LeaderboardDisplay getMenu = new LeaderboardDisplay(1);
		}
		else if(e.getActionCommand().equals("Time Score")) {
      setVisible(false);
			LeaderboardDisplay getMenu = new LeaderboardDisplay(0);
		}
		else if(e.getActionCommand().equals("Back")) {
			setVisible(false);
			Driver getMenu = new Driver();
			getMenu.MainMenu();
		}
	}
}
