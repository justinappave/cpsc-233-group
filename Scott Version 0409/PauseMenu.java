import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PauseMenu implements ActionListener {
    private JFrame frame;
	private JPanel pane, upperPane, lowerPane;
	private JButton resumeButton, menuButton, quitButton;
	private JLabel title;
    
    public PauseMenu() {
        //Label properties
		title = new JLabel("PAUSED");
		title.setPreferredSize(new Dimension(400,250));
		title.setFont(new Font("ARIAL", Font.BOLD, 60));
		title.setForeground(Color.RED);
		
		//Button properties
		resumeButton = new JButton("Resume");
		resumeButton.setPreferredSize(new Dimension(400,90));
		resumeButton.setFont(new Font("ARIAL", Font.BOLD, 40));
		resumeButton.setForeground(Color.WHITE);
		resumeButton.setBackground(Color.BLACK);
		resumeButton.setBorderPainted(false);
		resumeButton.setFocusPainted(false);
		resumeButton.setActionCommand("resume");
		
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
		lowerPane.setPreferredSize(new Dimension(400,350));
		lowerPane.setBackground(Color.BLACK);
		lowerPane.add(resumeButton);lowerPane.add(menuButton);lowerPane.add(quitButton);
		
		upperPane = new JPanel(new FlowLayout());
		upperPane.setPreferredSize(new Dimension(400,250));
		upperPane.setBackground(Color.BLACK);
		upperPane.add(title);
		
		pane = new JPanel(new BorderLayout());
		pane.setBackground(Color.BLACK);
		pane.add(lowerPane, BorderLayout.PAGE_END);pane.add(upperPane, BorderLayout.PAGE_START);
		
		//Frame properties
		frame = new JFrame("PAUSED");
		frame.setSize(400,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(true);
        frame.setFocusable(true);
		frame.setVisible(true);
		frame.add(pane);
		
		//Add action commands and action listeners
		resumeButton.setActionCommand("resume");
		menuButton.setActionCommand("Main Menu");
		quitButton.setActionCommand("Quit");
		resumeButton.addActionListener(this);
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