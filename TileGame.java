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
		
		//finds what row and column the number the user entered is at
		for(int i=0; i < grid.length; i++)
		{
			for(int j = 0; j < grid.length; j++)
			{
				if(grid[i][j] == enteredNumber)
				{
					numberRow = i;
					numberColumn = j;
				}
			}
			
		}
		System.out.println(numberRow);
		System.out.println(numberColumn);
	}
	}
}