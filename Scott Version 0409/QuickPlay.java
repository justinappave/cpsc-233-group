//package tilePuzzle;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuickPlay extends Gameplay {
	JFrame frame;
	JPanel gridPane, topPane;
	
	public QuickPlay(int size) {
        super(size);
        
        //Panel properties
        gridPane = makeGrid(size, true);
        topPane = infoBar();
        
        //Frame properties
        frame = new JFrame("QUICKPLAY");
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(gridPane);
        frame.add(topPane, BorderLayout.NORTH);
	}
}