package com.stackroute;

import java.util.ArrayList;

public class ArrayListUpdate {
    public ArrayList<String> updatedArrayList(ArrayList<String> newObject)
    {
        if(newObject.contains("Apple") || newObject.contains("Melon"))
        {
            int i= newObject.indexOf("Apple");
            newObject.remove("Apple");
            newObject.add(i,"Kiwi");

            int j= newObject.indexOf("Melon");
            newObject.remove("Melon");
            newObject.add(j,"Mango");
        }
        return newObject;
    }

    public static ArrayList<String> deleteArrayList(ArrayList<String> newObject)
    {
        if(newObject.contains("Apple"))
        {
            newObject.clear();
            return newObject;
        }
        else{
            return null;
        }
    }
}
