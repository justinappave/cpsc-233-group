/** This method calls and controls the three different types of games you can play. It extends the 
GameWon class, which is used to check if the game has been won
*/

package gridgameplay;

import java.util.Scanner;
import highscores.*;

public class GameplayOld extends GameWon{
    private int moveCount = 0;
    private long timeTaken = 0;
    
    public void increaseMoveCount() { //method which increments the moveCount variable for highscores
        moveCount ++;
    }
    
    public int getMoveCount() { //method which returns the moveCount
        return moveCount;
    }
    
    public void setTimeTaken(long newTimeTaken) { //method which sets the timeTaken to the appropriate amount
        timeTaken = newTimeTaken;
    }
    
    public int getTimeTaken() { //method which returns the timeTaken variable
        int intTimeTaken = (int) timeTaken;
        return intTimeTaken;
    }
    
    /**This method is for controlling the menu's which are accociated with timeplay.
        It calls the freeplay method with specific values. The timer mode is always a 3x3 grid
        */
    public boolean timeplay(int difficulty) {
        boolean winner = false;
        Grid game = new Grid();
        long startTime = System.currentTimeMillis();
        long amountTime;
        int timeTaken = 0;
        if (difficulty == 1) {
            amountTime = startTime + 300*1000;
        }
        else if (difficulty == 2) {
            amountTime = startTime + 120*1000;
        }
        else {
            amountTime = startTime + 60*1000;
        }
        //while ((System.currentTimeMillis() < amountTime) && (winner == false)) {
            winner = freeplay(3, amountTime);
        //}
        if (winner == false) {
            setTimeTaken(0);
        }
        return winner;
    }
    
    /** This method is for running a base game, it enters a while loop which only stops when either
        the player has won the game or has decided to quit
        */
    public boolean freeplay(int size, long endTime) {
        Grid game = new Grid();
        game.setSize(size);
        String[][] grid = game.makeGrid();
        game.displayGrid(moveCount);
        int rowColumnNum = game.getSize();
            
        boolean winner = checkGame(grid, rowColumnNum);
        boolean wantQuit = false;
            
        while ((winner == false) && (wantQuit == false)) {
            long currentTime = System.currentTimeMillis();
            long timeTakenSec = 0;
            if ((currentTime > endTime) && (endTime != -1)) {
                System.out.println("Out of time!");
                break;
            }
            wantQuit = game.makeMove(grid);
            if (wantQuit == false) {
                increaseMoveCount();
                game.displayGrid(moveCount);
                winner = checkGame(grid, rowColumnNum);
                currentTime = System.currentTimeMillis();
                timeTakenSec = (endTime - currentTime)/1000;
                setTimeTaken(timeTakenSec);
            }
        }
        if ((winner == true) && (endTime == -1)) {
            addNewHighscore(1);
        }
        else if (winner == true) {
            addNewHighscore(2);
        }
        return winner;
    }
    
    /**This method controls the quickplay mode, in quickplay the options are set for you.
        It enters a while loop which only ends when the player has won or decides to quit.
        */
    public boolean quickplay() {
        Grid game = new Grid();
        game.setSize(3);
        String[][] grid = game.makeGrid();
        game.displayGrid(moveCount);
        int rowColumnNum = game.getSize();
            
        boolean winner = checkGame(grid, rowColumnNum);
        boolean wantQuit = false;
            
        while ((winner == false) && (wantQuit == false)) {
            wantQuit = game.makeMove(grid);
            if (wantQuit == false) {
                increaseMoveCount();
                game.displayGrid(moveCount);
                winner = checkGame(grid, rowColumnNum);
            }
        }
        if (winner == true) {
            addNewHighscore(1);
        }
        return winner;
    }
    
    
    //This method is called when the player wins any game, it adds the score the player got to the leaderboard file
    public void addNewHighscore(int state) {
        String name = getName();
        int moveCount = getMoveCount();
        int time = getTimeTaken();
        HighscoreManager hm = new HighscoreManager();
        if (state == 1) {
            hm.addScore(name, moveCount, 1);
        }
        else {
            hm.addScore(name, time, 2);
        }
    }
    
    
    //This method gets the players name which is used for leaderboard scores.
    public String getName(){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter name for leaderboard: ");
        String name = keyboard.nextLine();
        return name;
    }
}