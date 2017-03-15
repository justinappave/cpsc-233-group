package tileGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuTest extends JFrame{
	private JButton freeButton;
	private JButton timeButton;
	
	public MainMenuTest(){
		JPanel panel = new JPanel();
		freeButton = new JButton("FreePlay");
		timeButton = new JButton("TimePlay");
		panel.setLayout(null);
		
		//button.setBounds(x,y,width,height);
		freeButton.setBounds(115,50,200,50);
		timeButton.setBounds(100,100,100,100);
		panel.add(freeButton);
		panel.add(timeButton);
		
		getContentPane().add(panel);
		
		//Frame Properties
		setDefaultCloseOperation(3);
		setSize(500,500);
		setVisible(true);
		
		ActionListener listener = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == freeButton){
					FreePlay free = new FreePlay();
					free.playFree();
					setVisible(false);
				}
			}
		};
		freeButton.addActionListener(listener);
	}
	public static void main(String[] args){
		new MainMenuTest();
	}
}
