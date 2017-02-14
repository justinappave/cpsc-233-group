public class GameWon {
    public boolean gameWon(char[][] grid, boolean debug) {
        String playerName = "test"; //getName();
        int moveCounter = 0; //getMoves();
        int gridRows = 3; //getRow();
        int gridColumns = 3; //getColumn();
        boolean won = false;
        
        int counter = 2;
        for (int row = 0; row < gridRows; row++) {
            for (int column = 0; column < gridColumns; column++) {
                int tileNum = Character.getNumericValue(grid[row][column]);
                
                if (debug == true) {
                    System.out.print("Counter: " + counter);
                    System.out.print("| Row: " + row);
                    System.out.print("| Column: " + column);
                    System.out.println("| Num at location: " + tileNum);
                }
                
                if (counter == (gridColumns*gridRows)) {
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
