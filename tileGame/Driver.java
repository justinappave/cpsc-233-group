/*Driver class, runs the game and checks if the game is won after the user
makes a move each time
*/

public class Driver {
    private int difficulty;

    public void setDifficulty(int newDifficulty) {
        difficulty = newDifficulty;
    }

    public int getDifficulty() {
        return difficulty;
    }

    //this runs the game, calls other classes
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
            //this is for the timer mode
            if (gameMode == 1) {
                int difficulty = gameMenu.getTimerDifficulty();
                gameplay = true;
            }
            else if (gameMode == 2) {
                //free play mode
                int difficulty = gameMenu.getNormalDifficulty();
                gameplay = true;
            }

            //for leaderboard, to be implemented

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
        //starts the game
        if (gameplay == true) {
            gameMenu.getName();
            GameWon checker = new GameWon();
            Grid gameGrid = new Grid();
            char[][] grid = gameGrid.makeGrid();
            gameGrid.displayGrid();
            int rowColumnNum = gameGrid.getBounds();

            //checks to see if you have the correct grid to win
            GameWon gameWon = new GameWon();
            boolean winner = gameWon.checkGame(grid, rowColumnNum);

            while (winner == false) {
                gameGrid.makeMove();
                gameGrid.displayGrid();
                winner = gameWon.checkGame(grid, rowColumnNum);
            }
            System.out.println("Congrats, you won!");
        }
    }
}
