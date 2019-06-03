package com.hackerrank.interview.sorting;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class MergeSort {

 public static long sort(int[] array) {

        long counter=0;

        for (int j = 1; j <= array.length - 1; j++) {
            int i;
            Integer newElement = array[j];
            for (i = j - 1; i >= 0; i--) {
                if (newElement >= array[i]) {
                    break;
                } else {
                    array[i + 1] = array[i];
                }
            }
            if(i<=j-2){
                counter+=j-1-i;
            }
            array[i + 1] = newElement;
        }

        return counter;
    }

    @Test
    public void testSolution(){

        Assert.assertThat(sort(new int[]{1,1,1,2,2}), is(0L));
        Assert.assertThat(sort(new int[]{2,1,3,1,2}), is(4L));
    }
}
