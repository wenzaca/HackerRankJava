package com.hackerrank.dashboard.algorithms.sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;

public class InsertionSort {
    // Complete the insertionSort1 function below.
    static int[] insertionSort1(int n, int[] arr) {
        int e = arr[n - 1];
        int i = 0;
        for (i = n - 2; i >= 0 && arr[i] > e; i--) {
            arr[i + 1] = arr[i];
            printArray(arr);
        }
        arr[i + 1] = e;
        printArray(arr);
        return arr;
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        insertionSort1(n, arr);

        scanner.close();
    }

    @Test
    public void testSolution() {
        Assert.assertThat(insertionSort1(5, new int[]{1, 2, 4, 5, 3}), is(new int[]{1, 2, 3, 4, 5}));
        Assert.assertThat(insertionSort1(5, new int[]{2, 3, 4, 5, 1}), is(new int[]{1, 2, 3, 4, 5}));
    }
}
