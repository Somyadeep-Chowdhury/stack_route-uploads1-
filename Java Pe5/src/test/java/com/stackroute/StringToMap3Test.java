package com.stackroute;



import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class StringToMap3Test {
    StringToMap3 object = new StringToMap3();

    @Test
    public void stringToMap() {
        String[] inputString = {"a","b","c","d","a","c","c"};
        Map<String,Boolean> expectedMap = new HashMap<String, Boolean>();
        expectedMap.put("a",true);
        expectedMap.put("b",false);
        expectedMap.put("c",true);
        expectedMap.put("d",false);

        Map<String,Boolean> actualMap = object.stringToMap(inputString);
        assertEquals(expectedMap,actualMap);

    }

    @Test
    public void failureStringToMap() {
        String[] inputString = {"a","b","c","d","a","c","c"};
        Map<String,Boolean> expectedMap = new HashMap<String, Boolean>();
        expectedMap.put("a",true);
        expectedMap.put("b",false);
        expectedMap.put("c",true);
        expectedMap.put("d",true);

        Map<String,Boolean> actualMap = object.stringToMap(inputString);
        assertNotEquals(expectedMap,actualMap);

    }

    @Test
    public void nullStringToMap() {
        String[] inputString = {""};


        Map<String,Boolean> actualMap = object.stringToMap(inputString);
        assertNull(actualMap);

    }
}
