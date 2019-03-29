package com.stackroute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlphabeticOrder {
    public List<String> SortWords(String queryString) {
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m1 = p.matcher(queryString);

        List<String> listOfWords = new ArrayList<>();
        while(m1.find()){
            listOfWords.add(m1.group());
        }

        Collections.sort(listOfWords);
        return listOfWords;
    }
}
