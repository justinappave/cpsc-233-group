import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*
This class is the main menu, it is the first screen the player sees when they start up the game. From here the user 
can go to the leaderboard menu or play one of the three gametypes.
*/

public class MainMenu extends JFrame implements ActionListener {

	//Initialize frame components
	private JPanel upperPane, lowerPane;
	private JLabel background, gameTitle;
	private JButton pictureButton, freeButton, timeButton, leaderButton, quitButton;
	private ImageIcon image;

	//Main menu constructor
	public MainMenu() {

		//Frame properties
		setTitle("TILE PUZZLE");
		setSize(800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		//Label properties (game title)
		gameTitle = new JLabel("TILE PUZZLE");
		gameTitle.setPreferredSize(new Dimension(650,450));
		gameTitle.setFont(new Font("Arial", Font.BOLD, 90));
		gameTitle.setForeground(Color.ORANGE);

		//Button properties
        //Properties for button which starts picture gametype
		pictureButton = new JButton("PicturePlay");
		pictureButton.setPreferredSize(new Dimension(200,50));
		pictureButton.setFont(new Font("Arial", Font.BOLD, 20));
		pictureButton.setForeground(Color.ORANGE);

        //Properties for button which starts move counting gametype
		freeButton = new JButton("FreePlay");
		freeButton.setPreferredSize(new Dimension(200,50));
		freeButton.setFont(new Font("Arial", Font.BOLD, 20));
		freeButton.setForeground(Color.ORANGE);

        //Properties for button which starts time counting gametype
		timeButton = new JButton("TimePlay");
		timeButton.setPreferredSize(new Dimension(200,50));
		timeButton.setFont(new Font("Arial", Font.BOLD, 20));
		timeButton.setForeground(Color.ORANGE);

        //Properties for button which goes to the leaderboardMenu
		leaderButton = new JButton("Leaderboards");
		leaderButton.setPreferredSize(new Dimension(200,50));
		leaderButton.setFont(new Font("Arial", Font.BOLD, 20));
		leaderButton.setForeground(Color.ORANGE);

        //Properties for button which quits the game
		quitButton = new JButton("Quit");
		quitButton.setPreferredSize(new Dimension(200,50));
		quitButton.setFont(new Font("Arial", Font.BOLD, 20));
		quitButton.setForeground(Color.ORANGE);

		//Panel properties
		//Title panel
		upperPane = new JPanel(new FlowLayout());
		upperPane.setPreferredSize(new Dimension(800,500));
		upperPane.setOpaque(false);
		upperPane.add(gameTitle);

		//Button panel
		lowerPane = new JPanel(new FlowLayout());
		lowerPane.setPreferredSize(new Dimension(800,300));
		lowerPane.setOpaque(false);
		lowerPane.add(pictureButton);
		lowerPane.add(freeButton);
		lowerPane.add(timeButton);
		lowerPane.add(leaderButton);
		lowerPane.add(quitButton);

		//Label properties (background image)
		image = new ImageIcon("resources/MenuBackground.jpg");
		background = new JLabel(image);
		background.setLayout(new BorderLayout());
        
        //Add the buttons and title on top of the background image
		background.add(upperPane, BorderLayout.PAGE_START);
		background.add(lowerPane, BorderLayout.PAGE_END);
        
        //Add everything to the frame and size it properly using pack()
		add(background);
		pack();

		//add ActionListeners for the buttons
		pictureButton.addActionListener(this);
		freeButton.addActionListener(this);
		timeButton.addActionListener(this);
		leaderButton.addActionListener(this);
		quitButton.addActionListener(this);

		//set ActionCommands for the buttons
		pictureButton.setActionCommand("PicturePlay");
		freeButton.setActionCommand("FreePlay");
		timeButton.setActionCommand("TimePlay");
		leaderButton.setActionCommand("Leaderboards");
		quitButton.setActionCommand("Quit");
	}

	//Action performed method (actions based on button pressed)
	public void actionPerformed(ActionEvent e) {
        
        //execution when pictureButton is pressed
		if(e.getActionCommand().equals("PicturePlay")) {
			Driver getMode = new Driver();
			getMode.PicturePlay();
		}
        
        //execution when freeButton is pressed
		else if(e.getActionCommand().equals("FreePlay")) {
			Driver getMode = new Driver();
			getMode.FreePlay();
		}
        
        //execution when timeButton is pressed
		else if(e.getActionCommand().equals("TimePlay")) {
			Driver getMode = new Driver();
			getMode.TimePlay();
		}
        
        //execution when leaderButton is pressed
		else if(e.getActionCommand().equals("Leaderboards")) {
			Driver getMenu = new Driver();
			getMenu.LeaderboardMenu();
		}
        
        //execution when quitButton is pressed
		else if(e.getActionCommand().equals("Quit")) {
			dispose();
		}
	}
}
