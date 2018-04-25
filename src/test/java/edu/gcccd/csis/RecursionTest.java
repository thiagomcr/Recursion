package edu.gcccd.csis;

import org.junit.Test;
import java.util.Random;
import static org.junit.Assert.*;

public class RecursionTest {

    @Test
    public void printEveryOther() throws Exception {

        //array is empty thrown nullpointer exception
        try {
            Recursion.printEveryOther(new int[]{},1); //
            fail();
        } catch (NullPointerException error) {
            assertTrue(true);
        }

        //index is greater than the array length throw exception
        try {
            Recursion.printEveryOther(new int[]{1,3,5,7,5}, 10);
            fail();
        } catch (IllegalArgumentException error) {
            assertTrue(true);
        }

        //index is smaller than 0 throw exception
        try {
            Recursion.printEveryOther(new int[]{1,2,3,4,5,6,7,8,9,10},-5);
            fail();
        } catch (IllegalArgumentException error) {
            assertTrue(true);
        }

        //no numbers to display
            assertEquals("", Recursion.printEveryOther(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 9));
    }

    @Test
    public void printStars() {
        //null String
        assertEquals("",Recursion.printStars(""));

        //cointains spaces in between
        assertEquals(" * * ",Recursion.printStars("   "));

        //regular
        assertEquals("ja*a*av*va*a",Recursion.printStars("jaaavvaa"));
    }

    /*
     * we know the sum of the 1st k positive numbers is n(n+1)2
     */
    @Test
    public void sum() {
        for (int i = 0; i < 10; i++) {
            int k = new Random().nextInt(100);
            assertEquals(k * (k + 1) / 2, Recursion.sum(k));
        }
        // corner cases
        assertEquals(0, Recursion.sum(-1));
        assertEquals(0, Recursion.sum(0));
        try {
            int x = Recursion.sum(Integer.MAX_VALUE); // stackoverflow
            fail();
        } catch (StackOverflowError error) {
            assertTrue(true);
        }
    }
}
