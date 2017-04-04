
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractButton;

public class GridGUI implements ActionListener{
    private int size;
    
    public void setSize(int newSize) {
        size = newSize;
    }
    
    public int getSize() {
        return size;
    }
    
    public ArrayList list;
	JFrame frame;
	JPanel gridPane,movesPane;
    
	public GridGUI(int size) {
        setSize(size);
		frame = new JFrame("Tile Puzzle Game");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(3);
		
		//movesPane = new JPanel();
		//JButton movesButton = new JButton("Moves: ");
        
		gridPane = makeGrid(size);
		frame.add(gridPane);
		frame.setVisible(true);
		//movesPane.add(movesButton);
		//frame.add(movesPane, BorderLayout.NORTH);
	}
    
    public JPanel makeGrid(int size) {
        boolean solvable = false;
        while (!solvable) {
            JButton[] tile = new JButton[size*size];
            gridPane = new JPanel(new GridLayout(size, size));
            list = new ArrayList();
            
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
            solvable = checkSolvability(list, size);
            if (solvable) {
                for(int x = 0; x < list.size(); x++) {
                    gridPane.add((JButton)list.get(x));
                    ((JButton)list.get(x)).setActionCommand("" + x);
                    ((JButton)list.get(x)).addActionListener(this);
                }
            }
        }
        return gridPane;
    }
    
    public boolean checkSolvability(ArrayList gridList, int gridSize) {
        boolean solvable = false;
        int length = gridList.size();
        int numInversions = 0;
        for (int itemsInList = 0; itemsInList < length; itemsInList++) {
            for (int restOfList = itemsInList; restOfList < length; restOfList++) {
                try {
                    if (Integer.parseInt(((JButton)gridList.get(itemsInList)).getText())-Integer.parseInt(((JButton)gridList.get(restOfList)).getText()) > 0) {
                        numInversions ++;
                    }
                }
                catch (NumberFormatException e) {
                }
            }
        }
        if ((gridSize%2 != 0) && (numInversions%2 == 0)) {
            solvable = true;
        }
        else if ((gridSize%2 == 0) && (numInversions%2 == 0)) {
            solvable = true;
        }
        return solvable;
    }
    
