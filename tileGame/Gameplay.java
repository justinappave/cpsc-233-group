public class Gameplay {
    public boolean timeplay(int difficulty) {
        boolean winner = false;
        GameWon checker = new GameWon();
        Grid game = new Grid();
        long startTime = System.currentTimeMillis();
        long amountTime;
        if (difficulty == 1) {
            amountTime = startTime + 300*1000;
        }
        else if (difficulty == 2) {
            amountTime = startTime + 180*1000;
        }
        else {
            amountTime = startTime + 10*1000;
        }
        while (System.currentTimeMillis() < amountTime) {
            winner = freeplay(3, amountTime);
        }
        return winner;
    }
    
    public boolean freeplay(int size, long endTime) {
        GameWon checker = new GameWon();
        Grid game = new Grid();
        game.setSize(size);
        String[][] grid = game.makeGrid();
        game.displayGrid();
        int rowColumnNum = game.getSize();
        
        GameWon gameWon = new GameWon();
            
        boolean winner = gameWon.checkGame(grid, rowColumnNum);
            
        while (winner == false) {
            long currentTime = System.currentTimeMillis();
            if ((currentTime > endTime) && (endTime != -1)) {
                System.out.println("Out of time!");
                break;
            }
            game.makeMove(grid);
            game.displayGrid();
            winner = gameWon.checkGame(grid, rowColumnNum);
        }
        return winner;
    }
    
    public void quickplay() {
        GameWon checker = new GameWon();
        Grid game = new Grid();
        game.setSize(3);
        String[][] grid = game.makeGrid();
        game.displayGrid();
        int rowColumnNum = game.getSize();
        
        GameWon gameWon = new GameWon();
            
        boolean winner = gameWon.checkGame(grid, rowColumnNum);
            
        while (winner == false) {
            game.makeMove(grid);
            game.displayGrid();
            winner = gameWon.checkGame(grid, rowColumnNum);
        }
    }
}