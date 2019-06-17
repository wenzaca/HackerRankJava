package com.hackerrank.interview.miscellaneous;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;

public class TimeComplexityPrimality {

    // Complete the primality function below.
    static String primality(int n) {

        if (n < 2) return "Not prime";
        if (n < 4) return "Prime";
        if (n % 2 == 0) return "Not prime";
        for (int i = 3; i < n; i += 2) {
            if (n % i == 0) {
                return "Not prime";
            }

        }
        return "Prime";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int pItr = 0; pItr < p; pItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            System.out.println(primality(n));

        }


        scanner.close();
    }

    @Test
    public void testSolution() {
        Assert.assertThat(primality(0), is("Not prime"));
        Assert.assertThat(primality(1), is("Not prime"));
        Assert.assertThat(primality(2), is("Prime"));
        Assert.assertThat(primality(3), is("Prime"));
        Assert.assertThat(primality(19), is("Prime"));
        Assert.assertThat(primality(5), is("Prime"));
        Assert.assertThat(primality(29), is("Prime"));
        Assert.assertThat(primality(12), is("Not prime"));
    }
}
