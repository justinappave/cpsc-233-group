import java.util.Scanner;

public class TileInput{
	int newX = 0;
	int newY = 0;
	
	//obtain values of x and y from grid class
	int[] getMove(int x, int y){
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter move (W,A,S,D): ");
		String input = keyboard.next();
		if(input.equals("w")){
			newY = y + 1;
		}
		else if(input.equals("s")){
			newY = y - 1;
		}
		else if(input.equals("d")){
			newX = x + 1;
		}
		else if(input.equals("a")){
			newX = x - 1;
		}
		else{
			System.out.println("Invalid move!");
		}
		return new int[] {x, y};
	}
	
	public static void main(String[] args){
		TileInput a = new TileInput();
		a.getMove(0, 1);
		System.out.println("X position: " + a.newX);
		System.out.println("Y position: " + a.newY);
	}
}