public class GameTest {
    static char[][] testGrid1 = {
        {'1','2','3'},
        {'4','5','6'},
        {'7',' ','8'}
    };
    
    static char[][] testGrid2 = {
        {'1','2','3'},
        {'4','5','6'},
        {'7','8',' '}
    };
    
    static char[][] testGrid3 = {
        {'8','4','3'},
        {'2','7','6'},
        {'5','1',' '}
    };
    
    public static void main(String[] args) {
        
        boolean debug = true;
        GameWon test = new GameWon(debug);
        System.out.println("Testing testGrid1: ");
        boolean testGrid1win = test.checkGame(testGrid1, 3);
        System.out.println("Won game? " + testGrid1win);
        
        GameWon test2 = new GameWon();
        System.out.println("Testing testGrid2: ");
        boolean test2Gridwin = test2.checkGame(testGrid2, 3);
        System.out.println("Won game? " + test2Gridwin);
        
        GameWon test3 = new GameWon(debug);
        System.out.println("Testing testGrid2: ");
        boolean test3Gridwin = test3.checkGame(testGrid2, 3);
        System.out.println("Won game? " + test2Gridwin);
        
        GameWon test4 = new GameWon(debug);
        System.out.println("Testing testGrid3: ");
        boolean test4Gridwin = test.checkGame(testGrid3, 3);
        System.out.println("Won game? " + test4Gridwin);
    }
}