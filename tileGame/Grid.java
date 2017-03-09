
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
        emptyRow = row;
    }

    public void setEmptyColumn(int column) {
        emptyColumn = column;
    }
    
    private int size;
    
    public void setSize(int newSize) {
        size = newSize;
    }
    
    public int getSize() {
        return size;
    }
    
    public String[][] grid;
    
    static String[][] babyConfig = {
        {" "," "},
        {" "," "}
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
	public void displayGrid(int size){
		//prints out the grid
		for (int row = 0; row < size; row++){
				System.out.print("|");
				for (int column = 0; column < size; column++){
					System.out.print(grid[row][column] + "|");
			}
			System.out.println();
		}
	}

    //This prompts the user for what size/difficulty they want then changes the variable by calling "setSize"
	public void getNewSize() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("What size/difficulty? (2,3,4,5)");
        String sizeStr = keyboard.nextLine();
        int size = Integer.parseInt(sizeStr);
        setSize(size);
	}

    /** creates the grid. It first makes an arraylist called "numbers" of the correct size depending on 
    difficulty, then shuffles that list using "Collection.shuffle(numbers)". It then sets the grid
    variable to have the correct size as well, then changes each entry of grid to correspond to the
    shuffled list placing the last entry as the blank spot.
    */
    public String[][] makeGrid(int size) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int amount = 1; amount < (size*size); amount++) {
            numbers.add(new Integer(amount));
        }
        Collections.shuffle(numbers);
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
        
        int numCounter = 0;
        for (int rowCounter = 0; rowCounter < size; rowCounter++) {
            for (int columnCounter = 0; columnCounter < size; columnCounter++) {
                if ((rowCounter*columnCounter) != ((size-1)*(size-1))) {
                    grid[rowCounter][columnCounter] = Integer.toString(numbers.get(numCounter));
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
    public void makeMove(String[][] grid) {
        System.out.println("Which direction would you like to move? (W,A,S,D)");
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
        else {
            System.out.println("Invalid direction, that letter doesn't work");
        }
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