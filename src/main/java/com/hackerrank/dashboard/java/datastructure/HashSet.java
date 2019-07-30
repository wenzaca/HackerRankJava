package com.hackerrank.dashboard.java.datastructure;

import java.util.Scanner;
import java.util.Set;

public class HashSet {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String[] pair_left = new String[t];
        String[] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        Set<String> stringsSet = new java.util.HashSet<>();
        for (int i = 0; i < pair_left.length; i++) {
            stringsSet.add(pair_left[i] + " " + pair_right[i]);
            System.out.println(stringsSet.size());
        }
    }
}
