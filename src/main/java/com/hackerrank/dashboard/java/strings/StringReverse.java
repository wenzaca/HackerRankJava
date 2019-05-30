package com.hackerrank.dashboard.java.strings;

import java.util.Scanner;

public class StringReverse {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        StringBuilder sb = new StringBuilder(A);
        if (sb.reverse().toString().equals(A))
            System.out.println("Yes");
        else
            System.out.println("No");
        sc.close();
    }
}
