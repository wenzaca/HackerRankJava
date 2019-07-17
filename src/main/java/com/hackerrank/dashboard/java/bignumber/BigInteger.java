package com.hackerrank.dashboard.java.bignumber;

import java.util.Scanner;

public class BigInteger {

    private final static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String a = scan.nextLine();

        java.math.BigInteger bigIntegerA = new java.math.BigInteger(a);

        String b = scan.nextLine();

        java.math.BigInteger bigIntegerB = new java.math.BigInteger(b);

        System.out.println(bigIntegerA.add(bigIntegerB));
        System.out.println(bigIntegerA.multiply(bigIntegerB));

        scan.close();
    }
}
