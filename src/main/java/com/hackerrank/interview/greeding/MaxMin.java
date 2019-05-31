package com.hackerrank.interview.greeding;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;

public class MaxMin {
    // Complete the maxMin function below.
    static int maxMin(int k, int[] arr) {

        Arrays.sort(arr);
        int minUnfairness = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - k + 1; i++) {
            int possibleMin = arr[i + k - 1] - arr[i];
            if (possibleMin < minUnfairness) {
                minUnfairness = possibleMin;
            }
        }
        return minUnfairness;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        System.out.println(maxMin(k, arr));

        scanner.close();
    }


    @Test
    public void testSolution() {
        Assert.assertThat(maxMin(3, new int[]{100, 200, 300, 350, 400, 401, 402}), is(2));
        Assert.assertThat(maxMin(3, new int[]{10, 100, 300, 200, 1000, 20, 30}), is(20));
        Assert.assertThat(maxMin(2, new int[]{1, 2, 1, 2, 1}), is(0));
    }
}

