import java.util.Scanner;

public class TileGame
{
	static char[][] startConfig = 
	{
		{'1','3','8'},
		{' ','4','7'},
		{'6','5','2'}
	};
	static char[][] possibleXWin = 
	{
		{'1','2','3'},
		{'4','5','6'},
		{'7','8',' '}
	};
	
	public static void main(String[] args)
	{
	int numberRow = 10;
	int numberColumn = 10;
	int blankRow = 11;
	int blankColumn = 11;
	
	char [][]grid = startConfig;
	while(startConfig != possibleXWin)
	{
		//creates the grid with '|' between each number
		for (int row = 0; row < 3; row++)
		{
			System.out.print("|");
			for (int column = 0; column < 3; column++)
			{
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
		for(int userRow = 0; userRow < grid.length; userRow++)
		{
			for(int userColumn = 0; userColumn < grid.length; userColumn++)
			{
				if(grid[userRow][userColumn] == enteredNumber)
				{
					numberRow = userRow;
					numberColumn = userColumn;
				}
				if(grid[userRow][userColumn] == ' ')
				{
					blankRow = userRow;
					blankColumn = userColumn;
				}
			}
			
		}
		
		if(userMove.equals("down"))
		{
			grid[numberRow][numberColumn] = ' ';
			grid[numberRow + 1][numberColumn] = enteredNumber;
		}
		else if(userMove.equals("up"))
		{
			grid[numberRow][numberColumn] = ' ';
			grid[numberRow - 1][numberColumn] = enteredNumber;
		}
		else if(userMove.equals("right"))
		{
			grid[numberRow][numberColumn] = ' ';
			grid[numberRow][numberColumn + 1] = enteredNumber;
		}
		else if(userMove.equals("left"))
		{
			grid[numberRow][numberColumn] = ' ';
			grid[numberRow][numberColumn - 1] = enteredNumber;
		}
		else
		{
			System.out.println("Invalid move");
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