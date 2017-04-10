//package tilePuzzle;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JTextField;

public class WinnerMenu implements ActionListener {
	private JFrame frame;
	private JPanel pane;
	private JButton enterButton;
	private JLabel title;
    private JTextField enterName;
	
	public WinnerMenu() {
		//Label properties
		title = new JLabel("CONGRATULATIONS!");
		title.setPreferredSize(new Dimension(400,50));
		title.setFont(new Font("ARIAL", Font.BOLD, 40));
		title.setForeground(Color.ORANGE);
		
		//Button properties
		
		enterButton = new JButton("Enter");
		enterButton.setPreferredSize(new Dimension(400,90));
		enterButton.setFont(new Font("ARIAL", Font.BOLD, 40));
		enterButton.setForeground(Color.WHITE);
		enterButton.setBackground(Color.BLACK);
		enterButton.setBorderPainted(false);
		enterButton.setFocusPainted(false);
		enterButton.setActionCommand("enter");
        
    //IN PROGRESS
    enterName = new JTextField("", 20);
    enterName.setPreferredSize(new Dimension(50, 20));
		
		//Panel properties
		pane = new JPanel(new BorderLayout());
		pane.setBackground(Color.BLACK);
        pane.add(title, BorderLayout.PAGE_START);
        pane.add(enterName, BorderLayout.CENTER);
        pane.add(enterButton, BorderLayout.PAGE_END);
		
		//Frame properties
		frame = new JFrame("YOU WIN!");
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(pane);
		
		//Add action commands and action listeners
		enterButton.setActionCommand("enter");
		enterButton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("enter")) {
			frame.dispose();
		}
	}
}
