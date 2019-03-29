package com.stackroute;

import org.junit.Test;
import static org.junit.Assert.*;
<<<<<<< HEAD
//
//public class MatrixTest {
//    Matrix mat = new Matrix();
//
//    @Test
//    public void matrixSum()
//    {
//        int[][] result = mat.add(new int[][]{{1, 2, 3}, {4, 5, 6}}, new int[][]{{9, 8, 7}, {6, 5, 4}});
//        assertArrayEquals(new int[][]{{10,10},{10,10},{10,10}},result);
//    }
//
//
//
//    @Test
//    public void matrixSumFail()
//    {
//        int[][] result = mat.add(new int[][]{{1, 2, 3}, {4, 5, 6}}, new int[][]{{9, 8, 7}, {6, 5, 4}});
//        assertArrayEquals(new int[][]{{10,10},{9,10},{10,10}},result);
//    }
//
//
//}
=======

public class MatrixTest {

    Matrix mat = new Matrix();

    @Test
    public void matrixSum()
    {
        int[][] result = mat.sum(new int[][]{{1, 2, },{3,4,},{ 5, 6}}, new int[][]{{9, 8,},{ 7, 6},{ 5, 4}});
        assertArrayEquals(new int[][]{{10,10},{10,10},{10,10}},result);
    }

    @Test
    public void matrixSum1()
    {
        int[][] result = mat.sum(new int[][]{{1, 2, 3}, {4, 5, 6},{7,8,9}}, new int[][]{{9, 8, 7}, {6, 5, 4},{1,2,3}});
        assertArrayEquals(new int[][]{{10,10,10},{10,10,10},{8,10,12}},result);
    }
    @Test
    public void matrixSum2()
    {
        int[][] result = mat.sum(new int[][]{{1,2},{3,4}}, new int[][]{{4,3},{2,1}});
        assertArrayEquals(new int[][]{{5,5},{5,5}},result);
    }
    @Test
    public void matrixSumFail()
    {
        int[][] result = mat.sum(new int[][]{{1, 2, 3}, {4, 5, 6}}, new int[][]{{9, 8, 7}, {6, 5, 4}});
        assertNotEquals(new int[][]{{10,10},{10,10}},result);
    }

}
>>>>>>> f17740e0f5a6afc4010f5aa106f5971526f62865
