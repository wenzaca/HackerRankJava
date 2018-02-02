package com.hackerrank.dashboard.algorithms.implementation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BetweenTwoSets {

    static int getTotalX(Integer[] a, Integer[] b) {

        Arrays.sort(a);
        int maxA = a[a.length - 1];
        Arrays.sort(b);
        int maxB = b[0];
        int result = 0;
        boolean aBoolean = false;
        boolean bBoolean = false;
        List<Integer> integersA = Arrays.asList(a);
        List<Integer> integersB = Arrays.asList(b);
        while (maxA <= maxB) {
            for (Integer integerA : integersA) {
                if (maxA % integerA != 0) {
                    aBoolean = false;
                    break;
                }
                aBoolean = true;
            }
            for (Integer integerB : integersB) {
                if (integerB % maxA != 0) {
                    bBoolean = false;
                    break;
                }
                bBoolean = true;
            }
            if (aBoolean && bBoolean)
                result++;
            maxA++;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Integer[] a = new Integer[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        Integer[] b = new Integer[m];
        for (int b_i = 0; b_i < m; b_i++) {
            b[b_i] = in.nextInt();
        }
        int total = getTotalX(a, b);
        System.out.println(total);
        in.close();
    }
}
