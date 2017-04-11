
import java.awt.*;
import javax.swing.*;

public class PicturePlay extends Gameplay {
	JPanel gridPane, topPane;
	
	public PicturePlay(int size) {
        super(size, 0);
        
        //Panel properties
        gridPane = makeGrid(size);
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