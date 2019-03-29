package com.stackroute;

import org.junit.Test;


import java.util.HashMap;
import java.util.Map;


import static org.junit.Assert.*;


public class MappingStringTest {

    MappingString object = new MappingString();

    @Test
    public void countMapTest(){
        String inputString ="one one -one___two,,three,one @three*one?two";
        Map<String,Integer> expectedMap = new HashMap<String, Integer>();
        expectedMap.put("one",5);
        expectedMap.put("two",2);
        expectedMap.put("three",2);

        Map<String,Integer> actualMap = object.countMap(inputString);
        assertEquals(expectedMap,actualMap);

    }

    @Test
    public void failureCountMapTest(){
        String inputString ="one one -one___two,,three,one @three*one?two";
        Map<String,Integer> expectedMap = new HashMap<String, Integer>();
        expectedMap.put("one",1);
        expectedMap.put("two",2);
        expectedMap.put("three",2);

        Map<String,Integer> actualMap = object.countMap(inputString);
        assertNotEquals(expectedMap,actualMap);

    }

    @Test
    public void countMapTest2(){
        String inputString ="one one -one___two,,three,one @three*one?two,one,one*two";
        Map<String,Integer> expectedMap = new HashMap<String, Integer>();
        expectedMap.put("one",7);
        expectedMap.put("two",3);
        expectedMap.put("three",2);

        Map<String,Integer> actualMap = object.countMap(inputString);
        assertEquals(expectedMap,actualMap);


    }

    @Test
    public void nullCountMapTest2(){
        String inputString ="";

        Map<String,Integer> actualMap = object.countMap(inputString);
        assertNull(actualMap);


    }

}
