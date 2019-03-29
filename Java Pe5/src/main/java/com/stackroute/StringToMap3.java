package com.stackroute;

import java.util.HashMap;
import java.util.Map;

public class StringToMap3 {
    public Map<String,Boolean> stringToMap(String[] s)
    {
        int countA=0,countB=0,countC=0,countD=0;

        for (int i=0;i<s.length;i++)
        {
            if(s[i].contains("a"))
            {
                countA++;
            }else if(s[i].contains("b"))
            {
                countB++;
            }else if(s[i].contains("c"))
            {
                countC++;
            }
            else if(s[i].contains("d"))
            {
                countD++;
            }
            else
            {
                return null;
            }
        }
        Map <String,Boolean> myMap= new HashMap<>();
        for(String string: s)
        {
            if(myMap.containsKey(string))
                myMap.put(string, true);
            else
                myMap.put(string, false);
        }

        return myMap;


//        if(mymap.containsValue(countA>1) || mymap.containsValue(countB>1) || mymap.containsValue(countC>1) || mymap.containsValue(countD>1))
//        {
//            String sNew= "true";
//        }
//        else {
//            String sNew2= "false";
//        }
//        for(int j=0;j<s.length;j++)
//        {
//            if(countA>=2){
//                mymap.put("a",Boolean.TRUE);
//            }else if(countB>=2)
//            {
//                mymap.put("b",Boolean.TRUE);
//            }else if(countC>=2)
//            {
//                mymap.put("c",Boolean.TRUE);
//            }
//            else if(countD>=2)
//            {
//                mymap.put("d",Boolean.TRUE);
//            }
//        }
//        return mymap;
    }
}
