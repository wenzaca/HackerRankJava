package com.hackerrank.interview.miscellaneous;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;

public class FlippingBits {

    // Complete the flippingBits function below.
    static long flippingBits(long n) {
        String binary = Long.toBinaryString(n);
        binary = binary.replaceAll("0", "2");
        binary = binary.replaceAll("1", "0");
        binary = binary.replaceAll("2", "1");
        while (binary.length() < 32) {
            binary = "1" + binary;
        }
        return Long.parseLong(binary, 2);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            long n = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            System.out.println(flippingBits(n));

        }

        scanner.close();
    }

    @Test
    public void testSolution() {
        Assert.assertThat(flippingBits(2147483647l), is(2147483648l));
        Assert.assertThat(flippingBits(0l), is(4294967295l));
        Assert.assertThat(flippingBits(1l), is(4294967294l));
        Assert.assertThat(flippingBits(802743475l), is(3492223820l));
        Assert.assertThat(flippingBits(35601423l), is(4259365872l));

    }
}
