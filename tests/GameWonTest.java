public class GameWonTest {
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
    
    static char[][] testGrid4 = {
        {'8','4','3'},
        {'2',' ','6'},
        {'5','1',' '}
    };
    
    static char[][] testGrid5 = {
        {' ',' ',' '},
        {' ',' ',' '},
        {' ',' ',' '}
    };
    
    static char[][] testGrid6 = {
        {'1','1','1'},
        {'1','1','1'},
        {'1','1','1'}
    };
    
    public static void main(String[] args) {
        
        
        //Testing method "checkGame" in class "GameWon"
        boolean debug = true;
        GameWon test = new GameWon();
        System.out.println("Testing testGrid1: ");
        boolean testGrid1win = test.checkGame(testGrid1, 3);
        System.out.println("Won game? " + testGrid1win + ". Expected false");
        
        GameWon test2 = new GameWon();
        System.out.println("Testing testGrid2: ");
        boolean test2Gridwin = test2.checkGame(testGrid2, 3);
        System.out.println("Won game? " + test2Gridwin + ". Expected true");
        
        GameWon test3 = new GameWon();
        System.out.println("Testing testGrid3: ");
        boolean test3Gridwin = test3.checkGame(testGrid3, 3);
        System.out.println("Won game? " + test3Gridwin + ". Expected false");
        
        GameWon test4 = new GameWon();
        System.out.println("Testing testGrid4: ");
        boolean test4Gridwin = test4.checkGame(testGrid4, 3);
        System.out.println("Won game? " + test4Gridwin + ". Expected false");
        
        GameWon test5 = new GameWon();
        System.out.println("Testing testGrid5: ");
        boolean test5Gridwin = test5.checkGame(testGrid5, 3);
        System.out.println("Won game? " + test5Gridwin + ". Expected false");
        
        GameWon test6 = new GameWon();
        System.out.println("Testing testGrid6: ");
        boolean test6Gridwin = test6.checkGame(testGrid6, 3);
        System.out.println("Won game? " + test6Gridwin + ". Expected false");
        
    }
}