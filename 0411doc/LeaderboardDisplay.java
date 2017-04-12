
import leaderboards.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JLabel;
import java.awt.Component;
import java.util.ArrayList;

public class LeaderboardDisplay implements ActionListener {
    
    //Initialize frame and frame components
	private JFrame frame;
	private JPanel pane, upperPane, lowerPane, middlePane;
	private JButton backButton, resetButton;
	private JLabel title, scoreText, nameText, scoreTitle;
	private int mode;
    
    public void setMode(int newMode) {
		mode = newMode;
	}
	public int getMode() {
		return mode;
	}
	
    //Constructor, takes argument for which mode is being displayed
	public LeaderboardDisplay(int newMode) {
        
        //sets mode to mode to be displayed
        setMode(newMode);
        
		//Label properties
        //Label for main title
		title = new JLabel("LEADERBOARDS", JLabel.CENTER);
		title.setPreferredSize(new Dimension(650,100));
		title.setFont(new Font("ARIAL", Font.BOLD, 60));
		title.setForeground(Color.ORANGE);
        
        //Label for name and score
        scoreTitle = new JLabel("Name:                                    Score:", JLabel.CENTER);
        scoreTitle.setPreferredSize(new Dimension(650,50));
        scoreTitle.setFont(new Font("ARIAL", Font.BOLD, 30));
        scoreTitle.setForeground(Color.ORANGE);
		
		//Button Prooperties
        //Properties for button which goes back to leaderboardMenu
		backButton = new JButton("Back");
		backButton.setPreferredSize(new Dimension(325,90));
		backButton.setFont(new Font("ARIAL", Font.BOLD, 40));
		backButton.setForeground(Color.WHITE);
		backButton.setBackground(Color.BLACK);
		backButton.setBorderPainted(false);
		backButton.setFocusPainted(false);
		backButton.setActionCommand("back");
        backButton.addActionListener(this);
        
        //Properties for button which resets the leaderboard to the default value
        resetButton = new JButton("Reset");
		resetButton.setPreferredSize(new Dimension(325,90));
		resetButton.setFont(new Font("ARIAL", Font.BOLD, 40));
		resetButton.setForeground(Color.WHITE);
		resetButton.setBackground(Color.BLACK);
		resetButton.setBorderPainted(false);
		resetButton.setFocusPainted(false);
		resetButton.setActionCommand("reset");
		resetButton.addActionListener(this);
        resetButton.setToolTipText("This PERMANENTLY resets the leaderboards");
        
		//Panel properties
        //Button panel
		lowerPane = new JPanel(new FlowLayout());
		lowerPane.setPreferredSize(new Dimension(800,100));
		lowerPane.setBackground(Color.BLACK);
        
        //Add buttons to panel
		lowerPane.add(backButton);
        lowerPane.add(resetButton);
		
        //Score display panel
        HighScores hs = new HighScores(getMode());
        String text = "";
        ArrayList<String> scores = hs.readFile();
        middlePane = new JPanel(new GridLayout(scores.size()/2,2));
        middlePane.setBackground(Color.BLACK);
        
        //Cycle through list and add each score to panel
        for (int i = 0; i < scores.size()/2; i++) {
            nameText = new JLabel(scores.get(i), JLabel.CENTER);
            scoreText = new JLabel(scores.get(i+(scores.size()/2)), JLabel.CENTER);
            nameText.setFont(new Font("ARIAL", Font.BOLD, 15));
            nameText.setForeground(Color.ORANGE);
            scoreText.setFont(new Font("ARIAL", Font.BOLD, 15));
            scoreText.setForeground(Color.ORANGE);
            
            //Add name and score
            middlePane.add(nameText);
            middlePane.add(scoreText);
        }
        
        //Title panel
		upperPane = new JPanel(new FlowLayout());
		upperPane.setPreferredSize(new Dimension(800,150));
		upperPane.setBackground(Color.BLACK);
		upperPane.add(title);
        upperPane.add(scoreTitle);
        
		//Combine panels into BorderLayout
		pane = new JPanel(new BorderLayout());
		pane.setBackground(Color.BLACK);
		pane.add(lowerPane, BorderLayout.PAGE_END);
        pane.add(middlePane, BorderLayout.CENTER);
        pane.add(upperPane, BorderLayout.PAGE_START);
		
		//Frame properties
		frame = new JFrame("LEADERBOARDS");
		frame.setSize(800,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
        frame.setResizable(false);
        
        //Add all components to frame
		frame.add(pane);
		
		//Add action commands and action listeners
		backButton.setActionCommand("Back");
		backButton.addActionListener(this);
	}
	
    //Action performed method (actions based on button pressed)
	public void actionPerformed(ActionEvent e) {
        
        //execution when back button is pressed
		if(e.getActionCommand().equals("Back")) {
            Driver getMenu = new Driver();
            getMenu.LeaderboardMenu();
            frame.setVisible(false);
		}
        
        //execution when reset button is pressed
		else if(e.getActionCommand().equals("reset")) {
            HighScores hs = new HighScores(getMode());
            hs.resetFiles(getMode());
            LeaderboardDisplay ld = new LeaderboardDisplay(getMode());
			frame.dispose();
		}
	}
}