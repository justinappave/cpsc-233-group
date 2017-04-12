import java.awt.*;
import javax.swing.*;

/**
FreePlay class creates frame and
gets grid from parent class Gameplay
*/
public class FreePlay extends Gameplay {

	//Initialize frame components;
	JPanel gridPane, topPane;

	//FreePlay constructor
	public FreePlay(int size) {

		//Calls Gameplay(grid size, gamemode)
		super(size, 1);

		//Panel properties
		gridPane = makeGrid(size);
		topPane = infoBar();
		topPane.add(movesButton);

		//Frame properties
		frame = new JFrame("FREEPLAY");
		frame.setSize(800,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.add(gridPane);
		frame.add(topPane, BorderLayout.NORTH);
	}
}
