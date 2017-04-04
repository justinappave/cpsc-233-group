import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractButton;

public class FreeplayGridGUI extends GridGUI{
    public FreeplayGridGUI(int size) {
        super(size);
        movesPane = new JPanel();
		JButton movesButton = new JButton("Moves: ");
        movesPane.add(movesButton);
        frame.add(movesPane, BorderLayout.NORTH);
    }
}