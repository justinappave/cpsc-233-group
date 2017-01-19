import java.util.Scanner;
import java.util.Random;

public class MyRandom{
	public static void main(String[] args){
		//Prompts the user to guess the randomly generated number between 0 and 9
		int randomNumber = new Random().nextInt(10);
		Scanner keyboard = new Scanner(System.in);
		System.out.println(randomNumber);
		System.out.println("I'm thinking of a number between 0 and 9");
		String number = keyboard.nextLine();
		int digit = number.length();
		int guessNum = Integer.parseInt(number);
		
		//If the length of the entered number is not equal to length 1 then "Invalid guess" will show up
		if(digit != 1){
		System.out.print("Invalid guess!");}
		else{
		//Shows the corresponding message depending if the entered number is correct, higher or lower
			if(guessNum == randomNumber){
				System.out.print("Correct!");
			}else if(guessNum > randomNumber){
				System.out.print("Too high!");
			}else if(guessNum < randomNumber){
				System.out.print("Too low!");
			}
		}
	}
}
