// SlidePuzzle.java - Puzzle to slide pieces to correct position.
// Fred Swartz, 2003-May, 2004-May
//   The SlidePuzzle program consists of three files:
//   SlidePuzzle.java      - this file with main to create window.
//   SlidePuzzleGUI.java   - implements the GUI interface.
//   SlidePuzzleModel.java - the logical functioning.

import javax.swing.JFrame;

///////////////////////////////////////////// class SlidePuzzle
class SlidePuzzle {
    //============================================= method main
    public static void main(String[] args) {
        JFrame window = new JFrame("Slide Puzzle");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new SlidePuzzleGUI());
        window.pack();  // finalize layout
        window.show();  // make window visible
        window.setResizable(false);
    }//end main
}//endclass SlidePuzzle