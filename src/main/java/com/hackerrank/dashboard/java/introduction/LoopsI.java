package com.hackerrank.dashboard.java.introduction;

import java.util.Scanner;

public class LoopsI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < 11; i++) {
            System.out.println(n + " x " + i + " = " + n * i);
        }
    }
}
