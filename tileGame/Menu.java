/* This class is the main menu class. Prompts the user for quick play or
to pick a difficulty. Leaderboard option and freeplay
*/

import java.util.Scanner;

public class Menu{
	private int newSelect = 0;
	private int newTimer = 0;

	//Quickplay GameMode
	public int quickPlay(){
		Scanner keyboard = new Scanner(System.in);
		System.out.println("[1] Quickplay or [2] Menu?");
		int playSelect = keyboard.nextInt();
		if(playSelect == 1){
			System.out.println("Starting quickplay...");
		}
		else if(playSelect == 2){
			System.out.println("Moving to main menu...");
		}
		else{
			System.out.print("Invalid. Enter [1] Quickpay or [2] Menu.");
		}
		return playSelect;
	}

	//Main Menu
	public int mainMenu(){
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Select mode: ");
		System.out.println("1. Timer");
		System.out.println("2. Freeplay");
		System.out.println("3. Leaderboards");
		int modeSelect = keyboard.nextInt();
		if(modeSelect == 1){
			System.out.println("Starting Timer...");
		}
		else if(modeSelect == 2){
			System.out.println("Starting Freeplay...");
		}
		else if(modeSelect == 3){
			System.out.println("Checking leaderboards...");
		}
		else{
			System.out.print("Invalid. Select 1,2, or 3.");
		}
		return modeSelect;
	}

	//Difficulty selection for Timer Mode
	public int getTimerDifficulty(){
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Select difficulty: ");
		System.out.println("1. Easy (5:00)");
		System.out.println("2. Medium (3:00)");
		System.out.println("3. Hard (1:00)");
		int diffSelect = keyboard.nextInt();
		if(diffSelect == 1){
			System.out.println("Starting easy difficulty...");
		}
		else if(diffSelect == 2){
			System.out.println("Starting medium difficulty...");
		}
		else if(diffSelect == 3){
			System.out.println("Starting hard difficulty...");
		}
		else{
			System.out.println("Invalid. Select 1,2, or 3.");
		}
        return diffSelect;
	}

		//Gets Normal Mode difficulty
    public int getNormalDifficulty() {
        return 1;
    }

		//Gets Player name
    public String getName(){
        String name = "H";
        return name;
    }

	/**public static void main(String[] args){
		Menu game = new Menu();
		game.quickPlay(0);
		if(game.newSelect == 2){
			game.mainMenu(0);
			if(game.newTimer == 1){
				game.getDifficulty(0);
			}
		}
	}
    */
}
