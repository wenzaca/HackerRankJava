package com.hackerrank.interview.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Function Description

Complete the function rotLeft in the editor below. It should return the resulting array of integers.

rotLeft has the following parameter(s):

An array of integers array.
An integer rotation, the number of rotations.

https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays

 */
public class LeftRotation {

    private int[] rotateLevel(int[] array, int rotation) {

        List<Integer> ints = Arrays.stream(array).boxed().collect(Collectors.toList());
        List<Integer> integersInitial = ints.subList(0, rotation);
        List<Integer> integerFinal = ints.subList(rotation, ints.size());
        integerFinal.addAll(integersInitial);
        return integerFinal.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void testRotateList() {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array1Res = {5, 1, 2, 3, 4};

        int[] array2 = {1, 2, 3, 4, 5};
        int[] array2Res = {3, 4, 5, 1, 2};

        Assert.assertArrayEquals(array1Res, rotateLevel(array1, 4));
        Assert.assertArrayEquals(array2Res, rotateLevel(array2, 2));
    }
}
