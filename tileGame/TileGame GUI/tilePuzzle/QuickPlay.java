package tilePuzzle;

import java.awt.*;
import javax.swing.*;

public class QuickPlay extends JFrame{
	public void QuickPlay(){
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		getContentPane().add(panel);
		
		//Frame Properties
		setDefaultCloseOperation(3);
		setSize(500,500);
		setVisible(true);
		setTitle("QuickPlay");
		panel.setBackground(Color.BLACK);
	}
}