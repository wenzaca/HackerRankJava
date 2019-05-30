package com.hackerrank.dashboard.algorithms.implementation;

import java.util.Scanner;

public class UtopianTree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int size = 1;
            for (int i = 0; i < n; i++) {
                if (n > 0) {
                    if (i % 2 != 0) {
                        size++;
                    } else {
                        size = size * 2;
                    }
                }
            }
            System.out.println(size);
        }
    }
}
