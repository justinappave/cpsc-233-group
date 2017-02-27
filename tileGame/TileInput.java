import java.util.Scanner;

public class TileInput{
	
	//obtain values of x and y from grid class
	public int getMove(int x, int y){
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter move (W,A,S,D): ");
		String input = keyboard.next();
		if(input.equals("w")){
			y = y + 1;
			return y;
		}
		else if(input.equals("s")){
			y = y - 1;
			return y
		}
		else if(input.equals("d")){
			x = x + 1;
			return x;
		}
		else if(input.equals("a")){
			x = x - 1;
			return x;
		}
		else{
			System.out.println("Invalid move!");
		}
	}
	
	public int validInput(x, y){
		
	}
	
	public static void main(String[] args){
		TileInput a = new TileInput();
		a.getMove(0, 1);
		System.out.println("X position: " + a.newX);
		System.out.println("Y position: " + a.newY);
	}
}