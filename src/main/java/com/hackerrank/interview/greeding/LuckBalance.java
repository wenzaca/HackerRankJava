package com.hackerrank.interview.greeding;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;

public class LuckBalance {
    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
        int result = 0;
        int[] valueable = new int[contests.length];
        for (int i = 0; i < contests.length; i++) {

            if (contests[i][1] == 0) {
                result += contests[i][0];
            } else {
                valueable[i] = contests[i][0];
            }
        }
        Arrays.sort(valueable);
        int counter = 0;
        for (int i = valueable.length - 1; i >= 0; i--) {
            if (k > 0) {
                result += valueable[valueable.length - k];
                k--;
            } else {
                result -= valueable[i];
            }
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);
        System.out.println(result);
        scanner.close();
    }

    @Test
    public void testSolution() {
        Assert.assertThat(luckBalance(3, new int[][]{{5, 1}, {2, 1}, {1, 1}, {8, 1}, {10, 0}, {5, 0}}), is(29));
        Assert.assertThat(luckBalance(1, new int[][]{{5, 1}, {1, 1}, {4, 0}}), is(8));
        Assert.assertThat(luckBalance(2, new int[][]{{5, 1}, {1, 1}, {4, 0}}), is(10));
        Assert.assertThat(luckBalance(0, new int[][]{{5, 1}, {1, 1}, {4, 0}}), is(-2));
        Assert.assertThat(luckBalance(5, new int[][]{{13, 1}, {10, 1}, {9, 1}, {8, 1}, {13, 1}, {12, 1}, {18, 1}, {13, 1}}), is(42));

    }
}