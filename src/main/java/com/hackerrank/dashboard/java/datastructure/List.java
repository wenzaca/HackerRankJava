package com.hackerrank.dashboard.java.datastructure;

import java.util.ArrayList;
import java.util.Scanner;

public class List {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Integer n = scanner.nextInt();

        java.util.List<Integer> integers = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            integers.add(scanner.nextInt());
        }

        Integer q = scanner.nextInt();

        for (int i = 0; i < q; i++) {
            String next = scanner.next();
            if (next.equals("Insert")) {
                int x = scanner.nextInt();
                Integer y = scanner.nextInt();
                integers.add(x, y);
            } else {
                int x = scanner.nextInt();
                integers.remove(x);
            }
        }

        for (Integer value : integers) {
            System.out.print(value + " ");
        }
    }
}
