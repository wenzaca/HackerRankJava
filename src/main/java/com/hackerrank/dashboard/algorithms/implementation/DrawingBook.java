package com.hackerrank.dashboard.algorithms.implementation;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;

public class DrawingBook {

    /*
     * Complete the pageCount function below.
     */
    static int pageCount(int n, int p) {

        if (p == 1 || p == n || (n%2==1 && n-p<2)) return 0;
        int fromTheEnd = 0;
        if(n%2==0){
            fromTheEnd = (n-p+1)/2;
        } else {
            fromTheEnd = (n-p)/2;
        }

        return (n / 2)+1 > p ?  p/2 : fromTheEnd;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);

        System.out.println(result);


        scanner.close();
    }

    @Test
    public void testSolution() {
        Assert.assertThat(pageCount(6,2), is(1));
        Assert.assertThat(pageCount(7,4), is(1));
        Assert.assertThat(pageCount(7,7), is(0));
        Assert.assertThat(pageCount(7,1), is(0));
        Assert.assertThat(pageCount(5,4), is(0));
        Assert.assertThat(pageCount(8,4), is(2));
        Assert.assertThat(pageCount(7,3), is(1));
    }
}
