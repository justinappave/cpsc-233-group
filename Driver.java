public class Driver {
    public static void main(String[] args) {
        boolean won;
        boolean keepPlaying = true;
        int moveCount;
        Menu gameMenu = new Menu();
        Gameplay gameplay = new Gameplay();
        Leaderboard leaderboard = new Leaderboard();
        
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
                    
                    keepPlaying = gameMenu.playAgain();
                }
                else if (gameMode == 2) {
                    int size = gameMenu.getFreeplayDifficulty();
                    won = gameplay.freeplay(size, -1);
                    
                    if (won == true) {
                        String playerName = gameMenu.getName();
                        moveCount = gameplay.getMoveCount();
                        //leaderboard.addNewHighscore();
                    }
                    keepPlaying = gameMenu.playAgain();
                }
                else if (gameMode == 3) {
                    //leaderboard.displayHighscores
                    System.out.println("Leaderboards here");
                }
            }
        }
    }
}