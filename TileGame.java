import java.util.Scanner;

public class TileGame{
	static char[][] startConfig = {
		{'1',' ',' '},
		{' ',' ',' '},
		{' ',' ',' '}
	};
	static char[][] possibleXWin = {
		{' ','1',' '},
		{' ',' ',' '},
		{' ',' ',' '}
	};
	
	public static void main(String[] args){
	
	char[][] grid = startConfig;
	while(startConfig != possibleXWin){
		for (int row = 0; row < 3; row++) {
				System.out.print("|");
				for (int column = 0; column < 3; column++) {
					System.out.print(grid[row][column] + "|");}
				System.out.println();}
		{Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter row: ");
		int enteredRow = keyboard.nextInt();
		System.out.print("Enter column: ");
		int enteredColumn = keyboard.nextInt();}}
	}
}