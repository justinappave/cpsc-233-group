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

	 
	public void makeGrid(){
		for (int row = 0; row < 3; row++){
				System.out.print("|");
				for (int column = 0; column < 3; column++){
					System.out.print(grid[row][column] + "|");
			}
			System.out.println();
		}
	}
	
	public void setGridDiff(int difficultySelect){

		if(difficultySelect == 1){
			grid = easyConfig;
		}
		else if(difficultySelect == 2){
			grid = mediumConfig;
		}
		
	}
	
	public static void main(String[] args){
		Scanner keyboard = new Scanner (System.in);
		System.out.println("set difficulty: ");
		System.out.println("1. Easy");
		System.out.println("2. Medium"); 
		int select = keyboard.nextInt();
		Grid grid1 = new Grid();
		grid1.setGridDiff(select);
		grid1.makeGrid();
		
	}
}
