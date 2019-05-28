package com.hackerrank.interview.dictionarieshashmaps;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/*
Function Description

Complete the checkMagazine function in the editor below. It must print Yes if the note can be formed using the magazine, or No.

checkMagazine has the following parameters:

magazine: an array of strings, each a word in the magazine
note: an array of strings, each a word in the ransom note

https://www.hackerrank.com/challenges/ctci-ransom-note/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
*/
public class RansomNote {

    private String checkMagazine(String[] magazine, String[] note) {

        HashMap<String, Double> stringDoubleHashMap = new HashMap<>();
        for (String wordInNote : note) {
            if (stringDoubleHashMap.containsKey(wordInNote)) {
                stringDoubleHashMap.put(wordInNote, stringDoubleHashMap.get(wordInNote) + 1D);
                continue;
            }
            stringDoubleHashMap.put(wordInNote, 1D);
        }
        for (String wordInMagazine : magazine) {
            if (stringDoubleHashMap.containsKey(wordInMagazine)) {
                stringDoubleHashMap.put(wordInMagazine, stringDoubleHashMap.get(wordInMagazine) - 1);
            }
        }
        for (Double value : stringDoubleHashMap.values()) {
            if (value > 0) {
                return "No";
            }
        }

        return "Yes";
    }

    @Test
    public void validateTheHourglassSum() {

        String[] inputMagazine1 = {"two", "times", "three", "is", "not", "four", "two", "times", "two", "is", "four"};
        String[] inputNote1 = {"two", "times", "two", "is", "four"};
        String[] inputMagazine2 = {"ive", "got", "a", "lovely", "bunch", "of", "coconuts"};
        String[] inputNote2 = {"ive", "got", "some", "coconuts"};

        Assert.assertEquals("Yes", checkMagazine(inputMagazine1, inputNote1));
        Assert.assertEquals("No", checkMagazine(inputMagazine2, inputNote2));
    }
}
