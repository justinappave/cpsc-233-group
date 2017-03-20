package tilePuzzle;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PauseMenu extends JFrame{
	private JButton replayButton;
	private JButton menuButton;
	private JButton quitButton;
	private JButton resumeButton;
	
	public void PauseMenu(){
		JPanel panel = new JPanel();
		resumeButton = new JButton("Resume");
		replayButton = new JButton("Replay");
		menuButton = new JButton("Main Menu");
		quitButton = new JButton("Quit");
		panel.setLayout(new BorderLayout());
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.BLUE);
		panel3.setPreferredSize(new Dimension(500,361));
		panel3.setLayout(null);
		panel.add(panel3, BorderLayout.PAGE_START);
		
		JLabel label = new JLabel();
		
		
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.BLACK);
		panel2.setPreferredSize(new Dimension(500,100));
		panel2.setLayout(null);
		panel.add(panel2, BorderLayout.PAGE_END);
		
		//button.setBounds(x,y,width,height);
		resumeButton.setBounds(50,25,150,50);
		//replayButton.setBounds(170,110,150,50);
		//menuButton.setBounds(170,170,150,50);
		//quitButton.setBounds(170,230,150,50);
		panel2.add(resumeButton);
		panel2.add(replayButton);
		panel2.add(menuButton);
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
				setVisible(false);
				//QuickPlay quick = new QuickPlay();
				Gameplay game1 = new Gameplay();
				game1.quickplay();
				Menu start = new Menu();
				dispose();
				start.Menu();
				//quick.QuickPlay();
			}
			else if(e.getSource() == menuButton){
				setVisible(false);
				MainMenu main = new MainMenu();
				main.MainMenu();
			}
			else if(e.getSource() == quitButton){
				dispose();
			}
		}
	};
	resumeButton.addActionListener(listener);
	replayButton.addActionListener(listener);
	menuButton.addActionListener(listener);
	quitButton.addActionListener(listener);
	}
}