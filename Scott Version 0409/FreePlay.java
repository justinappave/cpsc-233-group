//package tilePuzzle;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FreePlay extends Gameplay {
	JFrame frame;
	JPanel gridPane, topPane;
	JButton movesButton, pauseButton;
	
	public FreePlay(int size) {
        super(size);
        
        //Button properties
        movesButton = new JButton("Moves: #" + getMoves());
        
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