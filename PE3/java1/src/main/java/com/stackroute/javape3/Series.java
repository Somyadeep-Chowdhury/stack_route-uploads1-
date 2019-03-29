package com.stackroute.javape3;

public class Series {
    public  String testCheckConsecutive(String s)
    {
        boolean isCon = true;
        String s1;
        String[] str= s.split(" ");
        int[] result = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            result[i] = Integer.parseInt(str[i]);
        }

        for(int i=0; i<result.length; i++ )
        {
            if(result[0]>result[1])
            {
                if(i<result.length-1 && result[i]-result[i+1]!=1)
                {

                    isCon = false;
                    break;
                }
            }
            else
            {
                if(i<result.length && result[i+1]-result[i]!=1)
                {


                    isCon = false;
                    break;
                }
            }

        }
        if(isCon)
        {
            s1="consecutive number";
        }
        else
        {
            s1="non consecutive number";
        }
        return s1;
    }
}
