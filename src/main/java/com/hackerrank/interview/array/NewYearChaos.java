package com.hackerrank.interview.array;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Function Description

Complete the function minimumBribes in the editor below. It must print an integer representing the minimum number of bribes necessary, or Too chaotic if the line configuration is not possible.

minimumBribes has the following parameter(s):

q: an array of integers
Input Format

The first line contains an integer t, the number of test cases.

Each of the next t pairs of lines are as follows:
- The first line contains an integer t, the number of people in the queue
- The second line has n space-separated integers describing the final state of the queue.

https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 */

public class NewYearChaos {

    private static final Scanner scanner = new Scanner(System.in);

    private static String validateQueue(Integer[] array) {
        int result = 0;
        int counter1 = 0;
        long initial = System.nanoTime();


        for (Integer myPosition : array) {
            if (myPosition > counter1 + 3) {
                long timeSpent = System.nanoTime() - initial;
                System.out.println("Time spent: " + timeSpent);
                return "Too chaotic";

            }
            counter1++;

        }
        while (!isSorted(array)) {
            int counter = 0;
            while (counter < array.length) {
                if (counter + 1 == array.length) {
                    break;
                }

                if (array[counter] < array[counter + 1]) {
                    counter++;
                    continue;
                }
                Integer integer1 = array[counter];
                Integer integer2 = array[counter + 1];
                array[counter] = integer2;
                array[counter + 1] = integer1;
                result++;
            }

        }
        long timeSpent = System.nanoTime() - initial;
        System.out.println("Time spent: " + timeSpent);
        return String.valueOf(result);
    }

    private static String validateQueueOld(Integer[] array) {

        long initial = System.nanoTime();
        int result = 0;
        int counter = 0;

        boolean isQueueNotLined = true;

        Map<Integer, Integer> meAndMyMoves = new HashMap<>();
        for (Integer myPosition : array) {
            meAndMyMoves.put(myPosition, 0);
        }
        while (isQueueNotLined) {
            counter = 0;
            while (counter < array.length) {
                if (counter + 1 == array.length) {
                    break;
                }

                if (array[counter] < array[counter + 1]) {
                    counter++;
                    continue;
                }
                Integer integer1 = array[counter];
                Integer integer2 = array[counter + 1];
                meAndMyMoves.put(array[counter], meAndMyMoves.get(array[counter]) + 1);
                array[counter] = integer2;
                array[counter + 1] = integer1;

                //counter = 0;
            }

            if (isSorted(array)) isQueueNotLined = false;

        }
        Collection<Integer> values = meAndMyMoves.values();
        for (Integer moves : values) {
            if (moves > 2) {
                long timeSpent = System.nanoTime() - initial;
                System.out.println("Time spent old: " + timeSpent);
                return "Too chaotic";
            }
            result += moves;
        }

        long timeSpent = System.nanoTime() - initial;
        System.out.println("Time spent old: " + timeSpent);
        return String.valueOf(result);
    }

    private static boolean isSorted(Integer[] array) {
        int prev = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < prev) {
                return false;
            }
            prev = array[i];
        }
        return true;
    }

    @Test
    public void checkNewYearQueue() {
        Integer[] test1 = {2, 1, 5, 3, 4};
        Integer[] test2 = {2, 5, 1, 4, 3};
        Integer[] test3 = {1, 2, 5, 3, 4, 7, 8, 6};
        Integer[] test4 = {1, 2, 5, 3, 7, 8, 6, 4};
        Integer[] test5 = {2, 1, 5, 3, 4};
        Integer[] test6 = {2, 5, 1, 4, 3};
        Integer[] test7 = {1, 2, 5, 3, 4, 7, 8, 6};
        Integer[] test8 = {1, 2, 5, 3, 7, 8, 6, 4};

        Assert.assertEquals("3", validateQueue(test1));
        Assert.assertEquals("Too chaotic", validateQueue(test2));
        Assert.assertEquals("4", validateQueue(test3));
        Assert.assertEquals("7", validateQueue(test4));
        Assert.assertEquals("3", validateQueueOld(test5));
        Assert.assertEquals("Too chaotic", validateQueueOld(test6));
        Assert.assertEquals("4", validateQueueOld(test7));
        Assert.assertEquals("7", validateQueueOld(test8));
    }

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            Integer[] q = new Integer[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            System.out.println(validateQueue(q));
        }

        scanner.close();
    }
}
