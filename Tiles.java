import java.util.Scanner;

public class Tiles{
  public static void main(String[] args){
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Enter your player name: ");
    String playerName = keyboard.nextLine();
    int playerLength = playerName.length();
    if(playerLength >= 10){
      System.out.println("Error. Too long!");
    }
  }
}
