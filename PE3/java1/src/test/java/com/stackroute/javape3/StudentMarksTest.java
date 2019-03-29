package com.stackroute.javape3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentMarksTest {
    StudentMarks student;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void checkForGrades1() {
        //act
        String expected = "O";
        //arrange
        String result = student.checkForGrades(5,new int[]{92,96,91,94,98});
        //assert
        assertEquals(expected,result);
    }

    @Test
    public void checkForGrades2() {
        //act
        String expected ="E";
        //arrange
        String result= student.checkForGrades(3,new int[]{81,85,86});
        //assert
        assertEquals(expected,result);
    }
    @Test
    public void checkForGrades3() {
        //act
        String expected ="Error...please enter positive no students";
        //arrange
        String result= student.checkForGrades(0,new int[]{81,85,86});
        //assert
        assertEquals(expected,result);
    }
    @Test
    public void checkForGrades4() {
        //act
        String expected ="Error...marks for student"+3+"is more than 100";
        //arrange
        String result= student.checkForGrades(3,new int[]{81,85,105});
        //assert
        assertEquals(expected,result);
    }
    @Test
    public void checkForGrades5() {
        //act
        String expected ="Error...marks for student"+3+"is less than 0";
        //arrange
        String result= student.checkForGrades(3,new int[]{81,85,0});
        //assert
        assertEquals(expected,result);
    }
}