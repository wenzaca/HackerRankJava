package com.hackerrank.dashboard.java.datastructure;

import java.util.Scanner;

public class BitSet {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        java.util.BitSet b1 = new java.util.BitSet(n);

        java.util.BitSet b2 = new java.util.BitSet(n);


        for (int i = 0; i < m; i++) {
            String operation = scanner.next();
            Integer v1 = scanner.nextInt();
            Integer v2 = scanner.nextInt();

            switch (operation) {
                case ("AND"):
                    if(v1 == 1 && v2 == 2) b1.and(b2);
                    if(v1 == 2 && v2 == 1) b2.and(b1);
                    if(v1 == 1 && v2 == 1) b1.and(b1);
                    if(v1 == 2 && v2 == 2) b2.and(b2);
                    System.out.println(b1.cardinality() + " " + b2.cardinality());
                    break;
                case ("OR"):
                    if(v1 == 1 && v2 == 2) b1.or(b2);
                    if(v1 == 2 && v2 == 1) b2.or(b1);
                    if(v1 == 1 && v2 == 1) b1.or(b1);
                    if(v1 == 2 && v2 == 2) b2.or(b2);
                    System.out.println(b1.cardinality() + " " + b2.cardinality());
                    break;
                case ("XOR"):
                    if(v1 == 1 && v2 == 2) b1.xor(b2);
                    if(v1 == 2 && v2 == 1) b2.xor(b1);
                    if(v1 == 1 && v2 == 1) b1.xor(b1);
                    if(v1 == 2 && v2 == 2) b2.xor(b2);
                    System.out.println(b1.cardinality() + " " + b2.cardinality());
                    break;
                case ("FLIP"):
                    if(v1 == 1){
                        b1.flip(v2);
                    }
                    if(v1 == 2){
                        b2.flip(v2);
                    }
                    System.out.println(b1.cardinality() + " " + b2.cardinality());
                    break;
                default:
                    if(v1 == 1){
                        b1.set(v2);
                    }
                    if(v1 == 2){
                        b2.set(v2);
                    }
                    System.out.println(b1.cardinality() + " " + b2.cardinality());
                    break;
            }
        }
    }
}
