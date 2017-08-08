package com.hackerrank.dashboard.java.introduction;

import java.util.Scanner;

public class JavaIntToString {

	public static void main(String[] args) {

		try {
			Scanner in = new Scanner(System.in);
			int n = in.nextInt();
			in.close();
			String s = String.valueOf(n);
			System.out.println(s);
			System.out.println("Good job");
		} catch (Exception e) {
			System.out.println("Wrong answer");
		}
	}

}
