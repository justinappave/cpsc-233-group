public class Driver {
    public static void main(String[] args) {
        boolean won;
        Menu gameMenu = new Menu();
        Gameplay gameplay = new Gameplay();
        //Leaderboard leaderboard = new Leaderboard();
        
        int quickplay = gameMenu.quickPlay();
        if (quickplay == 1) {
            gameplay.quickplay();
        }
        
        else {
            int gameMode = gameMenu.mainMenu();
            if (gameMode == 1) { //TIME MODE
                int difficulty = gameMenu.getTimerDifficulty();
                won = gameplay.timeplay(difficulty);
            }
            else if (gameMode == 2) {
                int size = gameMenu.getFreeplayDifficulty();
                won = gameplay.freeplay(size, -1);
                
            }
        }
        /**else {
            int gameMode = gameMenu.mainMenu();
            if (gameMode == 1) {
                int difficulty = gameMenu.getTimerDifficulty();
                long startTime = System.currentTimeMillis();
                long amountTime;
                if (difficulty == 1) {
                    amountTime = startTime + 300*1000;
                }
                else if (difficulty == 2) {
                    amountTime = startTime + 180*1000;
                }
                else {
                    amountTime = startTime + 60*1000;
                }
                while (System.currentTimeMillis() < amountTime) {
                    //gameplay goes here
                }
            }
            else if (gameMode == 2) {
                int difficulty = gameMenu.getNormalDifficulty();
                gameplay = true;
            }
            /**else if (gameMode == 3) { // displays the leaderboard
                int board = leaderboard.chooseBoard();
                if (board = 0) { // displays the move leaderboard
                    leaderboard.displayMoveBoard();
                }
                else if (board == 1) { // displays the time leaderboard
                    leaderboard.displayTimeBoard();
                }
                else {
                    System.out.println("Leaderboard error");
                }
            }
            
        }*/
        /**
        if (gameplay == true) {
            gameMenu.getName();
            GameWon checker = new GameWon();
            Grid gameGrid = new Grid();
            gameGrid.setSize(3);
            if (quickplayOn == false) {
                gameGrid.getNewSize();
                int size = gameGrid.getSize();
            }
            String[][] grid = gameGrid.makeGrid();
            gameGrid.displayGrid();
            int rowColumnNum = gameGrid.getSize();
        
            GameWon gameWon = new GameWon();
            
            boolean winner = gameWon.checkGame(grid, rowColumnNum);
            
            while (winner == false) {
                gameGrid.makeMove(grid);
                gameGrid.displayGrid();
                winner = gameWon.checkGame(grid, rowColumnNum);
            }
        }*/
    }
}