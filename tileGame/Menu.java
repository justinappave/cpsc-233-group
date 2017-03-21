import java.util.Scanner;
import java.util.InputMismatchException;
//import tilePuzzle.*;

public class Menu {
	private int newSelect = 0;
	private int newTimer = 0;

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
			System.out.print("Invalid. Enter [1] Quickplay or [2] Menu.");
		}
		return playSelect;
	}
	public int mainMenu(){
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Select mode: ");
		System.out.println("1. Timer");
		System.out.println("2. Freeplay");
		System.out.println("3. Leaderboards");
        boolean validInput = false;
        int modeSelect = 0;
        while (!validInput) {
            modeSelect = keyboard.nextInt();
            if (modeSelect == 1) {
                System.out.println("Starting Timer...");
                validInput = true;
            }
            else if (modeSelect == 2) {
                System.out.println("Starting Freeplay...");
                validInput = true;
            }
            else if (modeSelect == 3) {
                System.out.println("Checking leaderboards...");
                validInput = true;
            }
            else {
                System.out.print("Invalid. Select 1, 2, or 3:");
            }
        }
		return modeSelect;
	}
    
    public int leaderboards() {
        Scanner keyboard = new Scanner(System.in);
		System.out.println("Select mode: ");
		System.out.println("1. Timer Leaderboards");
		System.out.println("2. Freeplay Leaderboards");
        boolean validInput = false;
        int modeSelect = 0;
        while (!validInput) {
            modeSelect = keyboard.nextInt();
            if (modeSelect == 1) {
                System.out.println("Loading Timer Leaderboards...");
                validInput = true;
            }
            else if (modeSelect == 2) {
                System.out.println("Loading Freeplay Leaderboards...");
                validInput = true;
            }
            else {
                System.out.print("Invalid. Select 1 or 2: ");
            }
        }
        return modeSelect;
    }
    
	public int getTimerDifficulty(){
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Select difficulty: ");
		System.out.println("1. Easy (5:00)");
		System.out.println("2. Medium (3:00)");
		System.out.println("3. Hard (1:00)");
        boolean validInput = false;
        int diffSelect = 0;
        while (validInput == false) {
            diffSelect = keyboard.nextInt();
            if(diffSelect == 1){
                System.out.println("Starting easy difficulty...");
                validInput = true;
            }
            else if(diffSelect == 2){
                System.out.println("Starting medium difficulty...");
                validInput = true;
            }
            else if(diffSelect == 3){
                System.out.println("Starting hard difficulty...");
                validInput = true;
            }
            else{
                System.out.println("Invalid. Select 1,2, or 3.");
            }
        }
        return diffSelect;
	}
    
    public int getFreeplayDifficulty() {
        Scanner keyboard = new Scanner(System.in);
		System.out.println("Select difficulty: ");
		System.out.println("1. Easy (3x3)");
		System.out.println("2. Medium (4x4)");
		System.out.println("3. Hard (5x5)");
        boolean validInput = false;
		int diffSelect = 0;
        int size = 0;
        while (validInput == false) {
            diffSelect = keyboard.nextInt();
            if(diffSelect == 1){
                System.out.println("Starting easy difficulty...");
                size = 3;
                validInput = true;
            }
            else if(diffSelect == 2){
                System.out.println("Starting medium difficulty...");
                size = 4;
                validInput = true;
            }
            else if(diffSelect == 3){
                System.out.println("Starting hard difficulty...");
                size = 5;
                validInput = true;
            }
            else{
                System.out.println("Invalid. Select 1,2, or 3.");
                size = 0;
            }
        }
        return size;
    }
    
    public String getName(){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = keyboard.nextLine();
        return name;
    }
    
    public boolean playAgain() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Press \"e\" again to Quit game");
        System.out.println("Or press anything else to play another game");
        String choice = keyboard.nextLine();
        boolean again = true;
        if (choice.equals("e")) {
            again = false;
        }
        return again;
    }
}
