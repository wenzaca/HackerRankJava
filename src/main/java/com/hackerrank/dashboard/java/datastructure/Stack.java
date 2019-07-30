package com.hackerrank.dashboard.java.datastructure;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Scanner;

public class Stack {
    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);

        java.util.Map<Character, Character> openingClosingBrackets = new HashMap<>(3);
        openingClosingBrackets.put('{', '}');
        openingClosingBrackets.put('[', ']');
        openingClosingBrackets.put('(', ')');


        while (sc.hasNext()) {
            String input = sc.next();

            String result = "";

            ArrayDeque<Character> opening = new ArrayDeque<>();

            for (Character c : input.toCharArray()) {
                if (openingClosingBrackets.containsKey(c)) {
                    opening.push(c);
                } else if (openingClosingBrackets.values().contains(c)) {

                    if (opening.size() == 0 || !openingClosingBrackets.get(opening.pop()).equals(c)) {
                        result = "false";
                        break;
                    }
                }
            }
            if (result.isEmpty()) {
                if (opening.size() != 0)
                    result = "false";
                else
                    result = "true";
            }
            System.out.println(result);
        }
    }


}
