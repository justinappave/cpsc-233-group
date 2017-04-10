package tilePuzzle;

import java.awt.*;
import javax.swing.*;

public class FreePlay extends Gameplay {
	JPanel gridPane, topPane;
	
	public FreePlay(int size) {
        super(size);
        
        //Panel properties
        gridPane = makeGrid(size, false);
        topPane = infoBar();
        topPane.add(movesButton);
        
        //Frame properties
        frame = new JFrame("FREEPLAY");
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(gridPane);
        frame.add(topPane, BorderLayout.NORTH);
	}
}