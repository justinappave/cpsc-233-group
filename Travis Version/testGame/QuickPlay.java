package testGame;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractButton;

public class QuickPlay extends Gameplay{
    public QuickPlay(int size) {
        super(size);
        movesPane = new JPanel(new FlowLayout());
		JButton movesButton = new JButton("Moves: ");
        movesPane.add(movesButton);
        frame.add(movesPane, BorderLayout.NORTH);
    }
}