/** This method calls and controls the three different types of games you can play. It extends the 
GameWon class, which is used to check if the game has been won
*/

package gridgameplay;

import java.util.Scanner;
import highscores.*;

public class Gameplay {
    private int moveCount = 0;
    private long timeTaken = 0;
    
    public void increaseMoveCount() { //method which increments the moveCount variable for highscores
        moveCount ++;
    }
    
    public int getMoveCount() { //method which returns the moveCount
        return moveCount;
    }
    
    public void setTimeTaken() { //method which sets the timeTaken to the appropriate amount
        return;
    }
    
    public int getTimeTaken() { //method which returns the timeTaken variable
        int intTimeTaken = (int) timeTaken;
        return intTimeTaken;
    }
    
    public boolean checkTime() {
        return true;
    }
    
    public boolean Play (int size) {
        Grid game = new Grid();
        game.setSize(size);
        String[][] grid = game.makeGrid();
        game.displayGrid(moveCount);
        int rowColumnNum = game.getSize();
            
        boolean winner = checkGame(grid, rowColumnNum);
        boolean wantQuit = false;
        boolean haveTime = true;
            
        while ((winner == false) && (wantQuit == false) && (haveTime == true)) {
            haveTime = checkTime();
            wantQuit = game.makeMove(grid);
            if (wantQuit == false) {
                increaseMoveCount();
                game.displayGrid(moveCount);
                winner = checkGame(grid, rowColumnNum);
                setTimeTaken();
            }
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
    
    public boolean checkGame(String[][] grid, int rowColumnNum) {
        boolean won = false;
        int counter = 1;
        for (int row = 0; row < rowColumnNum; row++) {
            for (int column = 0; column < rowColumnNum; column++) {
                String withSpaces = grid[row][column];
                String noSpaces = withSpaces.trim();
                String tileNumStr = String.valueOf(noSpaces);
                String counterStr = String.valueOf(counter);
                
                if (counter == (rowColumnNum*rowColumnNum)) { //game is only won if the counter variable hits the grid size
                    won = true;
                }
                if (tileNumStr.equals(counterStr)) { 
                    counter += 1;
                }
            }
        }
    if (won == true) {
        System.out.println("CONGRATULATINOS!");
    }
    return won;
    }
}