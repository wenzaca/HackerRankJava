package com.hackerrank.interview.recursion;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

import java.util.Scanner;

public class Fibonacci {

    static int firstValue = 0;
    static int secondValue = 1;
    static int counter = 0;

    public static int fibonacci(int n) {

        if(n == 0) return 0;
        if (n!=counter+1) {
            fibonacci(n-1);
            int temp = firstValue;
            firstValue = secondValue + firstValue;
            secondValue = temp;
        }

        return firstValue+secondValue;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }

    public static void reset(){
        firstValue = 0;
        secondValue = 1;
        counter = 0;
    }

    @Test
    public void testSolution(){
        Assert.assertThat(fibonacci(5), is(5));
        reset();
        Assert.assertThat(fibonacci(0), is(0));
        reset();
        Assert.assertThat(fibonacci(1), is(1));
        reset();
        Assert.assertThat(fibonacci(2), is(1));
        reset();
        Assert.assertThat(fibonacci(3), is(2));
        reset();
        Assert.assertThat(fibonacci(6), is(8));

    }
}
