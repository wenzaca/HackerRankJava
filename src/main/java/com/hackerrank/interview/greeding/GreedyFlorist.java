package com.hackerrank.interview.greeding;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;

public class GreedyFlorist {
    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) {
        Arrays.sort(c);
        int increasePrice = 0;
        int result=0;
        int people = k;
        for(int i=c.length-1;i>=0;i--){
            if(k>0){
                k--;
            } else{
                increasePrice++;
                k=people-1;
            }
            result+=(increasePrice + 1) * c[i];
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        System.out.println(getMinimumCost(k, c));

        scanner.close();
    }

    @Test
    public void testSolution() {
        Assert.assertThat(getMinimumCost(3, new int[]{1,3,5,7,9}), is(29));
        Assert.assertThat(getMinimumCost(2, new int[]{2,5,6}), is(15));
        Assert.assertThat(getMinimumCost(3, new int[]{2,5,6}), is(13));
        String[] s = "390225 426456 688267 800389 990107 439248 240638 15991 874479 568754 729927 980985 132244 488186 5037 721765 251885 28458 23710 281490 30935 897665 768945 337228 533277 959855 927447 941485 24242 684459 312855 716170 512600 608266 779912 950103 211756 665028 642996 262173 789020 932421 390745 433434 350262 463568 668809 305781 815771 550800".split(" ");
        int [] arr = new int [50];
        for(int i=0; i<50; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        Assert.assertThat(getMinimumCost(3, arr), is(163578911));
    }
}

