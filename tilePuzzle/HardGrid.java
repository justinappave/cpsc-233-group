package tilePuzzle;

import java.awt.*;
import javax.swing.*;

public class HardGrid extends JFrame{
	public void HardGrid(){
        JFrame window = new JFrame("Slide Puzzle");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new HardPuzzle());
        window.pack();  // finalize layout
        window.show();  // make window visible
        window.setResizable(false);
    }//end main
}//endclass SlidePuzzle