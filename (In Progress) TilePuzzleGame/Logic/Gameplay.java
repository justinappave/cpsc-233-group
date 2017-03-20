public class Gameplay extends GameWon{
    private int moveCount = 0;
    private long timeTaken = 0;
    
    public void increaseMoveCount() {
        moveCount ++;
    }
    
    public int getMoveCount() {
        return moveCount;
    }
    
    public void setTimeTaken(long newTimeTaken) {
        timeTaken = newTimeTaken;
    }
    
    public int getTimeTaken() {
        int intTimeTaken = (int) timeTaken;
        return intTimeTaken;
    }
    
    
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
            amountTime = startTime + 180*1000;
        }
        else {
            amountTime = startTime + 10*1000;
        }
        while (System.currentTimeMillis() < amountTime) {
            winner = freeplay(3, amountTime);
        }
        if (winner == false) {
            setTimeTaken(0);
        }
        return winner;
    }
    
    public boolean freeplay(int size, long endTime) {
        Grid game = new Grid();
        game.setSize(size);
        String[][] grid = game.makeGrid();
        game.displayGrid(moveCount);
        int rowColumnNum = game.getSize();
        
        //GameWon gameWon = new GameWon();
            
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
                timeTakenSec = (endTime - currentTime)*1000;
                setTimeTaken(timeTakenSec);
            }
        }
        return winner;
    }
    
    public void quickplay() {
        Grid game = new Grid();
        game.setSize(3);
        String[][] grid = game.makeGrid();
        game.displayGrid(moveCount);
        int rowColumnNum = game.getSize();
        
        //GameWon gameWon = new GameWon();
            
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
    }
}
