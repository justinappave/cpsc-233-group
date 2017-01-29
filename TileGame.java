import java.util.Scanner;

public class TileGame{
	static char[][] startConfig = {
		{'1','2','3'},
		{'4','5','6'},
		{'7',' ','8'}
	};
	
	public static void main(String[] args){
		boolean loop = false;
		int numberRow = 21;
		int numberColumn = 21;
		int blankRow = 42;
		int blankColumn = 42;
		char [][]grid = startConfig;
		while(!loop){
			
			//creates the grid with '|' between each number
			for (int row = 0; row < 3; row++){
				System.out.print("|");
				for (int column = 0; column < 3; column++){
					System.out.print(grid[row][column] + "|");
				}
				System.out.println();
			}
			
			Scanner keyboard = new Scanner(System.in);
			System.out.print("Select number to move: ");
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
					if(grid[userRow][userColumn] == ' '){
						blankRow = userRow;
						blankColumn = userColumn;
					}
				}
			}
			
			/*checks where the user wants to move and adds or subtracts from the 
			appropriate row or column and places the number the user selected there*/
			if(userMove.equals("d")){
				grid[numberRow][numberColumn] = ' ';
				grid[numberRow + 1][numberColumn] = enteredNumber;
			}
			else if(userMove.equals("u")){
				grid[numberRow][numberColumn] = ' ';
				grid[numberRow - 1][numberColumn] = enteredNumber;
			}
			else if(userMove.equals("r")){
				grid[numberRow][numberColumn] = ' ';
				grid[numberRow][numberColumn + 1] = enteredNumber;
			}
			else if(userMove.equals("l")){
				grid[numberRow][numberColumn] = ' ';
				grid[numberRow][numberColumn - 1] = enteredNumber;
			}
			else if(userMove.equals("boohbah")){
				loop = true;
			}
			else{
				System.out.println("Invalid move");
			}
			
			//checks if each value is in the correct spot
			if(grid[0][0] == '1'){
				if(grid[0][1] == '2'){
					if(grid[0][2] == '3'){
						if(grid[1][0] == '4'){
							if(grid[1][1] == '5'){
								if(grid[1][2] == '6'){
									if(grid[2][0] == '7'){
										if(grid[2][1] == '8'){
											System.out.println("You win!");
											loop = true;
										}
									}
								}
							}
						}
					}
				}
			}
			
			/*debugging values:
			System.out.println(numberRow);
			System.out.println(numberColumn);
			System.out.println(blankRow);
			System.out.println(blankColumn);
			*/
			
		}
	}
}