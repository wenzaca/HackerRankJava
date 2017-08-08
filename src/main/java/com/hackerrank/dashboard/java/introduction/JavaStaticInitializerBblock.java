package com.hackerrank.dashboard.java.introduction;

import java.util.Scanner;

public class JavaStaticInitializerBblock {

	static Scanner sc = new Scanner(System.in);
	private static int H = sc.nextInt();
	private static int B = sc.nextInt();
	private static boolean flag = test();

	public static boolean test() {
		if (H <= 0 || B <= 0) {
			System.out.println("java.lang.Exception: Breadth and height must be positive");
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		if (flag) {
			int area = B * H;
			System.out.print(area);
		}

	}

}
