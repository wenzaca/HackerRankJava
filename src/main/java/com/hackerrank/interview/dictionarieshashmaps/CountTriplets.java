package com.hackerrank.interview.dictionarieshashmaps;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;

/*
Function Description

Complete the countTriplets function in the editor below. It should return the number of triplets forming a geometric progression for a given r as an integer.

countTriplets has the following parameter(s):

arr: an array of integers
r: an integer, the common ratio

https://www.hackerrank.com/challenges/count-triplets-1/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
 */
public class CountTriplets {

    static long countTriplets(List<Long> arr, long r) {

        // Store of the numbers that would serve as the second number in a triplet.
        Map<Long, Long> v2 = new HashMap<>();
        // The number that is being searched for to serve as the third number in a triplet.
        Map<Long, Long> v3 = new HashMap<>();
        Long count = 0L;
        for (Long k : arr) {
            count += v3.getOrDefault(k, 0L);
            if (v2.containsKey(k))
                v3.compute(k * r, (key, value) -> value != null ? value + v2.get(k) : v2.get(k));
            v2.compute(k * r, (key, value) -> value == null ? 1 : value + 1);
        }
        return count;
    }

    @Test
    public void checkCountTriplet() {
        List<Long> test1 = Arrays.asList(1L, 2L, 2L, 4L);
        Long test1CommonRatio = 2L;

        List<Long> test2 = Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L);
        Long test2CommonRatio = 3L;

        List<Long> test3 = Arrays.asList(1L, 5L, 5L, 25L, 125L);
        Long test3CommonRatio = 5L;

        Assert.assertThat(countTriplets(test1, test1CommonRatio), is(2L));
        Assert.assertThat(countTriplets(test2, test2CommonRatio), is(6L));
        Assert.assertThat(countTriplets(test3, test3CommonRatio), is(4L));
    }
}
