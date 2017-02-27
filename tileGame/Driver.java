public class Driver {
    private int difficulty;
    
    public void setDifficulty(int newDifficulty) {
        difficulty = newDifficulty;
    }
    
    public int getDifficulty() {
        return difficulty;
    }
    
    
    public static void main(String[] args) {
        boolean gameplay = false;
        Menu gameMenu = new Menu();
        
        //Leaderboard leaderboard = new Leaderboard();
        
        int quickplay = gameMenu.quickPlay();
        if (quickplay == 1) {
            gameplay = true;
        }
        else {
            int gameMode = gameMenu.mainMenu();
            if (gameMode == 1) {
                int difficulty = gameMenu.getTimerDifficulty();
                gameplay = true;
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
            */
        }
        if (gameplay == true) {
            gameMenu.getName();
            GameWon checker = new GameWon();
            Grid gameGrid = new Grid();
            char[][] grid = gameGrid.makeGrid();
            gameGrid.displayGrid();
            int rowColumnNum = gameGrid.getBounds();
        
            GameWon gameWon = new GameWon();
            
            boolean winner = gameWon.checkGame(grid, rowColumnNum);
            
            while (winner == false) {
                gameGrid.makeMove();
                gameGrid.displayGrid();
                winner = gameWon.checkGame(grid, rowColumnNum);
            }
        }
    }
    /**
    public void gameplay() {
        Menu gameMenu = new Menu();
        gameMenu.getName();
        GameWon checker = new GameWon();
        Grid gameGrid = new Grid();
        char[][] grid = gameGrid.makeGrid();
        gameGrid.displayGrid();
        int rowColumnNum = gameGrid.getBounds();
        
        GameWon gameWon = new GameWon();
            
        boolean winner = gameWon.checkGame(grid, rowColumnNum);
            
        while (winner == false) {
            gameGrid.makeMove();
            gameGrid.displayGrid();
            winner = gameWon.checkGame(grid, rowColumnNum);
        }
    }*/
}