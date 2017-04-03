/** This class is the mani menu. From here you can select either freeplay or timeplay modes. Or you can check
the leaderboards. You can also return to the first menu.
*/

package gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuGUI extends JFrame{
	private JButton freeButton;
	private JButton timeButton;
	private JButton leaderButton;
	private JButton backButton;
	
	public MainMenuGUI(){
		JPanel panel = new JPanel();
		freeButton = new JButton("FreePlay");
		timeButton = new JButton("TimePlay");
		leaderButton = new JButton("Leaderboards");
		backButton = new JButton("Back");
		panel.setLayout(null);
		
		//button.setBounds(x,y,width,height);
		freeButton.setBounds(170,50,150,50);
		timeButton.setBounds(170,110,150,50);
		leaderButton.setBounds(170,170,150,50);
		backButton.setBounds(170,230,150,50);
		panel.add(freeButton);
		panel.add(timeButton);
		panel.add(leaderButton);
		panel.add(backButton);
		
		getContentPane().add(panel);
		
		//Frame Properties
		setDefaultCloseOperation(3);
		setSize(500,500);
		setVisible(true);
		setTitle("Main Menu");
		panel.setBackground(Color.BLACK);
        
        freeButton.setActionCommand("freeplay");
        timeButton.setActionCommand("timeplay");
        leaderButton.setActionCommand("leaderboards");
        backButton.setActionCommand("backtomenu");
        
        MenuListener listener = new MenuListener();
        freeButton.addActionListener(listener);
        timeButton.addActionListener(listener);
        leaderButton.addActionListener(listener);
        backButton.addActionListener(listener);
	}
}