package com.hackerrank.dashboard.java.strings.regex;

import java.util.Scanner;

public class Regex {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String IP = in.next();
			System.out.println(IP.matches(new MyRegex().pattern));
		}
in.close();
	}
}
