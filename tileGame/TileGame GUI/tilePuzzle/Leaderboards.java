package tilePuzzle;

import java.awt.*;
import javax.swing.*;

public class Leaderboards extends JFrame{
	public void Leaderboards(){
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		getContentPane().add(panel);
		
		//Frame Properties
		setDefaultCloseOperation(3);
		setSize(500,500);
		setVisible(true);
		setTitle("Leaderboards");
		panel.setBackground(Color.BLACK);
	}
}