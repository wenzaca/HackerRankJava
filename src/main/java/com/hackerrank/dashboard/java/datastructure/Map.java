package com.hackerrank.dashboard.java.datastructure;

import java.util.HashMap;
import java.util.Scanner;

public class Map {


    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        java.util.Map<String, Integer> phoneMap = new HashMap<>(n);

        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            phoneMap.put(name, phone);
            in.nextLine();
        }
        while (in.hasNext()) {
            String s = in.nextLine();
            Integer phoneMapValue = phoneMap.getOrDefault(s, Integer.MIN_VALUE);
            if (phoneMapValue == Integer.MIN_VALUE)
                System.out.println("Not found");
            else
                System.out.println(s + "=" + phoneMapValue);
        }
    }
}

