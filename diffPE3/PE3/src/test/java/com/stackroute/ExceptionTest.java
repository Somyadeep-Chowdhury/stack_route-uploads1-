package com.stackroute;

<<<<<<< HEAD
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ExceptionTest {

    private Exception exceptionObj = new Exception();

    //NegativeArraySizeException
    @Test
    public void negativeArrayTest(){
        String expectedValue = "class java.lang.NegativeArraySizeException";
        String actualValue = exceptionObj.negativeArray();
        assertEquals(expectedValue,actualValue);


    }

    //IndexOutOfBoundsException


    @Test
    public void indexOutOfBoundArray(){
        String expectedValue = "class java.lang.ArrayIndexOutOfBound";
        String actualValue = exceptionObj.indexOutOfBoundArray();
        assertEquals(expectedValue,actualValue);


    }

//NullPointerException
    @Test
    public void indexOutOfBoundArray(){
        String expectedValue = "class java.lang.NullPointerException";
        String actualValue = exceptionObj.NullPointerException();
        assertEquals(expectedValue,actualValue);


    }




}
=======
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExceptionTest {
    Exception exception = null;

    @BeforeClass
    public void setup() {
        // setup methods runs, before every test case runs
        // This method is used to initialize the required variables
        exception = new Exception();

    }

    @AfterClass
    public void teardown() {
        // teardown method runs, after every test case run
        // This method is to clear the initialized variables
        exception = null;

    }

    @Test
    public void testCheckExceptionString() {

    }

    @Test
    public void testCheckCatchClause() {

    }

    @Test
    public void testCheckFinallyClause() {

    }
}
>>>>>>> f17740e0f5a6afc4010f5aa106f5971526f62865
