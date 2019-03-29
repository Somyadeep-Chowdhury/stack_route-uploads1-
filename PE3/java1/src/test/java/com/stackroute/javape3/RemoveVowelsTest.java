package com.stackroute.javape3;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveVowelsTest {

    RemoveVowels rm= new RemoveVowels();
    @Test
    public void modifyVowels1() {
        String[] result= rm.modifyVowels(new String[]{"India,United States, Germany,Egypt,czechoslovakia"});
        assertArrayEquals(new String[]{"Ind,Untd Stts,Grmny,Egypt,czchslvk"},result);
    }

    @Test
    public void modifyVowels2() {
        String[] result= rm.modifyVowels(new String[]{"India,United States, Germany,Egypt,czechoslovakia"});
        assertArrayEquals(new String[]{"Ind,Untd Stts,Grmny,Egypt,czchslvk"},result);
    }

    @Test
    public void modifyVowels3() {
        String[] result= rm.modifyVowels(new String[]{"India,United States, Germany,Egypt,czechoslovakia"});
        assertArrayEquals(new String[]{"Ind,Untd Stts,Grmny,Egypt,czchslvk"},result);
    }

    @Test
    public void removeFail()
    {
        String[] result = rm.modifyVowels(new String[]{"India,czechoslovakia"});
        assertNotEquals(new String[]{"Indi,czchslvk"},result);
    }
}

