package tilePuzzle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Menu extends JFrame{
	private JButton quickButton;
	private JButton menuButton;
	private JButton quitButton;
	private JButton titleButton;
	
	public void Menu(){
		//Button properties
		quickButton = new JButton("QuickPlay");
		menuButton = new JButton("Main Menu");
		quitButton = new JButton("Quit");
		titleButton = new JButton("TILE PUZZLE");
		quickButton.setBounds(165,60,150,60);
		menuButton.setBounds(165,130,150,60);
		quitButton.setBounds(165,200,150,60);
		titleButton.setBounds(0,0,500,200);
		
		titleButton.setFont(new Font("Arial", Font.BOLD, 60));
		titleButton.setOpaque(true);
		titleButton.setBorderPainted(false);
		titleButton.setBackground(Color.BLACK);
		titleButton.setForeground(Color.RED);
		
		
		//Panel properties
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBackground(Color.BLACK);
		getContentPane().add(panel);
		
		JPanel upperPanel = new JPanel();
		upperPanel.setLayout(null);
		upperPanel.setBackground(Color.BLACK);
		upperPanel.setPreferredSize(new Dimension(500,200));
		panel.add(upperPanel, BorderLayout.PAGE_START);
		upperPanel.add(titleButton);
		
		JPanel lowerPanel = new JPanel();
		lowerPanel.setLayout(null);
		lowerPanel.setBackground(Color.BLACK);
		lowerPanel.setPreferredSize(new Dimension(500,300));
		panel.add(lowerPanel, BorderLayout.PAGE_END);
		lowerPanel.add(quickButton);
		lowerPanel.add(menuButton);
		lowerPanel.add(quitButton);
		
		//Frame properties
		setDefaultCloseOperation(3);
		setSize(500,500);
		setTitle("Tile Puzzle");
		setVisible(true);
		
		//Action listeners
		ActionListener listener = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == quickButton){
					dispose();
					QuickPlay quick = new QuickPlay();
					quick.QuickPlay();
				}
				else if(e.getSource() == menuButton){
					dispose();
					MainMenu menu = new MainMenu();
					menu.MainMenu();
				}
				else if(e.getSource() == quitButton){
					dispose();
				}
			}
		};
		quickButton.addActionListener(listener);
		menuButton.addActionListener(listener);
		quitButton.addActionListener(listener);
	}
}