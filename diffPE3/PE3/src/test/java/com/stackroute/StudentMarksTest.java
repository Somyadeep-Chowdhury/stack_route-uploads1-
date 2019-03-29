package com.stackroute;
import org.junit.Test;
import static org.junit.Assert.*;
public class StudentMarksTest {
    StudentMarks marks = new StudentMarks();
    @Test
public void test1() {
    assertEquals("Grade should lie between 0 to 100",true, StudentMarks.studentmarks(00));
}    @Test
public void test2() {
    assertEquals(  "grade should lie between 0 to 100", false, StudentMarks.studentmarks(150));
}    @Test
public void test3() {
    assertNotEquals("grade should be equal to 0 to 100", true, StudentMarks.studentmarks(400));
}    @Test
public void test4() {
    assertNull("grade should lie between 0 to 100",StudentMarks.studentmarks(87));
}
}
