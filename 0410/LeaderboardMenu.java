
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LeaderboardMenu extends JFrame implements ActionListener {
	private JPanel upperPane, lowerPane;
	private JButton moveScoreButton, timeScoreButton, backButton;
	private JLabel background, gameTitle;
	private ImageIcon image;
    public JFrame frame;
	
	public LeaderboardMenu() {
		setTitle("LEADERBOARDS");
		setSize(800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		gameTitle = new JLabel("LEADERBOARDS");
		gameTitle.setFont(new Font("Arial", Font.BOLD, 50));
		gameTitle.setForeground(Color.GREEN);
		
		//buttons
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
		
		//panels
		upperPane = new JPanel(new FlowLayout());
		upperPane.setPreferredSize(new Dimension(800,300));
		upperPane.setOpaque(false);
		upperPane.add(gameTitle);
		
		lowerPane = new JPanel(new FlowLayout());
		lowerPane.setPreferredSize(new Dimension(800,500));
		lowerPane.setOpaque(false);
		lowerPane.add(moveScoreButton);lowerPane.add(timeScoreButton);lowerPane.add(backButton);
		
		//labels
		image = new ImageIcon("resources/StarryBackground.jpg");
		background = new JLabel(image);
		background.setLayout(new BorderLayout());
		background.add(upperPane, BorderLayout.PAGE_START);
		background.add(lowerPane, BorderLayout.PAGE_END);
        
        add(background);
        pack();
		
		moveScoreButton.addActionListener(this);
		timeScoreButton.addActionListener(this);
		backButton.addActionListener(this);
		
		moveScoreButton.setActionCommand("Move Score");
		timeScoreButton.setActionCommand("Time Score");
		backButton.setActionCommand("Back");
	}
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