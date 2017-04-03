//This method is for the first menu that appears. You can select quickplay, which starts a new game
//immediately or continue to the main menu.

package gui;

import gridgameplay.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGUI extends JFrame{
    //Initializes all of the Jbuttons
	private JButton quickButton;
	private JButton menuButton;
	private JButton quitButton;
	
	public MenuGUI(){
        //Creates a new JPanel and creates all the buttons
		JPanel panel = new JPanel();
		quickButton = new JButton("QuickPlay");
		menuButton = new JButton("Main Menu");
		quitButton = new JButton("Quit");
		panel.setLayout(null);//set to something other than null (layout manager)
			
		//Setting the location and size for the buttons (x,y,width,height)
		quickButton.setBounds(170,50,150,50);
		menuButton.setBounds(170,110,150,50);
		quitButton.setBounds(170,170,150,50);
        
        //Add the buttons to the panel
		panel.add(quickButton);
		panel.add(menuButton);
		panel.add(quitButton);
			
		getContentPane().add(panel);
			
		//Frame Properties
		setDefaultCloseOperation(3);
		setSize(500,500);
		setVisible(true);
		setTitle("Tile Game");
		panel.setBackground(Color.BLACK);
        
        quickButton.setActionCommand("quickplay");
        menuButton.setActionCommand("mainmenu");
        quitButton.setActionCommand("quit");
        
        //adding action listeners for each button
        MenuListener listener = new MenuListener();
        quickButton.addActionListener(listener);
        menuButton.addActionListener(listener);
        quitButton.addActionListener(listener);
	}
}