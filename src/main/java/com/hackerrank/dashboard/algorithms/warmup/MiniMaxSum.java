package com.hackerrank.dashboard.algorithms.warmup;

import java.util.Scanner;

public class MiniMaxSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        long sum = 0, res = 0, ma = 0, me = 0;
        for (int arr_i = 0; arr_i < 5; arr_i++) {
            arr[arr_i] = in.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                sum += arr[j];
            }
            res = sum - arr[i];
            sum = 0;
            if (i == 0) {
                ma = res;
                me = res;
            }
            if (res > ma)
                ma = res;
            if (res < me)
                me = res;
            res = 0;
        }
        System.out.println(me + " " + ma);
    }
}
