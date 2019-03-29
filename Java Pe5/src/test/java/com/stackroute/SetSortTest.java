package com.stackroute;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class SetSortTest {

    SetSort obj=new SetSort();
    TreeSet<String> list= new TreeSet<>();

    @Test
    public void sortTest()
    {
        LinkedHashSet<String> set1=new LinkedHashSet<String>();
        set1.add("Harry");
        set1.add("Olive");
        set1.add("Alice");
        set1.add("Bluto");
        set1.add("Eunogen");
        LinkedHashSet<String> set2=new LinkedHashSet<String>();
        set2.add("Alice");
        set2.add("Bluto");
        set2.add("Eunogen");
        set2.add("Harry");
        set2.add("Olive");
        list=obj.sort(set1);
        assertEquals(set2,list);

    }
    @Test
    public void sortTestFaliure()
    {
        LinkedHashSet<String> set1=new LinkedHashSet<String>();
        set1.add("Harry");
        set1.add("Olive");
        set1.add("Alice");
        set1.add("Bluto");
        set1.add("Eunogen");
        LinkedHashSet<String> set2=new LinkedHashSet<String>();
        set2.add("Henry");
        set2.add("Olive");
        set2.add("Alice");
        set2.add("Bluto");
        set2.add("Eunogen");
        TreeSet<String> actual=obj.sort(set1);
        assertNotEquals(set2,actual);
    }
    @Test
    public void convertToArrayListTest()
    {
        ArrayList<String> set1=obj.convertToArrayList(list);
        ArrayList<String> actual=new ArrayList<>(list);
        assertEquals(set1,actual);
    }

}
