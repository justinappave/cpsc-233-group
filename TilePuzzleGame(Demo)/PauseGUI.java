package testing;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PauseGUI extends JFrame{
	private JButton replayButton;
	private JButton pauseButton;
	private JButton quitButton;
	private JButton resumeButton;
	
	public void PauseGUI(){
		JPanel panel = new JPanel();
		resumeButton = new JButton("Resume");
		replayButton = new JButton("Quit");
		pauseButton = new JButton("PAUSED");
		quitButton = new JButton("Quit");
		panel.setLayout(new BorderLayout());
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.BLACK);
		panel3.setPreferredSize(new Dimension(500,300));
		panel3.setLayout(null);
		panel.add(panel3, BorderLayout.PAGE_START);
		
		/*JLabel pauseLabel = new JLabel("PAUSE");
		pauseLabel.setFont(new Font("Serif", Font.BOLD, 20));
		panel3.add(pauseLabel);
		pauseLabel.setForeground(Color.RED);
		//panel3.add()*/
		pauseButton.setFont(new Font("Arial", Font.BOLD, 100));
		pauseButton.setBackground(Color.BLACK);
		pauseButton.setOpaque(true);
		pauseButton.setBorderPainted(false);
		pauseButton.setForeground(Color.RED);
		
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.BLACK);
		panel2.setPreferredSize(new Dimension(500,200));
		panel2.setLayout(null);
		panel.add(panel2, BorderLayout.PAGE_END);
		
		//button.setBounds(x,y,width,height);
		resumeButton.setBounds(70,70,150,60);
		quitButton.setBounds(255,70,150,60);
		pauseButton.setBounds(0,0,500,300);
		//menuButton.setBounds(170,170,150,50);
		//quitButton.setBounds(170,230,150,50);
		panel2.add(resumeButton);
		panel2.add(replayButton);
		panel3.add(pauseButton);
		panel2.add(quitButton);
			
		getContentPane().add(panel);
		
		//Frame Properties
		setDefaultCloseOperation(3);
		setSize(500,500);
		setVisible(true);
		setTitle("Pause");
		//panel.setBackground(Color.BLACK);

		ActionListener listener = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == replayButton){
				//setVisible(false);
				//QuickPlay quick = new QuickPlay();
				//Gameplay game1 = new Gameplay();
				//game1.quickplay();
				//Menu start = new Menu();
				//dispose();
				//start.Menu();
				//quick.QuickPlay();
			}
			else if(e.getSource() == pauseButton){
				//setVisible(false);
				//MainMenu main = new MainMenu();
				//main.MainMenu();
			}
			else if(e.getSource() == quitButton){
				//dispose();
			}
		}
	};
	resumeButton.addActionListener(listener);
	replayButton.addActionListener(listener);
	pauseButton.addActionListener(listener);
	quitButton.addActionListener(listener);
	}
}