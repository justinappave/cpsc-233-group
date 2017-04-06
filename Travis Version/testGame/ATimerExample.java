package testGame;

import javax.swing.*;
import java.util.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATimerExample {

    Timer timer;
    int counter = 10;

    public ATimerExample() {
        final JFrame frame = new JFrame("somethgi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JLabel label = new JLabel("0");
        JPanel panel = new JPanel();
        panel.add(label, BorderLayout.SOUTH);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(String.valueOf(counter));
                counter--;
                if (counter == -1) {
                    //timer.removeActionListener(this);
                      timer.stop();
                }
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ATimerExample();
            }
        });
    }
}