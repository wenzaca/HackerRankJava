package com.hackerrank.dashboard.algorithms.warmup;

import java.util.Scanner;

public class BirthdayCakeCandles {
	static int birthdayCakeCandles(int n, int[] ar) {
		int ov = 0, count = 0;
		for (int v : ar) {
			if (v > ov) {
				ov = v;
				count = 1;
			} else if (v == ov) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for (int ar_i = 0; ar_i < n; ar_i++) {
			ar[ar_i] = in.nextInt();
		}
		int result = birthdayCakeCandles(n, ar);
		System.out.println(result);
	}

}
