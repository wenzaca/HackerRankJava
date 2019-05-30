package com.hackerrank.dashboard.algorithms.implementation;

import java.util.Scanner;

public class BeautifulDaysAtTheMovies {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int d1 = in.nextInt();
        int d2 = in.nextInt();
        int k = in.nextInt();
        int db = 0;
        while (d1 <= d2) {
            if ((d1 - reverse(d1)) % k == 0)
                db++;
            d1++;
        }
        System.out.println(db);

    }

    static int reverse(int value) {
        StringBuffer sb = new StringBuffer(String.valueOf(value));
        return Integer.parseInt(sb.reverse().toString());
    }
}
