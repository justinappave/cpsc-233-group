package tilePuzzle;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuickPlay extends Gameplay {
	JFrame frame;
	JPanel gridPane;
	
	public QuickPlay(int size) {
        super(size);
        
        //Panel properties
        gridPane = makeGrid(size);
        
        //Frame properties
        frame = new JFrame("QUICKPLAY");
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(gridPane);
	}
}