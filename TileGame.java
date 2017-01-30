import java.util.Scanner;

public class TileGame{
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
	
	public static void main(String[] args){
		boolean mainLoop = false;
		boolean difficultyLoop = false;
		boolean modeLoop = false;
		boolean DEBUG = false;
		String playerName = "";
		char [][]grid = easyConfig;
		int playerLength = 100;
		int numberRow = 21;
		int numberColumn = 21;
		int blankRow = 42;
		int blankColumn = 42;
		
		/*gets name of player. If user name is longer
		than 10 then program will re-prompt user to enter name*/
		Scanner keyboard = new Scanner(System.in);
		while(playerLength >= 10){
			System.out.print("Enter your player name: ");
			playerName = keyboard.nextLine();
			playerLength = playerName.length();
			if(playerLength >= 10){  	
				System.out.println("Error. Too long!");}
			}
		
		//prompts uer for mode and difficulty. Will re-prompt if user enters invalid option
		while(!difficultyLoop){
			System.out.println("Select mode: ");
			System.out.println("1. Play mode");
			int modeSelect = keyboard.nextInt();
			if(modeSelect == 1){
				while(!modeLoop){
						System.out.println("Select Difficulty:");
						System.out.println("1. Easy");
						System.out.println("2. Medium");
						int difficultySelect = keyboard.nextInt();
						if(difficultySelect == 1){
							System.out.println("Starting Easy difficulty...");
							grid = easyConfig;
							modeLoop = true;
							difficultyLoop = true;
						}
						else if(difficultySelect == 2){
							System.out.println("Starting Medium difficulty...");
							grid = mediumConfig;
							modeLoop = true;
							difficultyLoop = true;
						}
						else{
							System.out.println("Invalid difficulty");
						}
					}
				}
			else{
				System.out.println("Invalid mode");
			}
		}
		
		System.out.println("Use 'd' to move down, 'u' to move up, 'l' to move left and 'r' to move right!");
		while(!mainLoop){
			
			//creates the grid with '|' between each number
			for (int row = 0; row < 3; row++){
				System.out.print("|");
				for (int column = 0; column < 3; column++){
					System.out.print(grid[row][column] + "|");
				}
				System.out.println();
			}
			
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
                try { // makes sure user move is in playing field bounds
                    if (grid[numberRow + 1][numberColumn] == ' ') { // case where adjacent space is empty
                        grid[numberRow][numberColumn] = ' ';
                        grid[numberRow + 1][numberColumn] = enteredNumber;
                    }
                    else { //case where adjacent space is not empty, allows for moving two pieces at once
                        grid[numberRow + 2][numberColumn] = grid[numberRow + 1][numberColumn];
                        grid[numberRow][numberColumn] = ' ';
                        grid[numberRow + 1][numberColumn] = enteredNumber;
                    }
                }
                catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Invalid Move. Out of bounds, try again");
                }
			}
			else if(userMove.equals("u")){
                try {
                    if (grid[numberRow - 1][numberColumn] == ' ') {
                        grid[numberRow][numberColumn] = ' ';
                        grid[numberRow - 1][numberColumn] = enteredNumber;
                    }
                    else {
                        grid[numberRow - 2][numberColumn] = grid[numberRow - 1][numberColumn];
                        grid[numberRow][numberColumn] = ' ';
                        grid[numberRow - 1][numberColumn] = enteredNumber;
                    }
                }
                catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Invalid Move. Out of bounds, try again");
                }
			}
			else if(userMove.equals("r")){
                try {
                    if (grid[numberRow][numberColumn + 1] == ' ') {
                        grid[numberRow][numberColumn] = ' ';
                        grid[numberRow][numberColumn + 1] = enteredNumber;
                    }
                    else {
                        grid[numberRow][numberColumn + 2] = grid[numberRow][numberColumn + 1];
                        grid[numberRow][numberColumn] = ' ';
                        grid[numberRow][numberColumn + 1] = enteredNumber;
                    }
                }
                catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Invalid Move. Out of bounds, try again");
                }
			}
			else if(userMove.equals("l")){
                try {
                    if (grid[numberRow][numberColumn - 1] == ' ') {
                        grid[numberRow][numberColumn] = ' ';
                        grid[numberRow][numberColumn - 1] = enteredNumber;
                    }
                    else {
                        grid[numberRow][numberColumn - 2] = grid[numberRow][numberColumn - 1];
                        grid[numberRow][numberColumn] = ' ';
                        grid[numberRow][numberColumn - 1] = enteredNumber;
                    }
                }
                catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Invalid Move. Out of bounds, try again");
                }
			}
			else if(userMove.equals("boohbah")){
				mainLoop = true;
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
											System.out.println("You win, congratulations " + playerName + "!");
											mainLoop = true;
										}
									}
								}
							}
						}
					}
				}
			}
			
			//debugging values
			if(DEBUG == true){
			System.out.println(numberRow);
			System.out.println(numberColumn);
			System.out.println(blankRow);
			System.out.println(blankColumn);
			}
		}
	}
}
