package com.hackerrank.interview.stringmanipulation;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;

//TODO failing in time complexity
public class SpecialPalindromo {

    static String string = "";
    static long result = 0l;

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {

        string = s;
        result = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {

            char[] subChars = Arrays.copyOfRange(chars, i, n);
            if (subChars.length == 1) break;
            getResult(subChars, subChars.length);

        }

        return result + n;
    }

    private static void getResult(char[] chars, int j) {
        while (j > 1) {
            j--;
            if (chars[0] == chars[j]) {
                String beginString = "", endString = "";
                int begin, lenght = j;

                if (j % 2 == 0) {
                    lenght++;
                }
                for (begin = 0; begin < lenght / 2; begin++) {
                    beginString += chars[begin];
                }
                for (begin = begin + 1; begin < lenght; begin++) {
                    endString += chars[begin];
                }
                if (beginString.isEmpty() || endString.isEmpty()) {
                    result++;
                    continue;
                }
                if (beginString.equals(endString) && beginString.replace(String.valueOf(beginString.charAt(0)), "").length() == 0 && endString.replace(String.valueOf(endString.charAt(0)), "").length() == 0)
                    result++;
            }
        }
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        scanner.close();
    }

    @Test
    public void testSolution() {
        Assert.assertThat(substrCount(5, "asasd"), is(7L));
        Assert.assertThat(substrCount(7, "abcbaba"), is(10L));
        Assert.assertThat(substrCount(4, "aaaa"), is(10L));

    }
}
