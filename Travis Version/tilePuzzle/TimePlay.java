package tilePuzzle;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimePlay extends Gameplay {
	JFrame frame;
	JPanel gridPane, timePane;
	JButton timeButton;
	
	public TimePlay(int size) {
        super(size);
        
        //Button properties
        timeButton = new JButton("Time left: #");
        
        //Panel properties
        gridPane = makeGrid(size);
        timePane = new JPanel(new FlowLayout());
        timePane.add(timeButton);
        
        //Frame properties
        frame = new JFrame("TIMEPLAY");
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(gridPane);
        frame.add(timePane, BorderLayout.NORTH);
	}
}