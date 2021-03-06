//import tilePuzzle.*;

public class Driver {
    public static void main(String[] args) {
        
        boolean won;
        boolean keepPlaying = true;
        int moveCount;
        Menu gameMenu = new Menu();
        Gameplay gameplay = new Gameplay();
        //HighscoreManager hm = new HighscoreManager();
        
        while (keepPlaying == true) {
            int quickplay = gameMenu.quickPlay();
            if (quickplay == 1) {
                gameplay.quickplay();
                keepPlaying = gameMenu.playAgain();
            }
            
            else {
                int gameMode = gameMenu.mainMenu();
                if (gameMode == 1) { //TIME MODE
                    int difficulty = gameMenu.getTimerDifficulty();
                    won = gameplay.timeplay(difficulty);
                    if (won == true) {
                        String playerName = gameMenu.getName();
                        int timeTaken = gameplay.getTimeTaken();
                        //hm.addScore(playerName, timeTaken, 2);
                    }
                    keepPlaying = gameMenu.playAgain();
                }
                else if (gameMode == 2) { //FREEPLAY MODE
                    int size = gameMenu.getFreeplayDifficulty();
                    won = gameplay.freeplay(size, -1);
                    
                    if (won == true) {
                        String playerName = gameMenu.getName();
                        moveCount = gameplay.getMoveCount();
                        //hm.addScore(playerName, moveCount, 1);
                    }
                    keepPlaying = gameMenu.playAgain();
                }
                else if (gameMode == 3) { //CHECK LEADERBOARDS
                    System.out.println("Leaderboards here");
                    //int highscoreType = gameMenu.getHighscoreChoice();
                    /**if (highscoreType == 1) {
                        //print freeplay highscores
                    }
                    else if (highscoreType == 2) {
                    //print timeplay highscores
                    }
                    //System.out.print(highscore.getHighscoreString());
                    */
                }
            }
        }
    }
}