package com.hackerrank.interview.array;

import junit.framework.Assert;
import org.junit.Test;

/*
Function Description

Complete the function minimumSwaps in the editor below. It must return an integer representing the minimum number of swaps to sort the array.

minimumSwaps has the following parameter(s):

arr: an unordered array of integers

https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 */
public class MinimumSwap2 {

    private int countSwap(Integer[] array) {

        int myArrayIndex = 1;
        int result = 0;
        while (myArrayIndex < array.length) {

            int myValue = array[myArrayIndex];


            if (myArrayIndex + 1 == array[myArrayIndex] | myValue < array[myArrayIndex - 1] && myArrayIndex + 1 > myValue) {
                Integer whoIsInMyPosition = array[myValue - 1];
                array[myValue - 1] = myValue;
                array[myArrayIndex] = whoIsInMyPosition;
                result++;
            }
            myArrayIndex++;

            if (myArrayIndex == array.length && !isSorted(array)) {
                myArrayIndex = 1;
            }
        }

        return result;
    }

    private static boolean isSorted(Integer[] array) {
        int prev = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < prev) {
                return false;
            }
            prev = array[i];
        }
        return true;
    }

    @Test
    public void testCountingSwaps() {
        Integer[] test1 = {7, 1, 3, 2, 4, 5, 6};
        Integer[] test2 = {4, 3, 1, 2};
        Integer[] test3 = {2, 3, 4, 1, 5};

        Assert.assertEquals(5, countSwap(test1));
        Assert.assertEquals(3, countSwap(test2));
        Assert.assertEquals(3, countSwap(test3));
    }
}
