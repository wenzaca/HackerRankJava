package com.hackerrank.dashboard.algorithms.implementation;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;

public class BonAppetit {

    // Complete the bonAppetit function below.
    static String bonAppetit(List<Integer> bill, int k, int b) {

        int counter = 0;
        int result = 0;
        for (Integer eachBill : bill) {
            if (counter != k) {
                result += eachBill;
            }
            counter++;
        }
        result = b - result / 2;
        return result == 0 ? "Bon Appetit" : String.valueOf(result);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        List<Integer> bill = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        System.out.println(bonAppetit(bill, k, b));

        bufferedReader.close();
    }

    @Test
    public void testSolution() {
        Assert.assertThat(bonAppetit(Arrays.asList(3, 10, 2, 9), 1, 12), is("5"));
        Assert.assertThat(bonAppetit(Arrays.asList(3, 10, 2, 9), 1, 7), is("Bon Appetit"));
    }
}
