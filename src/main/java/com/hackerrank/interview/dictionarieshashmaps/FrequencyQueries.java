package com.hackerrank.interview.dictionarieshashmaps;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;

/*
Function Description

Complete the function sherlockAndAnagrams in the editor below. It must return an integer that represents the number of anagrammatic pairs of substrings in s.

sherlockAndAnagrams has the following parameter(s):

s: a string.1083727MA

https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
*/
public class FrequencyQueries {
    private  List<Integer> freqQuery(List<List<Double>> queries) {
        Map<Double, Double> map = new HashMap<>();
        List<Integer> results = new ArrayList<>();

        for(List<Double> operation : queries){
            Double frequency = map.get(operation.get(1));
            if(frequency==null)frequency=0d;
            switch(operation.get(0).intValue()){
                case 1:
                    if(frequency != null) {
                        map.put(operation.get(1), frequency +1d);
                    }
                    else map.put(operation.get(1), 1d);
                    break;
                case 2:
                    if(!map.containsKey(operation.get(1))) break;
                    map.put(operation.get(1), frequency -1d);
                    break;
                case 3:
                    if(map.containsValue(operation.get(1))) results.add(1);
                    else results.add(0);
                    break;
            }
        }
        
        return results;
    }

    @Test
    public void countFrequency(){
        List<List<Double>> listsTest1 = new ArrayList<>();
        listsTest1.add(Arrays.asList(1d,5d));
        listsTest1.add(Arrays.asList(1d,6d));
        listsTest1.add(Arrays.asList(3d,2d));
        listsTest1.add(Arrays.asList(1d,10d));
        listsTest1.add(Arrays.asList(1d,10d));
        listsTest1.add(Arrays.asList(1d,6d));
        listsTest1.add(Arrays.asList(2d,5d));
        listsTest1.add(Arrays.asList(3d,2d));
        Assert.assertThat(freqQuery(listsTest1), is(Arrays.asList(0,1)));

    }
}