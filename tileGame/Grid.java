/* This class prints the grid and moves the number the user specifies 
*/

import java.util.Scanner;

public class Grid {
	static char[][] easyConfig = {
		{'1','2','3'},
		{'4','5','6'},
		{'7',' ','8'}
	};

	static char[][] mediumConfig = {
		{'3','8','4'},
		{' ','1','7'},
		{'6','5','2'}
	};

	char[][] grid = easyConfig;


	public void displayGrid(){
		//prints out the grid
		for (int row = 0; row < 3; row++){
				System.out.print("|");
				for (int column = 0; column < 3; column++){
					System.out.print(grid[row][column] + "|");
			}
			System.out.println();
		}
	}

    public int getBounds() {
        return 3;
    }

	public void setGridDiff(int difficultySelect){
		//sets which grid to the difficulty selected
		if(difficultySelect == 1){
			grid = easyConfig;
		}
		else if(difficultySelect == 2){
			grid = mediumConfig;
		}
	}

    public char[][] makeGrid() {
        return easyConfig;
    }

    public void makeMove() {   //gets input from user, selects number and where to move it
        int numberRow = 21;
				int numberColumn = 21;
        int moveCounter = 0;
        System.out.println("Move Counter: " + moveCounter);
				System.out.print("Select number to move: ");
        Scanner keyboard = new Scanner(System.in);
				char enteredNumber = keyboard.next(".").charAt(0);
				System.out.print("Where would you like to move that number: ");
				String userMove = keyboard.next();

		/*finds what row and column the number the user entered is at
		and also finds what row and column the blank spot is at*/
			for(int userRow = 0; userRow < grid.length; userRow++){
				for(int userColumn = 0; userColumn < grid.length; userColumn++){
					if(grid[userRow][userColumn] == enteredNumber){
						numberRow = userRow;
						numberColumn = userColumn;
					}
				}
			}
      if(userMove.equals("s")){ //moves down
          try { // makes sure user move is in playing field bounds
                if (grid[numberRow + 1][numberColumn] == ' ') { // case where adjacent space is empty
                    grid[numberRow][numberColumn] = ' ';
                    grid[numberRow + 1][numberColumn] = enteredNumber;
                    moveCounter += 1;
                }
                else { //case where adjacent space is not empty, allows for moving two pieces at once
                    if (grid[numberRow + 2][numberColumn] == ' ') {
                        grid[numberRow + 2][numberColumn] = grid[numberRow + 1][numberColumn];
                        grid[numberRow][numberColumn] = ' ';
                        grid[numberRow + 1][numberColumn] = enteredNumber;
                        moveCounter += 2;
                    }
                    else {
                        System.out.println("Invalid move. Spaces filled");
                    }
                }
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Invalid Move. Out of bounds, try again");
            }
        }
        else if(userMove.equals("w")){ //moves up
            try {
                if (grid[numberRow - 1][numberColumn] == ' ') {
                    grid[numberRow][numberColumn] = ' ';
                    grid[numberRow - 1][numberColumn] = enteredNumber;
                    moveCounter += 1;
                }
                else {
                    if (grid[numberRow - 2][numberColumn] == ' ') {
                        grid[numberRow - 2][numberColumn] = grid[numberRow - 1][numberColumn];
                        grid[numberRow][numberColumn] = ' ';
                        grid[numberRow - 1][numberColumn] = enteredNumber;
                        moveCounter += 2;
                    }
                    else {
                        System.out.println("Invalid move. Spaces filled");
                    }
                }
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Invalid Move. Out of bounds, try again");
            }
        }
		else if(userMove.equals("d")){ //moves right
           try {
                if (grid[numberRow][numberColumn + 1] == ' ') {
                    grid[numberRow][numberColumn] = ' ';
                    grid[numberRow][numberColumn + 1] = enteredNumber;
                    moveCounter += 1;
                }
                else {
                    if (grid[numberRow][numberColumn + 2] == ' ') {
                        grid[numberRow][numberColumn + 2] = grid[numberRow][numberColumn + 1];
                        grid[numberRow][numberColumn] = ' ';
                        grid[numberRow][numberColumn + 1] = enteredNumber;
                        moveCounter += 2;
                    }
                    else {
                        System.out.println("Invalid move. Spaces filled");
                    }
                }
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Invalid Move. Out of bounds, try again");
            }
        }
        else if(userMove.equals("a")){ //moves left
            try {
                if (grid[numberRow][numberColumn - 1] == ' ') {
                    grid[numberRow][numberColumn] = ' ';
                    grid[numberRow][numberColumn - 1] = enteredNumber;
                    moveCounter += 1;
                }
                else {
                    if (grid[numberRow][numberColumn - 2] == ' ') {
                        grid[numberRow][numberColumn - 2] = grid[numberRow][numberColumn - 1];
                        grid[numberRow][numberColumn] = ' ';
                        grid[numberRow][numberColumn - 1] = enteredNumber;
                        moveCounter += 2;
                    }
                    else {
                        System.out.println("Invalid move. Spaces filled");
                    }
                }
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Invalid Move. Out of bounds, try again");
            }
        }
		else{
			System.out.println("Invalid move");
		}
    }
}
