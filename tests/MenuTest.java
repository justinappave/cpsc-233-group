/**
To Run type:
javac -cp .;junit-4.12.jar;hamcrest-core-1.3.jar *.java
java -cp .;junit-4.12.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore MenuTest
*/

import static org.junit.Assert.*;
import org.junit.Test;

public class MenuTest {
    
    @Test
    public void test_quickPlay_selectQuickPlay() {
        Menu m1 = new Menu();
        System.out.println("------Press \"1\" then enter------");
        int input = m1.quickPlay();
        assertEquals(1, input);
    }
    
    @Test
    public void test_quickPlay_selectMainMenu() {
        Menu m1 = new Menu();
        System.out.println("------Press \"2\" then enter------");
        int input = m1.quickPlay();
        assertEquals(2, input);
    }
    
    @Test
    public void test_mainMenu_selectTimer() {
        Menu m1 = new Menu();
        System.out.println("------Press \"1\" then enter------");
        int input = m1.mainMenu();
        assertEquals(1, input);
    }
    
    @Test
    public void test_mainMenu_selectFreeplay() {
        Menu m1 = new Menu();
        System.out.println("------Press \"2\" then enter------");
        int input = m1.mainMenu();
        assertEquals(2, input);
    }
    
    @Test
    public void test_mainMenu_selectLeaderboards() {
        Menu m1 = new Menu();
        System.out.println("------Press \"3\" then enter------");
        int input = m1.mainMenu();
        assertEquals(3, input);
    }
    
    @Test
    public void test_getTimerDifficulty_selectEasy() {
        Menu m1 = new Menu();
        System.out.println("------Press \"1\" then enter------");
        int input = m1.getTimerDifficulty();
        assertEquals(1, input);
    }
    
    @Test
    public void test_getTimerDifficulty_selectMedium() {
        Menu m1 = new Menu();
        System.out.println("------Press \"2\" then enter------");
        int input = m1.getTimerDifficulty();
        assertEquals(2, input);
    }
    
    @Test
    public void test_getTimerDifficulty_selectHard() {
        Menu m1 = new Menu();
        System.out.println("------Press \"3\" then enter------");
        int input = m1.getTimerDifficulty();
        assertEquals(3, input);
    }
    
    @Test
    public void test_getFreeplayDifficulty_selectEasy() {
        Menu m1 = new Menu();
        System.out.println("------Press \"1\" then enter------");
        int input = m1.getFreeplayDifficulty();
        assertEquals(3, input);
    }
    
    @Test
    public void test_getFreeplayDifficulty_selectMedium() {
        Menu m1 = new Menu();
        System.out.println("------Press \"2\" then enter------");
        int input = m1.getFreeplayDifficulty();
        assertEquals(4, input);
    }
    
    @Test
    public void test_getFreeplayDifficulty_selectHard() {
        Menu m1 = new Menu();
        System.out.println("------Press \"3\" then enter------");
        int input = m1.getFreeplayDifficulty();
        assertEquals(5, input);
    }
}
