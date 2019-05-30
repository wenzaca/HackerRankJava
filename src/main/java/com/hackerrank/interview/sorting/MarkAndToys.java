package com.hackerrank.interview.sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;

/*
Function Description

Complete the function maximumToys in the editor below. It should return an integer representing the maximum number of toys Mark can purchase.

maximumToys has the following parameter(s):

prices: an array of integers representing toy prices
k: an integer, Mark's budget

https://www.hackerrank.com/challenges/mark-and-toys/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
*/
public class MarkAndToys {

    static int maximumToys(int[] prices, int k) {

        Arrays.sort(prices);
        int result = 0, counter = 0;
        if (prices[counter] > k) return 0;
        if (prices[counter] == k) return 1;
        while (result + (prices[counter]) < k) {
            result += prices[counter];
            counter++;
            if (counter == prices.length) return counter;
        }
        return counter;
    }

    @Test
    public void testToyPriceCanBuy() {
        int[] test1 = {1, 2, 3, 4};
        int[] test2 = {1, 12, 5, 111, 200, 1000, 10};
        int[] test3 = {2, 12, 5, 111, 200, 1000, 10};
        Assert.assertThat(3, is(maximumToys(test1, 7)));
        Assert.assertThat(4, is(maximumToys(test2, 50)));
        Assert.assertThat(0, is(maximumToys(test3, 1)));
        Assert.assertThat(1, is(maximumToys(test3, 2)));
        Assert.assertThat(test3.length, is(maximumToys(test3, 5000)));
    }
}
