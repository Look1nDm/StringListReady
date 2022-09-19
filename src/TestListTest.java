import exceptions.IndexNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.IndexNotFoundException;
import exceptions.ItemIsNullException;
import exceptions.TestListOfBoundException;
import static org.junit.jupiter.api.Assertions.*;

public class TestListTest {
    TestList actual;
    @BeforeEach
    void init(){
        actual = new TestList();
        actual.add("Lulu");
        actual.add("Shaco");
        actual.add("Garen");
        actual.add("Nunu");
        actual.add("Jax");
    }
    @Test
    void addFirst(){
        TestList test = new TestList(10);
        String extended = "Hello!";
        test.add("Hello!");
        assertEquals(extended,test.get(0));
    }

    @Test
    void testAddInCentral() {
        String extended = "Bow-Wow";
        actual.add(3,"Bow-Wow");
        assertEquals(extended,actual.get(3));
    }
    @Test
    void testAddInEnd(){
        String extended = "Bow-Wow";
        actual.add(actual.size(), "Bow-Wow");
        assertEquals(extended,actual.get(actual.size()-1));
    }

    @Test
    void set() {
        String extended = "Bow-Wow";
        actual.set(2, "Bow-Wow");
        assertEquals(extended,actual.get(2));
    }

    @Test
    void removePositive1() {
        String extended = "Garen";
        assertEquals(extended,actual.remove( "Garen"));
    }
    @Test
    void removePositive2(){
        String extended = null;
        actual.remove( "Jax");
        assertEquals(extended,actual.get(5));
    }
//    @Test
//    void removeNegative(){
//        assertThrows(() -> IndexNotFoundException.class, actual.remove("gar"));
//    }
    @Test
    void testRemovePositive1() {
        String extended = "Garen";
        assertEquals(extended,actual.remove( 2));
    }
    @Test
    void testRemovePositive2() {
        String extended = "Nunu";
        actual.remove( 2);
        assertEquals(extended,actual.remove( 2));
    }

    @Test
    void containsPositive() {
        String extended = "Nunu";
        assertTrue(actual.contains(extended));
    }
    @Test
    void containsPNegative() {
        String extended = "Ashe";
        assertFalse(actual.contains(extended));
    }

    @Test
    void indexOfPositive() {
    int extended = 2;
    assertEquals(extended,actual.indexOf("Garen"));
    }
    @Test
    void indexOfNeganive() {
        int extended = -1;
        assertEquals(extended,actual.indexOf("Ashe"));
    }

    @Test
    void lastIndexOfPositive() {
        int extended = 2;
        assertEquals(extended,actual.lastIndexOf("Garen"));
    }
    @Test
    void lastIndexOfNegative() {
        int extended = -1;
        assertEquals(extended,actual.lastIndexOf("Ashe"));
    }

    @Test
    void get() {
        String extended = "Nunu";
        assertEquals(extended,actual.get( 3));
    }

    @Test
    void testEqualsPositve() {
        TestList extended = new TestList();
        extended.add("Lulu");
        extended.add("Shaco");
        extended.add("Garen");
        extended.add("Nunu");
        extended.add("Jax");
        assertTrue(extended.equals(actual));
    }
    @Test
    void testEqualsNegative() {
        TestList extended = new TestList();
        extended.add("Lulu");
        extended.add("Shaco");
        extended.add("Garen");
        extended.add("Nunu");
        assertFalse(extended.equals(actual));
    }

    @Test
    void size() {
        int extended = 5;
        assertEquals(extended,actual.size());
    }

    @Test
    void isEmptyPositive() {
    assertFalse(actual.isEmpty());
    }

    @Test
    void clear() {
        int extended = 0;
        actual.clear();
        assertEquals(extended,actual.size());
    }

    @Test
    void toArray() {
    }
}