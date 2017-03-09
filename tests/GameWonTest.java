/**
To Run type:
javac -cp .;junit-4.12.jar;hamcrest-core-1.3.jar *.java
java -cp .;junit-4.12.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore GameWonTest
*/

import static org.junit.Assert.*;

import org.junit.Test;

public class GameWonTest {
    
    @Test
    public void test_checkGame3x3Win() {
        GameWon g1 = new GameWon();
        String[][] win3by3 = {
            {"1","2","3"},
            {"4","5","6"},
            {"7","8"," "}
        };
        assertEquals("Should win the game", true, g1.checkGame(win3by3, 3));
    }
    
    @Test
    public void test_checkGame3x3Lose() {
        GameWon g1 = new GameWon();
        String[][] lose3by3 = {
            {"1","2","3"},
            {"4","5","6"},
            {"7"," ","8"}
        };
        assertEquals("Should win the game", false, g1.checkGame(lose3by3, 3));
    }
    
    @Test
    public void test_checkGame4x4Win() {
        GameWon g1 = new GameWon();
        String[][] win4by4 = {
            {"1","2","3","4"},
            {"5","6","7","8"},
            {"9","10","11","12"},
            {"13","14","15"," "}
        };
        assertEquals("Should win the game", true, g1.checkGame(win4by4, 4));
    }
    
    @Test
    public void test_checkGame4x4Lose() {
        GameWon g1 = new GameWon();
        String[][] lose4by4 = {
            {"1","2","3","4"},
            {"5","6","7","8"},
            {"9","10","11","12"},
            {"13","14"," ","15"}
        };
        assertEquals("Should win the game", false, g1.checkGame(lose4by4, 4));
    }
    
    @Test
    public void test_checkGame5x5Win() {
        GameWon g1 = new GameWon();
        String[][] win5by5 = {
            {"1","2","3","4","5"},
            {"6","7","8","9","10"},
            {"11","12","13","14","15"},
            {"16","17","18","19","20"},
            {"21","22","23","24"," "}
        };
        assertEquals("Should win the game", true, g1.checkGame(win5by5, 5));
    }
    
    @Test
    public void test_checkGame5x5Lose() {
        GameWon g1 = new GameWon();
        String[][] lose5by5 = {
            {"1","2","3","4","5"},
            {"6","7","8","9","10"},
            {"11","12","13","14","15"},
            {"16","17","18","19","20"},
            {"21","22","23"," ","24"}
        };
        assertEquals("Should win the game", false, g1.checkGame(lose5by5, 5));
    }
}
        
    