package com.stackroute;

import java.util.HashMap;
import java.util.Map;

public class MappingString {
    public Map<String,Integer> countMap(String str)
    {
        int countOne=0,countTwo=0,countThree=0;
        String s[]= str.split("[^a-z]+");
        for (int i=0;i<s.length;i++)
        {
            if(s[i].contains("one"))
            {
                countOne++;
            }else if(s[i].contains("two"))
            {
                countTwo++;
            }else if(s[i].contains("three"))
            {
                countThree++;
            }
            else
            {
                return null;
            }
        }
        Map<String,Integer> myMap= new HashMap<>();
        myMap.put("one",countOne);
        myMap.put("two",countTwo);
        myMap.put("three",countThree);
        return myMap;
    }
}
