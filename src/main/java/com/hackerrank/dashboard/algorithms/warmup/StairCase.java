package com.hackerrank.dashboard.algorithms.warmup;

import java.util.Scanner;

public class StairCase {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		StringBuilder hash = new StringBuilder();
		if (n != 0) {
			for (int i = 1; i <= n; i++) {
				for(int j=0;j<n;j++){
					if(j>=n-i){
						hash.append("#");
					}else{
						hash.append(" ");
					}
				}
				System.out.println(hash);
				hash =new StringBuilder();
			}
		} else {
			System.out.println("");
		}
	}
}
