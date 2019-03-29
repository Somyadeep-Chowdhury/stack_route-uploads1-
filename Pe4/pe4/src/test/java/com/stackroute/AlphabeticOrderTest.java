package com.stackroute;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class AlphabeticOrderTest {

    AlphabeticOrder c=new AlphabeticOrder();

    @Test
    public void Testcase1()
    {
        String queryString = "Cd Dc Ab Ba";
        List<String> sortedWords = new ArrayList<>(Arrays.asList("Ab","Ba","Cd","Dc"));
        List<String> actualSortedWords = c.SortWords(queryString);
        Assert.assertEquals(sortedWords, actualSortedWords);
    }
}