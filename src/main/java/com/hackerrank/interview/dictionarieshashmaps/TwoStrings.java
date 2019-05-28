package com.hackerrank.interview.dictionarieshashmaps;

import junit.framework.Assert;
import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

/*
Function Description

Complete the function twoStrings in the editor below. It should return a string, either YES or NO based on whether the strings share a common substring.

twoStrings has the following parameter(s):

s1, s2: two strings to analyze .

https://www.hackerrank.com/challenges/two-strings/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
 */
public class TwoStrings {

    private String twoStrings(String s1, String s2) {

        Set<String> set1 = new LinkedHashSet<>();
        Set<String> set2 = new LinkedHashSet<>();
        for (char c1 : s1.toLowerCase().toCharArray()) {
            set1.add(String.valueOf(c1));
        }
        for (char c2 : s2.toLowerCase().toCharArray()) {
            set2.add(String.valueOf(c2));
        }
        for (String setString : set1) {
            if (set2.contains(setString)) return "YES";
        }
        return "NO";
    }

    @Test
    public void validateIfStringInAnother() {
        String string1Test1 = "hello";
        String string1Test2 = "world";
        String string2Test1 = "hi";
        String string2Test2 = "world";
        String string3Test1 = "test";
        String string3Test2 = "heads";

        Assert.assertEquals("YES", twoStrings(string1Test1, string1Test2));
        Assert.assertEquals("NO", twoStrings(string2Test1, string2Test2));
        Assert.assertEquals("YES", twoStrings(string3Test1, string3Test2));

    }
}
