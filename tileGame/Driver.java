import Leaderboards.*;

public class Driver {
    public static void main(String[] args) {
        boolean won;
        boolean keepPlaying = true;
        int moveCount;
        Menu gameMenu = new Menu();
        Gameplay gameplay = new Gameplay();
        HighscoreManager hm = new HighscoreManager();
        
        while (keepPlaying == true) {
            int quickplay = gameMenu.quickPlay();
            if (quickplay == 1) {
                won = gameplay.quickplay();
                if (won == true) {
                    String playerName = gameMenu.getName();
                    moveCount = gameplay.getMoveCount();
                    hm.addScore(playerName, moveCount, 1);
                }
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
                        hm.addScore(playerName, timeTaken, 2);
                    }
                    keepPlaying = gameMenu.playAgain();
                }
                else if (gameMode == 2) { //FREEPLAY MODE
                    int size = gameMenu.getFreeplayDifficulty();
                    won = gameplay.freeplay(size, -1);
                    
                    if (won == true) {
                        String playerName = gameMenu.getName();
                        moveCount = gameplay.getMoveCount();
                        hm.addScore(playerName, moveCount, 1);
                    }
                    keepPlaying = gameMenu.playAgain();
                }
                else if (gameMode == 3) { //CHECK LEADERBOARDS
                    int leaderboardChoice = gameMenu.leaderboards();
                    if (leaderboardChoice == 1) {
                        System.out.print(hm.readHighscore(2));
                    }
                    else {
                        System.out.print(hm.readHighscore(1));
                    }
                }
            }
        }
    }
}