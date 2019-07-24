package com.hackerrank.dashboard.java.datastructure;

import java.util.Scanner;

public class Subarray {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }

        int result = 0;

        for (int i = 0; i < n - 1; i++) {
            if (a[i] < 0) result++;
            int sum = 0;
            for (int j = i + 1; j < n; j++) {
                sum += a[j];
                if (a[i] + sum < 0) result++;
            }
        }

        if (a[a.length - 1] < 0) result++;

        System.out.println(result);

        scan.close();
    }
}
