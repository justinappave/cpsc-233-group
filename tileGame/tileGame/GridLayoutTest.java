package tileGame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutTest {
	public static void main(String[] args){
		JFrame gridFrame = new JFrame("GridLayout Test");
		gridFrame.setLayout(new GridLayout(3,3));
		gridFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gridFrame.add(new JButton("1"));
		gridFrame.add(new JButton("2"));
		gridFrame.add(new JButton("3"));
		gridFrame.add(new JButton("4"));
		gridFrame.add(new JButton("5"));
		gridFrame.add(new JButton("6"));
		gridFrame.add(new JButton("7"));
		gridFrame.add(new JButton("8"));
		
		gridFrame.pack();
		gridFrame.setVisible(true);
	}

}
