//This class checks to see if the game has been won, there is also a debug mode

package gridgameplay;

public class GameWon {
    private boolean debug;
    
    public GameWon(boolean debugValue) { //constructor when having a debug value
        setDebug(debugValue);
    }
    
    public GameWon() { //default value constructor
        this(false);
    }
    
    public void setDebug(boolean debugChange) { //method for changing the debug value
        debug = debugChange;
    }
    
    
    /**This method uses for loops to cycle through the grid, it removes any spaces each spot might have.
    Each time it loops a counter increased only if the tile number matches the previous counter. If the 
    counter reaches the size*size amount (the total number of tiles) then the game is won.
    */
    public boolean checkGame(String[][] grid, int rowColumnNum) {
        boolean won = false;
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
    if (won == true) {
        System.out.println("CONGRATULATINOS!");
    }
    return won;
    }
}