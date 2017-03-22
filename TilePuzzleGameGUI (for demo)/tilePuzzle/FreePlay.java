package tilePuzzle;

import java.awt.*;
import javax.swing.*;

public class FreePlay extends JFrame{
	
	//3x3 size puzzle
	public void SmallPuzzle(){
		setTitle("FreePlay");
		setDefaultCloseOperation(3);
		setContentPane(new SmallPuzzleGUI());
		pack();
		setVisible(true);
		setResizable(false);
	}
	//4x4 size puzzle
	public void MediumPuzzle(){
		setTitle("FreePlay");
		setDefaultCloseOperation(3);
		setContentPane(new MediumPuzzleGUI());
		pack();
		setVisible(true);
		setResizable(false);
	}
	//5x5 size puzzle
	public void LargePuzzle(){
		setTitle("FreePlay");
		setDefaultCloseOperation(3);
		setContentPane(new LargePuzzleGUI());
		pack();
		setVisible(true);
		setResizable(false);
	}
}