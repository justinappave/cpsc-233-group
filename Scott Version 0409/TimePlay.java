//package tilePuzzle;
import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimePlay extends Gameplay {
	JFrame frame;
	JPanel gridPane, topPane;
	JButton timeButton;
    Timer timer;
    int counter = 60;
	
	public TimePlay(int size) {
        super(size);
        
        //Button properties
        timeButton = new JButton("Start Timer");
        
        //Panel properties
        gridPane = makeGrid(size, false);
        topPane = infoBar();
        topPane.add(timeButton);
        
        //Frame properties
        frame = new JFrame("TIMEPLAY");
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(gridPane);
        frame.add(topPane, BorderLayout.NORTH);
        
        //Add action commands and action listeners
        timeButton.setActionCommand("Start timer!");
        timeButton.addActionListener(this);
	}
    
	public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Start timer!")) {
        	timer = new Timer(1000, new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			timeButton.setText(String.valueOf(counter));
        			counter--;
        			if(counter <= -1) {
        				timer.stop();
        			}
        		}
        	});
        	timer.start();
        }
	}
}