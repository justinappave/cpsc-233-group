/**
To Run type:
javac -cp .;junit-4.12.jar;hamcrest-core-1.3.jar *.java
java -cp .;junit-4.12.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore GridTest
*/

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;

public class GridTest {
    
    /**@Test
    public void test_() {
        Grid g1 = new Grid();
        
    }*/
    
    @Test
    public void test_setEmptyRowNeg() {
        Grid g1 = new Grid();
        g1.setEmptyRow(-1);
        assertEquals("Empty row, not expected", 0, g1.getEmptyRow());
    }
    
    @Test
    public void test_setEmptyRow0() {
        Grid g1 = new Grid();
        g1.setEmptyRow(0);
        assertEquals("Wrong row", 0, g1.getEmptyRow());
    }
    
    @Test
    public void test_setEmptyRow1() {
        Grid g1 = new Grid();
        g1.setEmptyRow(1);
        assertEquals("Empty row, not expected", 1, g1.getEmptyRow());
    }
    
    @Test
    public void test_setEmptyColumnNeg() {
        Grid g1 = new Grid();
        g1.setEmptyColumn(-1);
        assertEquals("Empty column, not expected", 0, g1.getEmptyColumn());
    }
    
    @Test
    public void test_setEmptyColumn0() {
        Grid g1 = new Grid();
        g1.setEmptyColumn(0);
        assertEquals("Wrong row", 0, g1.getEmptyColumn());
    }
    
    @Test
    public void test_setEmptyColumn1() {
        Grid g1 = new Grid();
        g1.setEmptyColumn(1);
        assertEquals("Empty row, not expected", 1, g1.getEmptyColumn());
    }
    
    @Test
    public void test_setSizeNeg() {
        Grid g1 = new Grid();
        g1.setSize(-1);
        assertEquals("Shouldn't allow negative size", 0, g1.getSize());
    }
    
    @Test
    public void test_setSize3() {
        Grid g1 = new Grid();
        g1.setSize(3);
        assertEquals("Shouldn't allow negative size", 3, g1.getSize());
    }
    
    @Test
    public void test_setSize5() {
        Grid g1 = new Grid();
        g1.setSize(5);
        assertEquals("Shouldn't allow negative size", 5, g1.getSize());
    }
    
    @Test
    public void test_checkSolvability3x3Valid() {
        Grid g1 = new Grid();
        ArrayList<Integer> testList = new ArrayList<Integer>();
        for (int i = 1; i < 9; i++) {
            testList.add(i);
        }
        assertEquals("Should be true, is a valid grid", true, g1.checkSolvability(testList, 3));
    }
    
    @Test
    public void test_checkSolvability4x4Valid() {
        Grid g1 = new Grid();
        ArrayList<Integer> testList = new ArrayList<Integer>();
        for (int i = 1; i < 16; i++) {
            testList.add(i);
        }
        assertEquals("Should be true, is a valid grid", true, g1.checkSolvability(testList, 4));
    }
    
    @Test
    public void test_checkSolvability5x5Valid() {
        Grid g1 = new Grid();
        ArrayList<Integer> testList = new ArrayList<Integer>();
        for (int i = 1; i < 25; i++) {
            testList.add(i);
        }
        assertEquals("Should be true, is a valid grid", true, g1.checkSolvability(testList, 5));
    }
    
    @Test
    public void test_checkSolvability3x3Invalid() {
        Grid g1 = new Grid();
        ArrayList<Integer> testList = new ArrayList<Integer>();
        for (int i = 1; i <= 6; i++) {
            testList.add(i);
        }
        testList.add(8);
        testList.add(7);
        assertEquals("Should be false, is a invalid grid", false, g1.checkSolvability(testList, 3));
    }
    
    @Test
    public void test_checkSolvability4x4Invalid() {
        Grid g1 = new Grid();
        ArrayList<Integer> testList = new ArrayList<Integer>();
        for (int i = 1; i <= 13; i++) {
            testList.add(i);
        }
        testList.add(15);
        testList.add(14);
        assertEquals("Should be false, is a invalid grid", false, g1.checkSolvability(testList, 4));
    }
    
    @Test
    public void test_checkSolvability5x5Invalid() {
        Grid g1 = new Grid();
        ArrayList<Integer> testList = new ArrayList<Integer>();
        for (int i = 1; i <= 22; i++) {
            testList.add(i);
        }
        testList.add(24);
        testList.add(23);
        assertEquals("Should be false, is a invalid grid", false, g1.checkSolvability(testList, 5));
    }
    
    @Test
    public void test_convertToGrid3x3() {
        Grid g1 = new Grid();
        ArrayList<Integer> testList = new ArrayList<Integer>();
        for (int i = 1; i < 9; i++) {
            testList.add(i);
        }
        String[][] testGrid = g1.convertToGrid(testList);
        String[][] correctGrid = {
            {" 1"," 2"," 3"},
            {" 4"," 5"," 6"},
            {" 7"," 8","  "}
        };
        //assertEquals("Should be true, grids should be equal", correctGrid, testGrid);
    }
    
    @Test
    public void test_makeGrid3x3() {
        Grid g1 = new Grid();
        g1.setSize(3);
        g1.makeGrid();
        System.out.println();
        g1.displayGrid(0);
        System.out.println("Should be a 3x3 grid with move count 0");
    }
    
    @Test
    public void test_makeGrid4x4() {
        Grid g1 = new Grid();
        g1.setSize(4);
        g1.makeGrid();
        System.out.println();
        g1.displayGrid(2);
        System.out.println("Should be a 4x4 grid with move count 2");
    }
    
    @Test
    public void test_makeGrid5x5() {
        Grid g1 = new Grid();
        g1.setSize(5);
        g1.makeGrid();
        System.out.println();
        g1.displayGrid(4);
        System.out.println("Should be a 5x5 grid with move count 4");
    }
}
