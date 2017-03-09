/**
To Run type:
javac -cp .;junit-4.12.jar;hamcrest-core-1.3.jar *.java
java -cp .;junit-4.12.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore GridTest
*/

import static org.junit.Assert.*;

import org.junit.Test;

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
}