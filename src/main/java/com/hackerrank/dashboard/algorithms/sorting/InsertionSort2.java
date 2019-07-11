package com.hackerrank.dashboard.algorithms.sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;

public class InsertionSort2 {
    // Complete the insertionSort2 function below.
    static int[] insertionSort2(int n, int[] arr) {

        for (int i = 1; i < n; i++) {
            int actualValue = arr[i];

            for (int j = i - 1; j >= 0; j--) {
                if (actualValue > arr[j]) break;
                if (actualValue < arr[j]) {
                    arr[j + 1] = arr[j];
                    arr[j] = actualValue;
                }
            }
            printArray(arr);
        }

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

        insertionSort2(n, arr);

        scanner.close();
    }


    @Test
    public void testSolution() {
        Assert.assertThat(insertionSort2(7, new int[]{3, 4, 7, 5, 6, 2, 1}), is(new int[]{1, 2, 3, 4, 5, 6, 7}));
        Assert.assertThat(insertionSort2(6, new int[]{1, 4, 3, 5, 6, 2}), is(new int[]{1, 2, 3, 4, 5, 6}));
    }
}
