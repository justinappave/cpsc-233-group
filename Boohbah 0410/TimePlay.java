import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimePlay extends Gameplay {

  //Initialize frame components
  JPanel topPane;

  //TimePlay constructor
  public TimePlay(int size) {

    //Gameplay(grid size, gamemode)
    super(size, 2);

    //Panel properties
    gridPane = new JPanel();
    gridPane.setBackground(Color.BLACK);
    topPane = infoBar();
    topPane.add(timeButton);
    topPane.add(timeDisplayButton);

    //Frame properties
    frame = new JFrame("TIMEPLAY");
    frame.setSize(800,800);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setVisible(true);
    frame.add(gridPane);
    frame.add(topPane, BorderLayout.NORTH);

    //Add ActionListener and ActionCommand
    timeButton.setActionCommand("Start timer!");
    timeButton.addActionListener(this);
  }
}
