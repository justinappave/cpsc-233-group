package tilePuzzle;

public class GameWon {
    private boolean debug;
    
    public GameWon(boolean debugValue) {
        setDebug(debugValue);
    }
    
    public GameWon() {
        this(false);
    }
    
    public void setDebug(boolean debugChange) {
        debug = debugChange;
    }
    
    public boolean checkGame(String[][] grid, int rowColumnNum) {
        boolean won = false;
        
        // These for loops cycle through the entire grid checking if the values are in the correct spots
        int counter = 1;
        for (int row = 0; row < rowColumnNum; row++) {
            for (int column = 0; column < rowColumnNum; column++) {
                String withSpaces = grid[row][column];
                String noSpaces = withSpaces.trim();
                String tileNumStr = String.valueOf(noSpaces);
                String counterStr = String.valueOf(counter);
                
                if (debug == true) { //if class is called with debug will print extra messages
                    System.out.print("Counter: " + counter);
                    System.out.print("| Row: " + row);
                    System.out.print("| Column: " + column);
                    System.out.println("| Num at location: " + tileNumStr);
                }
                
                if (counter == (rowColumnNum*rowColumnNum)) { //game is only won if the counter variable hits the grid size
                    won = true;
                }
                if (tileNumStr.equals(counterStr)) { 
                    counter += 1;
                }
            }
        }
    return won;
    }
}