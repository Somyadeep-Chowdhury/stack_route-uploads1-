package com.stackroute;

import org.junit.Test;

import static org.junit.Assert.*;

public class HarryTest {
    Harry h = new Harry();

    @Test
    public void isHarry1() {
        assertEquals("Is Harry here ? True",h.isHarry("This is Harry"));
    }

    @Test
    public void isHarry2() {
        assertEquals("Is Harry here ? False",h.isHarry("This is Henry"));
    }

    @Test
        public void isHarry3(){
            assertEquals("Is Harry here? False",h.isHarry("This is Henry"));
        }


    @Test
        public void isHarry4(){
            assertNotEquals("Is Harry here? False",h.isHarry("This is Harry"));
        }

}