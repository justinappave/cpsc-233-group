package tilePuzzle;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class QuickPlay extends JFrame {
	public void QuickPlay(){
		setTitle("QuickPlay");
		setDefaultCloseOperation(3);
		setContentPane(new QuickPuzzleGUI());
		pack();
		setVisible(true);
		setResizable(false);
	}
}