    public boolean checkGame(ArrayList list) {
        boolean won = false;
        int counter = 1;
        for (int i = 0; i < size*size; i++) {
            if (counter == size*size) {
                won = true;
            }
            try {
                if (Integer.parseInt(((JButton) list.get(i)).getText()) == counter) {
                    counter++;
                }
            }
            catch (NumberFormatException e) {
            }
        }
        return won;
    }
    
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        int commandInt = Integer.parseInt(command);
        if (e.getActionCommand().equals("0")) { //top left corner
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("")) {
                System.out.println("you hit the button and its empty");
            }
            else {
                JButton rightButton = (JButton) list.get(1);
                JButton bottomButton = (JButton) list.get(3);
                if (rightButton.getText().equals("")) {
                    rightButton.setText(button.getText());
                    button.setText("");
                }
                else if (bottomButton.getText().equals("")) {
                    bottomButton.setText(button.getText());
                    button.setText("");
                }
            }
            boolean won = checkGame(list);
            if (won == true) {
                System.out.println("YOU WON");
            }
        }
        else if (e.getActionCommand().equals("" + (size-1))) { //top right corner
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("")) {
                System.out.println("you hit the button and its empty");
            }
            else {
                JButton bottomButton = (JButton) list.get(5);
                JButton leftButton = (JButton) list.get(1);
                if (bottomButton.getText().equals("")) {
                    bottomButton.setText(button.getText());
                    button.setText("");
                }
                else if (leftButton.getText().equals("")) {
                    leftButton.setText(button.getText());
                    button.setText("");
                }
            }
            boolean won = checkGame(list);
            if (won == true) {
                System.out.println("YOU WON");
            }
        }
        else if (e.getActionCommand().equals("" + (size*(size-1)))) { //bottom left corner
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("")) {
                System.out.println("you hit the button and its empty");
            }
            else {
                JButton rightButton = (JButton) list.get(7);
                JButton topButton = (JButton) list.get(3);
                if (rightButton.getText().equals("")) {
                    rightButton.setText(button.getText());
                    button.setText("");
                }
                else if (topButton.getText().equals("")) {
                    topButton.setText(button.getText());
                    button.setText("");
                }
            }
            boolean won = checkGame(list);
            if (won == true) {
                System.out.println("YOU WON");
            }
        }
        else if (e.getActionCommand().equals("" + ((size*size)-1))) { //bottom right corner
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("")) {
                System.out.println("you hit the button and its empty");
            }
            else {
                JButton topButton = (JButton) list.get(5);
                JButton leftButton = (JButton) list.get(7);
                if (topButton.getText().equals("")) {
                    topButton.setText(button.getText());
                    button.setText("");
                }
                else if (leftButton.getText().equals("")) {
                    leftButton.setText(button.getText());
                    button.setText("");
                }
            }
            boolean won = checkGame(list);
            if (won == true) {
                System.out.println("YOU WON");
            }
        }
        else if (e.getActionCommand().equals("1")) {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("")) {
                System.out.println("you hit the button and its empty");
            }
            else {
                JButton rightButton = (JButton) list.get(2);
                JButton bottomButton = (JButton) list.get(4);
                JButton leftButton = (JButton) list.get(0);
                if (rightButton.getText().equals("")) {
                    rightButton.setText(button.getText());
                    button.setText("");
                }
                else if (bottomButton.getText().equals("")) {
                    bottomButton.setText(button.getText());
                    button.setText("");
                }
                else if (leftButton.getText().equals("")) {
                    leftButton.setText(button.getText());
                    button.setText("");
                }
            }
            boolean won = checkGame(list);
            if (won == true) {
                System.out.println("YOU WON");
            }
        }
        else if (e.getActionCommand().equals("2")) {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("")) {
                System.out.println("you hit the button and its empty");
            }
            else {
                JButton bottomButton = (JButton) list.get(5);
                JButton leftButton = (JButton) list.get(1);
                if (bottomButton.getText().equals("")) {
                    bottomButton.setText(button.getText());
                    button.setText("");
                }
                else if (leftButton.getText().equals("")) {
                    leftButton.setText(button.getText());
                    button.setText("");
                }
            }
            boolean won = checkGame(list);
            if (won == true) {
                System.out.println("YOU WON");
            }
        }
        else if (e.getActionCommand().equals("3")) {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("")) {
                System.out.println("you hit the button and its empty");
            }
            else {
                JButton rightButton = (JButton) list.get(4);
                JButton bottomButton = (JButton) list.get(6);
                JButton topButton = (JButton) list.get(0);
                if (rightButton.getText().equals("")) {
                    rightButton.setText(button.getText());
                    button.setText("");
                }
                else if (bottomButton.getText().equals("")) {
                    bottomButton.setText(button.getText());
                    button.setText("");
                }
                else if (topButton.getText().equals("")) {
                    topButton.setText(button.getText());
                    button.setText("");
                }
            }
            boolean won = checkGame(list);
            if (won == true) {
                System.out.println("YOU WON");
            }
        }
        else if (e.getActionCommand().equals("4")) {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("")) {
                System.out.println("you hit the button and its empty");
            }
            else {
                JButton rightButton = (JButton) list.get(5);
                JButton bottomButton = (JButton) list.get(7);
                JButton topButton = (JButton) list.get(1);
                JButton leftButton = (JButton) list.get(3);
                if (rightButton.getText().equals("")) {
                    rightButton.setText(button.getText());
                    button.setText("");
                }
                else if (bottomButton.getText().equals("")) {
                    bottomButton.setText(button.getText());
                    button.setText("");
                }
                else if (topButton.getText().equals("")) {
                    topButton.setText(button.getText());
                    button.setText("");
                }
                else if (leftButton.getText().equals("")) {
                    leftButton.setText(button.getText());
                    button.setText("");
                }
            }
            boolean won = checkGame(list);
            if (won == true) {
                System.out.println("YOU WON");
            }
        }
        else if (e.getActionCommand().equals("5")) {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("")) {
                System.out.println("you hit the button and its empty");
            }
            else {
                JButton leftButton = (JButton) list.get(4);
                JButton bottomButton = (JButton) list.get(8);
                JButton topButton = (JButton) list.get(2);
                if (leftButton.getText().equals("")) {
                    leftButton.setText(button.getText());
                    button.setText("");
                }
                else if (bottomButton.getText().equals("")) {
                    bottomButton.setText(button.getText());
                    button.setText("");
                }
                else if (topButton.getText().equals("")) {
                    topButton.setText(button.getText());
                    button.setText("");
                }
            }
            boolean won = checkGame(list);
            if (won == true) {
                System.out.println("YOU WON");
            }
        }
        else if (e.getActionCommand().equals("6")) {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("")) {
                System.out.println("you hit the button and its empty");
            }
            else {
                JButton rightButton = (JButton) list.get(7);
                JButton topButton = (JButton) list.get(3);
                if (rightButton.getText().equals("")) {
                    rightButton.setText(button.getText());
                    button.setText("");
                }
                else if (topButton.getText().equals("")) {
                    topButton.setText(button.getText());
                    button.setText("");
                }
            }
            boolean won = checkGame(list);
            if (won == true) {
                System.out.println("YOU WON");
            }
        }
        else if (e.getActionCommand().equals("7")) {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("")) {
                System.out.println("you hit the button and its empty");
            }
            else {
                JButton rightButton = (JButton) list.get(8);
                JButton topButton = (JButton) list.get(4);
                JButton leftButton = (JButton) list.get(6);
                if (rightButton.getText().equals("")) {
                    rightButton.setText(button.getText());
                    button.setText("");
                }
                else if (topButton.getText().equals("")) {
                    topButton.setText(button.getText());
                    button.setText("");
                }
                else if (leftButton.getText().equals("")) {
                    leftButton.setText(button.getText());
                    button.setText("");
                }
            }
            boolean won = checkGame(list);
            if (won == true) {
                System.out.println("YOU WON");
            }
        }
        else if (e.getActionCommand().equals("8")) {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("")) {
                System.out.println("you hit the button and its empty");
            }
            else {
                JButton topButton = (JButton) list.get(5);
                JButton leftButton = (JButton) list.get(7);
                if (topButton.getText().equals("")) {
                    topButton.setText(button.getText());
                    button.setText("");
                }
                else if (leftButton.getText().equals("")) {
                    leftButton.setText(button.getText());
                    button.setText("");
                }
            }
            boolean won = checkGame(list);
            if (won == true) {
                System.out.println("YOU WON");
            }
        }
    }
}