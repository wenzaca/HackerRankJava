package com.hackerrank.interview.dictionarieshashmaps;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;

public class SherlockAndAnagrams {

    private int sherlockAndAnagrams(String s) {
        Map<String, Integer> map = new HashMap<>();

        // Keep track of how many anagrams we've seen
        int totalCount = 0;

        // Generate all substrings (N^2)
        for(int i = 0 ; i < s.length(); i++)
        {
            for(int j=i+1 ; j <= s.length(); j++)
            {
                String currentSubString = s.substring(i,j);

                // Sort all strings E.g. ab & ba both == ab now
                char[] chars = currentSubString.toCharArray();
                Arrays.sort(chars);
                currentSubString = String.valueOf(chars);

                // If sorted substring has been seen before
                int value = map.getOrDefault(currentSubString, 0);

                totalCount += value;

                map.put(currentSubString, ++value);
            }
        }
        return totalCount;
    }

    @Test
    public void checkAnagram(){
        String test1 = "abba";
        String test2 = "ifailuhkqq";
        String test3 = "kkkk";

        Assert.assertThat(sherlockAndAnagrams(test1), is(4));
        Assert.assertThat(sherlockAndAnagrams(test2), is(3));
        Assert.assertThat(sherlockAndAnagrams(test3), is(10));

    }
}
