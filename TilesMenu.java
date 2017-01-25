import java.util.Scanner;

public class Tiles{
  public static void main(String[] args){
    Scanner keyboard = new Scanner(System.in);
    int playerLength = 100;
    while(playerLength >= 10){
		System.out.print("Enter your player name: ");
    	String playerName = keyboard.nextLine();
    	playerLength = playerName.length();
    	if(playerLength >= 10){  	
    		System.out.println("Error. Too long!");}}
    
    System.out.println("Select mode: ");
    System.out.println("1. Race Time Mode");
    System.out.println("2. Hi-score Mode");
    System.out.println("3. Leaderboards");
    int modeSelect = keyboard.nextInt();
    
    if(modeSelect == 1){
    	System.out.println("Select Difficulty:");
    	System.out.println("1. Easy (6:00)");
    	System.out.println("2. Medium (4:00)");
    	System.out.println("3. Hard (2:00)");
    	int difficultySelect = keyboard.nextInt();
    	if(difficultySelect == 1){
			System.out.println("Starting Easy difficulty...");}
		else if(difficultySelect == 2){
			System.out.println("Starting Medium difficulty...");}
		else if(difficultySelect == 3){
			System.out.println("Starting Hard difficulty...");}    	
    	}
    else if(modeSelect == 2){
    	System.out.println("Starting Hi-score mode...");}
  }
}
