package com.stackroute;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class SeriesTest {
    Series series = null;

    @BeforeClass
    public void setup() {
        // setup methods runs, before every test case runs
        // This method is used to initialize the required variables
        series = new Series();

    }

    @AfterClass
    public void teardown() {
        // teardown method runs, after every test case run
        // This method is to clear the initialized variables
        series = null;

    }

    @Test
    public void testCheckConsecutive1() {

//        String expected = "non consecutive number";
//        String result = series.testCheckConsecutive("98 96 95 94 93");
//        assertEquals(expected, result);
        assertEquals("non consecutive number", series.testCheckConsecutive("98 96 95 94 93"));
    }

    @Test
    public void testCheckConsecutive2() {

        assertEquals("consecutive number", series.testCheckConsecutive("54 53 52 51 50 49 48"));
    }

    @Test
    public void testCheckConsecutive3() {

        assertEquals("non consecutive number",series.testCheckConsecutive("1 2 3 4 5 6 6"));
    }
}
