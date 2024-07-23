package com.test.dto;


import java.util.HashSet;
import java.util.Set;

public class Test {


    public static void main(String[] args) {

        char[] a = {'2', '4', '6', '7', '9'};
        char[] b = {'3', '4', '6', '5'};


        HashSet<String> setA = new HashSet<>();
        HashSet<String> setB = new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            char[] temp = sub(i, a);
            setA = putString(temp);
        }

        for (int i = 0; i < b.length; i++) {
            char[] temp = sub(i, b);
            setB = putString(temp);
        }

        Set<String> set = getCommonStr(setA, setB);

        //打印公共子串
        for (String s : set) {
            System.out.println(s);
        }

    }

    private static Set<String> getCommonStr(HashSet<String> a, HashSet<String> b) {
        HashSet<String> set = new HashSet<>();

        for (String s1 : a) {
            if (b.contains(s1)) {
                set.add(s1);
            }
        }

        return set;
    }

    private static char[] sub(int i, char[] a) {

        char[] array = new char[a.length - i];

        for (int j = i; j < a.length; j++) {
            array[i] = a[j];
        }

        return array;
    }

    private static HashSet<String> putString(char[] a) {
        HashSet<String> set = new HashSet<>();

        int n = 1;
        String s = "";
        while (n <= a.length - 1) {
            s = s + a[n];
            set.add(s);
            n++;
        }

        return set;
    }


}
