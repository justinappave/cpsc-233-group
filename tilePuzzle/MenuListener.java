package tilePuzzle;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListener extends StartMenu implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("QuickPlay")) {
			Grid getGrid = new Grid();
			getGrid.SmallGrid();
		}
		else if(e.getActionCommand().equals("Main Menu")) {
			System.out.println("Moving to Main Menu");
		}
		else if(e.getActionCommand().equals("Quit")) {
			System.out.println("EXITS GAME");
			//frame.dispose();
		}
	}
}
