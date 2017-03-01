/* This class gets the move from the user and returns it to the grid class.
If the move is invalid, it will keep prompting the user for a valid move
*/

import java.util.Scanner;

public class TileInput{
	private String move = "";
	private boolean loop = false;

	public String getMove(){
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter move (W,A,S,D): ");
		String input = keyboard.next();
		//continues to loop until a valid input is found
		while(!loop){
			if(input.equals("w")){
				move = "w";
				loop = true;
			}
			else if(input.equals("s")){
				move = "s";
				loop = true;
			}
			else if(input.equals("d")){
				move = "d";
				loop = true;
			}
			else if(input.equals("a")){
				move = "a";
				loop = true;
			}
			else{
				System.out.println("Invalid move!");
			}
		}
		//returns the move to the Grid class
		return move;
	}
}
