package com.hackerrank.interview.greeding;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;

/*
Complete the minimumAbsoluteDifference function in the editor below. It should return an integer that represents the minimum absolute difference between any pair of elements.

minimumAbsoluteDifference has the following parameter(s):

n: an integer that represents the length of arr
arr: an array of integers
 */
public class MinimumAbsoluteDifferenceArray {

    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(Integer[] arr) {

        int resLow = Integer.MAX_VALUE;

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            Integer abs = Math.abs(arr[i] - arr[i + 1]);
            if (abs < resLow) {
                resLow = abs;
            }
        }

        return resLow;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        Integer[] arr = new Integer[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            Integer arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = minimumAbsoluteDifference(arr);

        scanner.close();
    }

    @Test
    public void testSolution() {
        Assert.assertThat(minimumAbsoluteDifference(new Integer[]{1, -3, 71, 68, 17}), is(3));
        Assert.assertThat(minimumAbsoluteDifference(new Integer[]{-59, -36, -13, 1, -53, -92, -2, -96, -54, 75}), is(1));
        Assert.assertThat(minimumAbsoluteDifference(new Integer[]{3, -7, 0}), is(3));

    }
}
