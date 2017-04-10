package tilePuzzle;

import java.awt.*;
import javax.swing.*;

public class PicturePlay extends Gameplay {
	JFrame frame;
	JPanel gridPane, topPane;
	
	public PicturePlay(int size) {
        super(size);
        
        //Panel properties
        gridPane = makeGrid(size, true);
        topPane = infoBar();
        
        //Frame properties
        frame = new JFrame("PICTUREPLAY");
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(gridPane);
        frame.add(topPane, BorderLayout.NORTH);
	}
}