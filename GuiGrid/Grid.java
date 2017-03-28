package tilePuzzle;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Grid {
	JFrame frame;
	JPanel gridPane,movesPane;
	public void SmallGrid() {
		JButton[] tile = new JButton[9];
		frame = new JFrame("Tile Puzzle Game");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(3);
		
		gridPane = new JPanel(new GridLayout(3,3));
		movesPane = new JPanel();
		JButton movesButton = new JButton("Moves: ");
		
		ArrayList list = new ArrayList();
		for(int x = 0; x < tile.length; x++) {
			if(x < 8){
				tile[x] = new JButton(""+(x+1));
			}
			else {
				tile[x] = new JButton("");
			}
			tile[x].setFont(new Font("Arial", Font.BOLD, 100));
			list.add(tile[x]);
		}
		Collections.shuffle(list);
		for(int x = 0; x < list.size(); x++) {
			gridPane.add((JButton)list.get(x));
		}
		frame.add(gridPane);
		frame.setVisible(true);
		movesPane.add(movesButton);
		frame.add(movesPane, BorderLayout.NORTH);
	}
	public void mediumGrid() {
		JButton[] tile = new JButton[16];
		frame = new JFrame("Tile Puzzle Game");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(3);
		
		gridPane = new JPanel(new GridLayout(4,4));
		
		ArrayList list = new ArrayList();
		for(int x = 0; x < tile.length; x++) {
			tile[x] = new JButton(""+(x+1));
			list.add(tile[x]);
		}
		Collections.shuffle(list);
		for(int x = 0; x < list.size(); x++) {
			gridPane.add((JButton)list.get(x));
		}
		frame.add(gridPane);
		frame.setVisible(true);
	}
	public void largeGrid() {
		JButton[] tile = new JButton[25];
		frame = new JFrame("Tile Puzzle Game");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(3);
		
		gridPane = new JPanel(new GridLayout(5,5));
		
		ArrayList list = new ArrayList();
		for(int x = 0; x < tile.length; x++) {
			tile[x] = new JButton(""+(x+1));
			list.add(tile[x]);
		}
		Collections.shuffle(list);
		for(int x = 0; x < list.size(); x++) {
			gridPane.add((JButton)list.get(x));
		}
		frame.add(gridPane);
		frame.setVisible(true);
	}
}