package com.hackerrank.interview.sorting;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

import java.util.Arrays;
import java.util.List;

/*
Given an array of integers, sort the array in ascending order using the Bubble Sort algorithm above. Once sorted, print the following three lines:

Array is sorted in numSwaps swaps., where numSwaps is the number of swaps that took place.
First Element: firstElement, where firstElement is the first element in the sorted array.
Last Element: lastElement, where lastElement is the last element in the sorted array.

https://www.hackerrank.com/challenges/ctci-bubble-sort/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
*/
public class BubbleSort {

    private static List<String> countSwap(int[] array){
        int result =0;
        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array.length - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    result++;
                }
            }
        }

        return Arrays.asList("Array is sorted in "+result+" swaps.","First Element: "+array[0],"Last Element: "+array[array.length-1]);
    }

    private static void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    @Test
    public void  validateCountOfSwaps(){
        Assert.assertThat(countSwap(new int[]{3,2,1}), is(Arrays.asList("Array is sorted in 3 swaps.","First Element: 1","Last Element: 3")));
        Assert.assertThat(countSwap(new int[]{6,4,1}), is(Arrays.asList("Array is sorted in 3 swaps.","First Element: 1","Last Element: 6")));
        Assert.assertThat(countSwap(new int[]{1,3,1}), is(Arrays.asList("Array is sorted in 1 swaps.","First Element: 1","Last Element: 3")));
    }


}
