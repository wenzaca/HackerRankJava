package com.hackerrank.dashboard.algorithms.sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;

public class IntroToTutorialChallenges {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the introTutorial function below.
    static int introTutorial(int V, int[] arr) {

        int counter = 0;
        for (int value : arr) {
            if (value == V) return counter;
            counter++;
        }
        return counter;

    }

    public static void main(String[] args) {

        int V = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = introTutorial(V, arr);

        System.out.println(result);

        scanner.close();
    }

    @Test
    public void testSolution() {
        Assert.assertThat(introTutorial(4, new int[]{1, 4, 5, 7, 9, 12}), is(1));
    }
}
