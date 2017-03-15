package tileGame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class QuickPlay {
	public void playQuick(){
		JFrame quickFrame = new JFrame("QuickPlay");
		quickFrame.setSize(500,500);
		quickFrame.setLayout(new GridLayout(3,3));
		quickFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		quickFrame.add(new JButton("1"));
		quickFrame.add(new JButton("2"));
		quickFrame.add(new JButton("3"));
		quickFrame.add(new JButton("4"));
		quickFrame.add(new JButton("5"));
		quickFrame.add(new JButton("6"));
		quickFrame.add(new JButton("7"));
		quickFrame.add(new JButton("8"));
		
		quickFrame.pack();
		quickFrame.setVisible(true);
	}
}