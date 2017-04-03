
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class GridGUI {
	JFrame frame;
	JPanel gridPane,movesPane;
    
	public void SmallGrid() {
		frame = new JFrame("Tile Puzzle Game");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(3);
		
		movesPane = new JPanel();
		JButton movesButton = new JButton("Moves: ");
        
		gridPane = makeGrid(3);
		frame.add(gridPane);
		frame.setVisible(true);
		movesPane.add(movesButton);
		frame.add(movesPane, BorderLayout.NORTH);
	}
    
	public void mediumGrid() {
		frame = new JFrame("Tile Puzzle Game");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(3);
		
        gridPane = makeGrid(4);
		frame.add(gridPane);
		frame.setVisible(true);
	}
    
	public void largeGrid() {
		frame = new JFrame("Tile Puzzle Game");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(3);
		
        gridPane = makeGrid(5);
		frame.add(gridPane);
		frame.setVisible(true);
	}
    
    public JPanel makeGrid(int size) {
        JButton[] tile = new JButton[size*size];
        gridPane = new JPanel(new GridLayout(size, size));
        ArrayList list = new ArrayList();
        
        for (int x = 0; x < (size*size); x++) {
            if(x < (size*size)-1){
				tile[x] = new JButton(""+(x+1));
			}
			else {
				tile[x] = new JButton("");
			}
			tile[x].setFont(new Font("Arial", Font.BOLD, 60));
			list.add(tile[x]);
		}
		Collections.shuffle(list);
		for(int x = 0; x < list.size(); x++) {
			gridPane.add((JButton)list.get(x));
		}
        return gridPane;
    }   
}