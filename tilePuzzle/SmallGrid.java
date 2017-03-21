package tilePuzzle;

import java.awt.*;
import javax.swing.*;

public class SmallGrid extends JFrame{
	public void SmallGrid(){
        JFrame window = new JFrame("Slide Puzzle");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new SmallPuzzle());
        window.pack();  // finalize layout
        window.show();  // make window visible
        window.setResizable(false);
    }//end main
}//endclass SlidePuzzle