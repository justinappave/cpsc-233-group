package tileGame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FreePlay {
	public void playFree(){
		JFrame freeFrame = new JFrame("FreePlay");
		freeFrame.setSize(500,500);
		freeFrame.setVisible(true);
		
		JLabel label = new JLabel("Starting FreePlay...");
		JPanel panel = new JPanel();
		freeFrame.add(panel);
		panel.add(label);
		
		JButton backButton = new JButton("Back");
		
		panel.add(backButton);
		
		ActionListener listener = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == backButton){
					MainMenu menu = new MainMenu();
					menu.mainMenu();
					freeFrame.setVisible(false);;
				}
			}
		};
		backButton.addActionListener(listener);
	}

}