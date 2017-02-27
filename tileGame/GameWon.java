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
    
    public boolean checkGame(char[][] grid, int rowColumnNum) {
        boolean won = false;
        
        // These for loops cycle through the entire grid checking if the values are in the correct spots
        int counter = 1;
        for (int row = 0; row < rowColumnNum; row++) {
            for (int column = 0; column < rowColumnNum; column++) {
                int tileNum = Character.getNumericValue(grid[row][column]);
                
                if (debug == true) { //if class is called with debug will print extra messages
                    System.out.print("Counter: " + counter);
                    System.out.print("| Row: " + row);
                    System.out.print("| Column: " + column);
                    System.out.println("| Num at location: " + tileNum);
                }
                
                if (counter == (rowColumnNum*rowColumnNum)) { //game is only won if the counter variable hits the grid size
                    won = true;
                }
                if (tileNum == counter) { 
                    counter += 1;
                }
            }
        }
    return won;
    }
}