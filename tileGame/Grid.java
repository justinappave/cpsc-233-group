
/* 
This class prints the grid and moves the number the user specifies 
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Grid {
    private String EMPTY = " ";
    
    private int emptyRow;
    private int emptyColumn;
    
    public void setEmptyRow(int row) {
        if (row >= 0) {
            emptyRow = row;
        }
    }
    
    public int getEmptyRow() {
        return emptyRow;
    }

    public void setEmptyColumn(int column) {
        if (column >= 0) {
            emptyColumn = column;
        }
    }
    
    public int getEmptyColumn() {
        return emptyColumn;
    }
    
    private int size;
    
    public void setSize(int newSize) {
        if (newSize > 0) {
            size = newSize;
        }
    }
    
    public int getSize() {
        return size;
    }
    
    public String[][] grid;
    
    static String[][] babyConfig = {
		{"1","2","3"},
		{"4","5","6"},
		{"7"," ","8"}
	};
    
	static String[][] easyConfig = {
		{" "," "," "},
		{" "," "," "},
		{" "," "," "}
	};

	static String[][] mediumConfig = {
		{" "," "," "," "},
		{" "," "," "," "},
		{" "," "," "," "},
        {" "," "," "," "}
    };
    
    static String[][] hardConfig = {
        {" "," "," "," "," "},
        {" "," "," "," "," "},
        {" "," "," "," "," "},
        {" "," "," "," "," "},
        {" "," "," "," "," "}
    };

	public void setGrid(String[][] newGridSize) { //sets the grid to be the correct template
        grid = newGridSize;
    }

    //This displays the elements of the String[][] grid with "|" in between, so it looks like a grid
	public void displayGrid(int moveCount){
		//prints out the grid
        int size = getSize();
		for (int row = 0; row < size; row++){
				System.out.print("|");
				for (int column = 0; column < size; column++){
					System.out.print(grid[row][column] + "|");
			}
			System.out.println();
		}
        System.out.println("Moves: " + moveCount);
	}


    /** creates the grid. It first makes an arraylist called "numbers" of the correct size depending on 
    difficulty, then shuffles that list using "Collection.shuffle(numbers)". It then sets the grid
    variable to have the correct size as well, then changes each entry of grid to correspond to the
    shuffled list placing the last entry as the blank spot.
    */
    public String[][] makeGrid() {
        boolean solvable = false;
        int size = getSize();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        while (solvable == false) {
            for (int amount = 1; amount < (size*size); amount++) {
                numbers.add(new Integer(amount));
            }
            Collections.shuffle(numbers);
            solvable = checkSolvability(numbers, size);
            if (solvable == false) {
                numbers.clear();
            }
        }
        if (size == 2) {
            setGrid(babyConfig);
        }
        else if (size == 3) {
            setGrid(easyConfig);
        }
        else if (size == 4) {
            setGrid(mediumConfig);
        }
        else if (size == 5) {
            setGrid(hardConfig);
        }
        grid = convertToGrid(numbers);
        return grid;
    }
    
    
    /** This method makes sure the grid is solvable. Since currently the empty space is always at the end,
    it does not need to check if the empty space is on an odd row from the bottom when the grid size is even
    See this website from more details about this: 
    https://www.cs.bham.ac.uk/~mdr/teaching/modules04/java2/TilesSolvability.html
    */
    public boolean checkSolvability(ArrayList<Integer> gridList, int gridSize) {
        boolean solvable = false;
        int length = gridList.size();
        int numInversions = 0;
        for (int itemsInList = 0; itemsInList < length; itemsInList++) {
            for (int restOfList = itemsInList; restOfList < length; restOfList++) {
                if (gridList.get(itemsInList)-gridList.get(restOfList) > 0) {
                    numInversions ++;
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
    
    public String[][] convertToGrid(ArrayList<Integer> numberList) {
        int numCounter = 0;
        for (int rowCounter = 0; rowCounter < size; rowCounter++) {
            for (int columnCounter = 0; columnCounter < size; columnCounter++) {
                if ((rowCounter*columnCounter) != ((size-1)*(size-1))) {
                    grid[rowCounter][columnCounter] = Integer.toString(numberList.get(numCounter));
                    numCounter += 1;
                }
                else {
                    grid[rowCounter][columnCounter] = EMPTY;
                }
            }
        }
        return grid;
    }        
    
    //Prompts for user input involving tile movement, calls the correct method depending on choice
    public boolean makeMove(String[][] grid) {
        boolean returnToMenu = false;
        System.out.println("Which direction would you like to move? (W,A,S,D). Or press e to quit");
        Scanner keyboard = new Scanner(System.in);
        String direction = keyboard.nextLine();
        for(int row = 0; row < grid.length; row++) {
            for(int column = 0; column < grid.length; column++) {
                if (grid[row][column] == " ") {
                    setEmptyRow(row);
                    setEmptyColumn(column);
                }
            }
        }
        //setSpaceRowColumn(String[][] grid);
        if (direction.equals("w")) {
            moveUp();
        }
        else if (direction.equals("s")) {
            moveDown();
        }
        else if (direction.equals("a")) {
            moveLeft();
        }
        else if (direction.equals("d")) {
            moveRight();
        }
        else if (direction.equals("e")) {
            returnToMenu = true;
        }
        else {
            System.out.println("Invalid direction, that letter doesn't work");
        }
        return returnToMenu;
    }
    
    //finds the location of the empty space in the grid and stores the values in emptyRow and emptyColumn
    public void setSpaceRowColumn(String[][] findGrid) {
        for(int row = 0; row < findGrid.length; row++) {
            for(int column = 0; column < findGrid.length; column++) {
                if (findGrid[row][column] == " ") {
                    setEmptyRow(row);
                    setEmptyColumn(column);
                }
            }
        }
    }
    
    public void moveUp() { //moves tile below empty space into empty space is called when "w" is pressed
        try {
            grid[emptyRow][emptyColumn] = grid[emptyRow+1][emptyColumn];
            grid[emptyRow+1][emptyColumn] = EMPTY;
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Move. Out of bounds, try again");
        }
    }
    
    public void moveDown() { //moves tile above empty space into empty space is called when "s" is pressed
        try {
            grid[emptyRow][emptyColumn] = grid[emptyRow-1][emptyColumn];
            grid[emptyRow-1][emptyColumn] = EMPTY;
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Move. Out of bounds, try again");
        }
    }
    
    public void moveLeft() { //moves tile right of empty space into empty space is called when "a" is pressed
        try {
            grid[emptyRow][emptyColumn] = grid[emptyRow][emptyColumn+1];
            grid[emptyRow][emptyColumn+1] = EMPTY;
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Move. Out of bounds, try again");
        }
    }
    
    public void moveRight() { //moves tile left of empty space into empty space is called when "d" is pressed
        try {
            grid[emptyRow][emptyColumn] = grid[emptyRow][emptyColumn-1];
            grid[emptyRow][emptyColumn-1] = EMPTY;
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Move. Out of bounds, try again");
        }
    }
}