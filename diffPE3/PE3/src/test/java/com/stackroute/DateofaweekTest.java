package com.stackroute;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateofaweekTest {
    Dateofaweek d = new Dateofaweek();
    @Test
    public void caltest() {
        assertEquals("First day of week : Monday 24/12/2018 Last day of week : 30/12/2018", d.calender("dd/MM/YYYY"));
    }
    @Test
    public void caltest1() {
        assertNotEquals("Last day of week : Monday 24/12/2015 Last day of week : 30/12/2015",d.calender("dd/mm/yyyy"));
    }
}