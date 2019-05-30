package com.hackerrank.dashboard.java.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Anagrams {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }

    static boolean isAnagram(String a, String b) {
        List<String> chars = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) {
            chars.add(Character.toString(a.charAt(i)).toLowerCase());
        }
        for (int i = 0; i < b.length(); i++) {
            if (!chars.isEmpty()) {
                if (chars.contains(Character.toString(b.charAt(i)).toLowerCase()))
                    chars.remove(Character.toString(b.charAt(i)).toLowerCase());
            } else return false;
        }

        if (chars.isEmpty()) {
            return true;
        }
        return false;

    }
}
