package com.stackroute;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetSort {
    public TreeSet<String> sort(LinkedHashSet<String> set)
    {
        HashSet<String> myHash = new HashSet<>(set);
        TreeSet<String> myTreeSet = new TreeSet<>();
        myTreeSet.addAll(myHash);
        return myTreeSet;
    }

    public ArrayList<String> convertToArrayList(TreeSet<String> myTreeSet)
    {
        ArrayList<String> al =new ArrayList<>(myTreeSet);
        return al;
    }
}
