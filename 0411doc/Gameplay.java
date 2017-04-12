/* This is the main class that creates the game screen and allows for movement of the tiles.
It is never instantiated so it is an abstract class. 
The actions listeners for all the buttons relating to the different gametypes are in this class
*/

import leaderboards.*;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public abstract class Gameplay implements ActionListener{
    Timer time;
    public JFrame frame;
    JButton movesButton = new JButton("Moves: 0");
    JButton timeButton = new JButton("Start Game!");
    JButton timeDisplayButton = new JButton("0");
    public ArrayList list;
	JPanel gridPane, movesPane, timePane;
    private int size;
    private int moves;
    private int mode;
    private int counter = 0;
    
    public void increaseMoves() {
        moves += 1;
    }
    
    public int getMoves() {
        return moves;
    }
    
    public void increaseTime() {
        counter += 1;
    }
    
    public int getTime() {
        return counter;
    }
    
    public void setSize(int newSize) {
        size = newSize;
    }
    public int getSize() {
        return size;
    }
    
    public void setMode(int newMode) {
        mode = newMode;
    }
    
    public int getMode() {
        return mode;
    }
	
	public Gameplay(int size, int mode) {
		setSize(size);
        setMode(mode);
	}
    
    /**This method creates a new JPanel and puts a grid of buttons on it. The grid is shuffled and
    it is checked that the grid remains solvable. If it is not solvable, a new grid is made.
    It takes that argument of int for the grid size. It returns a JPanel.*/
    public JPanel makeGrid(int size) {
        boolean solvable = false;
        while (!solvable) {
            JButton[] tile = new JButton[size*size];
            gridPane = new JPanel(new GridLayout(size,size));
            list = new ArrayList();
            
            for (int x = 0; x < (size*size); x++) {
                if(x < (size*size)-1){
                    if (getMode() != 0) {
                        tile[x] = new JButton(""+(x+1));
                    }
                    else {
                        tile[x] = new JButton();
                        String filePath = ("resources/" + x + ".png");
                        tile[x].setIcon(new ImageIcon(filePath));
                    }
                }
                else {
                    if (getMode() != 0) {
                        tile[x] = new JButton("");
                    }
                    else {
                        tile[x] = new JButton();
                        String filePath = ("resources/null.png");
                        tile[x].setIcon(new ImageIcon(filePath));
                    }
                }
    			tile[x].setFont(new Font("ARIAL", Font.BOLD, 70));
    			tile[x].setForeground(Color.ORANGE);
    			tile[x].setBackground(Color.BLACK);
    			tile[x].setFocusPainted(false);
                list.add(tile[x]);
            }
            Collections.shuffle(list);
            solvable = checkSolvability(list, size);
            if (solvable) {
                for(int x = 0; x < list.size(); x++) {
                    gridPane.add((JButton)list.get(x));
                    if (getMode() != 0) {
                        ((JButton)list.get(x)).setActionCommand("" + x);
                        ((JButton)list.get(x)).addActionListener(this);
                    }
                    else {
                        ((JButton)list.get(x)).setActionCommand("pic" + x);
                        ((JButton)list.get(x)).addActionListener(this);
                    }
                }
            }
        }
        return gridPane;
    }
    
    /**This method creates a bar with a quit to menu button and also different buttons depending on 
    the gametype*/
    public JPanel infoBar() {
        JPanel topPane = new JPanel(new FlowLayout());
        JButton quitToMenuButton = new JButton("Quit to menu");
        quitToMenuButton.setActionCommand("quit");
        quitToMenuButton.addActionListener(this);
        topPane.add(quitToMenuButton);
        return topPane;
    }    
    
    /**This method checks to make sure the grid is solvable. It takes the list and the size of the 
    /the grid as arguements and returns whether the grid is solvable or not.*/
    public boolean checkSolvability(ArrayList gridList, int gridSize) {
        boolean solvable = false;
        int length = gridList.size();
        int numInversions = 0;
        for (int itemsInList = 0; itemsInList < length; itemsInList++) {
            for (int restOfList = itemsInList; restOfList < length; restOfList++) { 
                if (getMode() == 0) {
                    try {
			    //if (number in list - number later in list > 0)
                        if (Integer.parseInt(((JButton)gridList.get(itemsInList)).getIcon().toString().substring(10,11)) - 
                                Integer.parseInt(((JButton)gridList.get(restOfList)).getIcon().toString().substring(10,11)) > 0) {
                            numInversions++;
                        }
                    }
                    catch (NumberFormatException except) {
                    }
                }
                else {
                    try {
			    //if (number in list - number later in list > 0)
                        if (Integer.parseInt(((JButton)gridList.get(itemsInList)).getText())-Integer.parseInt(((JButton)gridList.get(restOfList)).getText()) > 0) {
                            numInversions ++;
                        }
                    }
                    catch (NumberFormatException e) {
                    }
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
    
    /**This method checks to see if the game has been won for the non picture gametypess.
    It takes the list as an arugment and returns whter or not the game has been won*/
    public boolean checkGame(ArrayList list) {
        boolean won = false;
        int counter = 1;
        for (int i = 0; i < size*size; i++) {
            if (counter == size*size) {
                won = true;
            }
            try {
		    //if (button text == counter)
                if (Integer.parseInt(((JButton) list.get(i)).getText()) == counter) {
                    counter++;
                }
            }
            catch (NumberFormatException e) {
            }
        }
        return won;
    }
    
    /**This method checks to see if the game has been won for the picture gametype
    It takes the list ad argument whether or not the game has been won*/
    public boolean checkGamePicture(ArrayList list) {
        boolean won = false;
        int counter = 1;
        for (int i = 0; i < size*size; i++) {
            if (counter == size*size) {
                won = true;
            }
            try {
		    //if (button icon name == counter)
                if ((((JButton) list.get(i)).getIcon()).toString().equals("resources/" + i + ".png")) {
                    counter++;
                }
            }
            catch (NumberFormatException e) {
            }
        }
        return won;
    }
    
    //Action performed method (actions based on button pressed)
    public void actionPerformed(ActionEvent e) {
        
        //get Source of where the event occured
        JButton button = (JButton) e.getSource();
        
        //excution when quitButton is pressed
        if (e.getActionCommand().equals("quit")) {
            frame.dispose();
            Driver getMenu = new Driver();
            getMenu.MainMenu();
        }
        
        //execution when top left button is pressed
        else if (e.getActionCommand().equals("0")) { //top left corner
            if (button.getText().equals("")) {
            }
            else {
                JButton rightButton = (JButton) list.get(1);
                JButton bottomButton = (JButton) list.get(3);
                if (rightButton.getText().equals("")) {
                    rightButton.setText(button.getText());
                    button.setText("");
                    increaseMoves();
                }
                else if (bottomButton.getText().equals("")) {
                    bottomButton.setText(button.getText());
                    button.setText("");
                    increaseMoves();
                }
            }
        }
        
        //execution when top middle button is pressed
        else if (e.getActionCommand().equals("1")) {
            if (button.getText().equals("")) {
            }
            else {
                JButton rightButton = (JButton) list.get(2);
                JButton bottomButton = (JButton) list.get(4);
                JButton leftButton = (JButton) list.get(0);
                if (rightButton.getText().equals("")) {
                    rightButton.setText(button.getText());
                    button.setText("");
                    increaseMoves();
                }
                else if (bottomButton.getText().equals("")) {
                    bottomButton.setText(button.getText());
                    button.setText("");
                    increaseMoves();
                }
                else if (leftButton.getText().equals("")) {
                    leftButton.setText(button.getText());
                    button.setText("");
                    increaseMoves();
                }
            }
        }
        
        //execution when top right button is pressed
        else if (e.getActionCommand().equals("2")) {
            if (button.getText().equals("")) {
            }
            else {
                JButton bottomButton = (JButton) list.get(5);
                JButton leftButton = (JButton) list.get(1);
                if (bottomButton.getText().equals("")) {
                    bottomButton.setText(button.getText());
                    button.setText("");
                    increaseMoves();
                }
                else if (leftButton.getText().equals("")) {
                    leftButton.setText(button.getText());
                    button.setText("");
                    increaseMoves();
                }
            }
        }
        
        //execution when middle left button is pressed
        else if (e.getActionCommand().equals("3")) {
            if (button.getText().equals("")) {
            }
            else {
                JButton rightButton = (JButton) list.get(4);
                JButton bottomButton = (JButton) list.get(6);
                JButton topButton = (JButton) list.get(0);
                if (rightButton.getText().equals("")) {
                    rightButton.setText(button.getText());
                    button.setText("");
                    increaseMoves();
                }
                else if (bottomButton.getText().equals("")) {
                    bottomButton.setText(button.getText());
                    button.setText("");
                    increaseMoves();
                }
                else if (topButton.getText().equals("")) {
                    topButton.setText(button.getText());
                    button.setText("");
                    increaseMoves();
                }
            }
        }
        
        //execution when center button is pressed
        else if (e.getActionCommand().equals("4")) {
            if (button.getText().equals("")) {
            }
            else {
                JButton rightButton = (JButton) list.get(5);
                JButton bottomButton = (JButton) list.get(7);
                JButton topButton = (JButton) list.get(1);
                JButton leftButton = (JButton) list.get(3);
                if (rightButton.getText().equals("")) {
                    rightButton.setText(button.getText());
                    button.setText("");
                    increaseMoves();
                }
                else if (bottomButton.getText().equals("")) {
                    bottomButton.setText(button.getText());
                    button.setText("");
                    increaseMoves();
                }
                else if (topButton.getText().equals("")) {
                    topButton.setText(button.getText());
                    button.setText("");
                    increaseMoves();
                }
                else if (leftButton.getText().equals("")) {
                    leftButton.setText(button.getText());
                    button.setText("");
                    increaseMoves();
                }
            }
        }
        
        //execution when middle right button is pressed
        else if (e.getActionCommand().equals("5")) {
            if (button.getText().equals("")) {
            }
            else {
                JButton leftButton = (JButton) list.get(4);
                JButton bottomButton = (JButton) list.get(8);
                JButton topButton = (JButton) list.get(2);
                if (leftButton.getText().equals("")) {
                    leftButton.setText(button.getText());
                    button.setText("");
                    increaseMoves();
                }
                else if (bottomButton.getText().equals("")) {
                    bottomButton.setText(button.getText());
                    button.setText("");
                    increaseMoves();
                }
                else if (topButton.getText().equals("")) {
                    topButton.setText(button.getText());
                    button.setText("");
                    increaseMoves();
                }
            }
        }
        
        //execution when bottom left button is pressed
        else if (e.getActionCommand().equals("6")) {
            if (button.getText().equals("")) {
            }
            else {
                JButton rightButton = (JButton) list.get(7);
                JButton topButton = (JButton) list.get(3);
                if (rightButton.getText().equals("")) {
                    rightButton.setText(button.getText());
                    button.setText("");
                    increaseMoves();
                }
                else if (topButton.getText().equals("")) {
                    topButton.setText(button.getText());
                    button.setText("");
                    increaseMoves();
                }
            }
        }
        
        //execution when bottomMiddle button is pressed
        else if (e.getActionCommand().equals("7")) {
            if (button.getText().equals("")) {
            }
            else {
                JButton rightButton = (JButton) list.get(8);
                JButton topButton = (JButton) list.get(4);
                JButton leftButton = (JButton) list.get(6);
                if (rightButton.getText().equals("")) {
                    rightButton.setText(button.getText());
                    button.setText("");
                    increaseMoves();
                }
                else if (topButton.getText().equals("")) {
                    topButton.setText(button.getText());
                    button.setText("");
                    increaseMoves();
                }
                else if (leftButton.getText().equals("")) {
                    leftButton.setText(button.getText());
                    button.setText("");
                    increaseMoves();
                }
            }
        }
        
        //execution when bottom right button is pressed
        else if (e.getActionCommand().equals("8")) {
            if (button.getText().equals("")) {
            }
            else {
                JButton topButton = (JButton) list.get(5);
                JButton leftButton = (JButton) list.get(7);
                if (topButton.getText().equals("")) {
                    topButton.setText(button.getText());
                    button.setText("");
                    increaseMoves();
                }
                else if (leftButton.getText().equals("")) {
                    leftButton.setText(button.getText());
                    button.setText("");
                    increaseMoves();
                }
            }
            
            //Check to see if game is in winning state
            boolean won = checkGame(list);
            if (won == true && mode == 1) {
                HighScores hs = new HighScores(1);
                String name = JOptionPane.showInputDialog(null, "Enter your name:", "CONGRATULATIONS! YOU WON!", JOptionPane.WARNING_MESSAGE) ;
                hs.writeFile(name, getMoves());
                frame.dispose();
                Driver getMenu = new Driver();
                getMenu.MainMenu();
            }
        }
        
        //execution when top left button is pressed
        else if (e.getActionCommand().equals("pic0")) {
            JButton rightButton = (JButton) list.get(1);
            JButton bottomButton = (JButton) list.get(3);
            String rightIcon = (rightButton.getIcon()).toString();
            String bottomIcon = (bottomButton.getIcon()).toString();
            if (rightIcon.equals("resources/null.png")) {
                rightButton.setIcon(new ImageIcon(button.getIcon().toString()));
                button.setIcon(new ImageIcon("resources/null.png"));
            }
            else if (bottomIcon.equals("resources/null.png")) {
                bottomButton.setIcon(new ImageIcon(button.getIcon().toString()));
                button.setIcon(new ImageIcon("resources/null.png"));
            }
        }
        
        //execution when top middle button is pressed
        else if (e.getActionCommand().equals("pic1")) {
            Icon icon = button.getIcon();
            JButton rightButton = (JButton) list.get(2);
            JButton bottomButton = (JButton) list.get(4);
            JButton leftButton = (JButton) list.get(0);
            String rightIcon = (rightButton.getIcon()).toString();
            String leftIcon = (leftButton.getIcon()).toString();
            String bottomIcon = (bottomButton.getIcon()).toString();
            if (rightIcon.equals("resources/null.png")) {
                rightButton.setIcon(new ImageIcon(button.getIcon().toString()));
                button.setIcon(new ImageIcon("resources/null.png"));
            }
            else if (bottomIcon.equals("resources/null.png")) {
                bottomButton.setIcon(new ImageIcon(button.getIcon().toString()));
                button.setIcon(new ImageIcon("resources/null.png"));
            }
            else if (leftIcon.equals("resources/null.png")) {
                leftButton.setIcon(new ImageIcon(button.getIcon().toString()));
                button.setIcon(new ImageIcon("resources/null.png"));
            }
        }
        
        //execution when top right button is pressed
        else if (e.getActionCommand().equals("pic2")) {
            Icon icon = button.getIcon();
            JButton bottomButton = (JButton) list.get(5);
            JButton leftButton = (JButton) list.get(1);
            String leftIcon = (leftButton.getIcon()).toString();
            String bottomIcon = (bottomButton.getIcon()).toString();
            if (bottomIcon.equals("resources/null.png")) {
                bottomButton.setIcon(new ImageIcon(button.getIcon().toString()));
                button.setIcon(new ImageIcon("resources/null.png"));
            }
            else if (leftIcon.equals("resources/null.png")) {
                leftButton.setIcon(new ImageIcon(button.getIcon().toString()));
                button.setIcon(new ImageIcon("resources/null.png"));
            }
        }
        
        //execution when middle left button is pressed
        else if (e.getActionCommand().equals("pic3")) {
            Icon icon = button.getIcon();
            JButton rightButton = (JButton) list.get(4);
            JButton bottomButton = (JButton) list.get(6);
            JButton topButton = (JButton) list.get(0);
            String rightIcon = (rightButton.getIcon()).toString();
            String topIcon = (topButton.getIcon()).toString();
            String bottomIcon = (bottomButton.getIcon()).toString();
            if (rightIcon.equals("resources/null.png")) {
                rightButton.setIcon(new ImageIcon(button.getIcon().toString()));
                button.setIcon(new ImageIcon("resources/null.png"));
            }
            else if (bottomIcon.equals("resources/null.png")) {
                bottomButton.setIcon(new ImageIcon(button.getIcon().toString()));
                button.setIcon(new ImageIcon("resources/null.png"));
            }
            else if (topIcon.equals("resources/null.png")) {
                topButton.setIcon(new ImageIcon(button.getIcon().toString()));
                button.setIcon(new ImageIcon("resources/null.png"));
            }
        }
        
        //execution when center button is pressed
        else if (e.getActionCommand().equals("pic4")) {
            Icon icon = button.getIcon();
            JButton rightButton = (JButton) list.get(5);
            JButton bottomButton = (JButton) list.get(7);
            JButton topButton = (JButton) list.get(1);
            JButton leftButton = (JButton) list.get(3);
            String rightIcon = (rightButton.getIcon()).toString();
            String leftIcon = (leftButton.getIcon()).toString();
            String topIcon = (topButton.getIcon()).toString();
            String bottomIcon = (bottomButton.getIcon()).toString();
            if (rightIcon.equals("resources/null.png")) {
                rightButton.setIcon(new ImageIcon(button.getIcon().toString()));
                button.setIcon(new ImageIcon("resources/null.png"));
            }
            else if (bottomIcon.equals("resources/null.png")) {
                bottomButton.setIcon(new ImageIcon(button.getIcon().toString()));
                button.setIcon(new ImageIcon("resources/null.png"));
            }
            else if (topIcon.equals("resources/null.png")) {
                topButton.setIcon(new ImageIcon(button.getIcon().toString()));
                button.setIcon(new ImageIcon("resources/null.png"));
            }
            else if (leftIcon.equals("resources/null.png")) {
                leftButton.setIcon(new ImageIcon(button.getIcon().toString()));
                button.setIcon(new ImageIcon("resources/null.png"));
            }
        }
        
        //execution when middle right button is pressed
        else if (e.getActionCommand().equals("pic5")) {
            Icon icon = button.getIcon();
            JButton leftButton = (JButton) list.get(4);
            JButton bottomButton = (JButton) list.get(8);
            JButton topButton = (JButton) list.get(2);
            String leftIcon = (leftButton.getIcon()).toString();
            String topIcon = (topButton.getIcon()).toString();
            String bottomIcon = (bottomButton.getIcon()).toString();
            if (leftIcon.equals("resources/null.png")) {
                leftButton.setIcon(new ImageIcon(button.getIcon().toString()));
                button.setIcon(new ImageIcon("resources/null.png"));
            }
            else if (bottomIcon.equals("resources/null.png")) {
                bottomButton.setIcon(new ImageIcon(button.getIcon().toString()));
                button.setIcon(new ImageIcon("resources/null.png"));
            }
            else if (topIcon.equals("resources/null.png")) {
                topButton.setIcon(new ImageIcon(button.getIcon().toString()));
                button.setIcon(new ImageIcon("resources/null.png"));
            }
        }
        
        
        //execution when bottom left button is pressed
        else if (e.getActionCommand().equals("pic6")) {
            JButton rightButton = (JButton) list.get(7);
            JButton topButton = (JButton) list.get(3);
            String rightIcon = (rightButton.getIcon()).toString();
            String topIcon = (topButton.getIcon()).toString();
            if (rightIcon.equals("resources/null.png")) {
                rightButton.setIcon(new ImageIcon(button.getIcon().toString()));
                button.setIcon(new ImageIcon("resources/null.png"));
            }
            else if (topIcon.equals("resources/null.png")) {
                topButton.setIcon(new ImageIcon(button.getIcon().toString()));
                button.setIcon(new ImageIcon("resources/null.png"));
            }
        }
        
        //execution when bottom middle button is pressed
        else if (e.getActionCommand().equals("pic7")) {
            Icon icon = button.getIcon();
            JButton rightButton = (JButton) list.get(8);
            JButton topButton = (JButton) list.get(4);
            JButton leftButton = (JButton) list.get(6);
            String rightIcon = (rightButton.getIcon()).toString();
            String leftIcon = (leftButton.getIcon()).toString();
            String topIcon = (topButton.getIcon()).toString();
            if (rightIcon.equals("resources/null.png")) {
                rightButton.setIcon(new ImageIcon(button.getIcon().toString()));
                button.setIcon(new ImageIcon("resources/null.png"));
            }
            else if (topIcon.equals("resources/null.png")) {
                topButton.setIcon(new ImageIcon(button.getIcon().toString()));
                button.setIcon(new ImageIcon("resources/null.png"));
            }
            else if (leftIcon.equals("resources/null.png")) {
                leftButton.setIcon(new ImageIcon(button.getIcon().toString()));
                button.setIcon(new ImageIcon("resources/null.png"));
            }
        }
        
        //execution when bottom right button is pressed
        else if (e.getActionCommand().equals("pic8")) {
            JButton leftButton = (JButton) list.get(7);
            JButton topButton = (JButton) list.get(5);
            String leftIcon = (leftButton.getIcon()).toString();
            String topIcon = (topButton.getIcon()).toString();
            if (leftIcon.equals("resources/null.png")) {
                leftButton.setIcon(new ImageIcon(button.getIcon().toString()));
                button.setIcon(new ImageIcon("resources/null.png"));
            }
            else if (topIcon.equals("resources/null.png")) {
                topButton.setIcon(new ImageIcon(button.getIcon().toString()));
                button.setIcon(new ImageIcon("resources/null.png"));
            }
            boolean won = checkGamePicture(list);
            if (won == true) {
                JOptionPane.showMessageDialog(null, "CONGRATULATIONS! YOU WON!");
                frame.dispose();
                Driver getMenu = new Driver();
                getMenu.MainMenu();
            }
        }
        
        //excution for timeplay, game only starts once the timer has been started
        else if(e.getActionCommand().equals("Start timer!")) {
            timeButton.removeActionListener(this);
            gridPane = makeGrid(size);
            frame.add(gridPane);
        	time = new Timer(1000, new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
                    boolean won = checkGame(list);
                    if (won == true) {
                        time.stop();
                        HighScores hs = new HighScores(0);
                        String name = JOptionPane.showInputDialog(null, "Enter your name:", "CONGRATULATIONS! YOU WON!", JOptionPane.WARNING_MESSAGE) ;
                        hs.writeFile(name, getTime());
                        frame.dispose();
                        Driver getMenu = new Driver();
                        getMenu.MainMenu();
                    }
        			timeDisplayButton.setText(String.valueOf(getTime()));
        			increaseTime();
        		}
        	});
        	time.start();
        }
        movesButton.setText("Moves: " + getMoves());
    }
}
