package tilePuzzle;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Grid {
	JFrame frame;
	JPanel gridPane;
	
	public void SmallGrid() {
		gridPane = makeGrid(3);
		
		frame = new JFrame("3 x 3 PUZZLE");
		frame.setSize(800,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(gridPane);
	}
	public void MediumGrid() {
		gridPane = makeGrid(4);
		
		frame = new JFrame("4 x 4 PUZZLE");
		frame.setSize(800,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(gridPane);
	}
	public void LargeGrid() {
		gridPane = makeGrid(5);
		
		frame = new JFrame("5 x 5 PUZZLE");
		frame.setSize(800,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(gridPane);
	}
	public JPanel makeGrid(int size) {
		JButton[] tile = new JButton[size*size];
		gridPane = new JPanel(new GridLayout(size,size));
		ArrayList list = new ArrayList();
		
		for(int x = 0; x < (size*size); x++) {
			if(x < (size*size) - 1) {
				tile[x] = new JButton(""+(x+1));
			}
			else {
				tile[x] = new JButton("");
			}
			tile[x].setFont(new Font("ARIAL", Font.BOLD, 100));
			tile[x].setForeground(Color.ORANGE);
			tile[x].setBackground(Color.BLACK);
			tile[x].setFocusPainted(false);
			list.add(tile[x]);
		}
		Collections.shuffle(list);
		for(int x = 0; x < list.size(); x++) {
			gridPane.add((JButton)list.get(x));
		}
		return gridPane;
	}
}
