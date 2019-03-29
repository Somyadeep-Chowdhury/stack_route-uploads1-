package com.stackroute.javape3;

import org.junit.Test;

import static org.junit.Assert.*;

public class AdditionTest {
    Addition addition = new Addition();



    @Test
    public void testAddMatrix()
    {
        int[][] expected = {{10,10},{10,10}};
        int[][] first={{1,2},{3,4}};
        int[][] second={{9,8},{7,6}};
        int[][] result = addition.addMatrix(first,second,2,2);
        assertArrayEquals(expected,result);
    }

    @Test
    public void testAddMatrix2()
    {
        int[][] expected = {{10,10},{10,10},{10,10}};
        int[][] first={{1,2},{3,4},{5,6}};
        int[][] second={{9,8},{7,6},{5,4}};
        int[][] result = addition.addMatrix(first,second,3,2);
        assertArrayEquals(expected,result);
    }

    @Test
    public void testAddMatrix3()
    {
        int[][] expected = {{2,2,2},{2,2,2},{2,2,2}};
        int[][] first={{1,1,1},{1,1,1},{1,1,1}};
        int[][] second={{1,1,1},{1,1,1},{1,1,1}};
        int[][] result = addition.addMatrix(first,second,3,3);
        assertArrayEquals(expected,result);
    }

}