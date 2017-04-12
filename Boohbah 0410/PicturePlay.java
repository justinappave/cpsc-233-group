import java.awt.*;
import javax.swing.*;

public class PicturePlay extends Gameplay {

	//Initialize frame components
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
		frame.setResizable(false);
    frame.setVisible(true);
    frame.add(gridPane);
    frame.add(topPane, BorderLayout.NORTH);
	}
}
