public class Driver {
    public static void main(String[] args) {
        
        Menu gameMenu = new Menu();
        
        //Leaderboard leaderboard = new Leaderboard();
        
        int gameMode = gameMenu.mainMenu();
        
        if (gameMode == 1) {
            gameMenu.getName();
            gameMenu.getDifficulty();
            gameMode = 2;
        }
        
        else if (gameMode == 2) { //mode for playing game
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
            gameMode = 0;
        }
        /**
        else if (gameMode == 3) { // displays the leaderboard
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
}