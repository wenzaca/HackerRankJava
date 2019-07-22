package com.hackerrank.dashboard.java.bignumber;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;

public class BigDecimal {

    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();

        s = insertionSort(s, n);

        for(int i=0;i<n;i++)
        {

            System.out.println(s[i]);
        }
    }

    private static String[] insertionSort(String[] stringArray, int n){
        String[] tempArray = new String[n];

        tempArray[n-1] = stringArray[0];

        for(int i=n-2; i >= 0; i--) {

            java.math.BigDecimal bigDecimal = new java.math.BigDecimal(stringArray[n-i-1]);

            int j = i-1;

            while(j<n-2 && bigDecimal.compareTo(new java.math.BigDecimal(tempArray[j+2])) <= 0) {
                tempArray[j+1] = tempArray[j+2];
                j = j + 1;
            }

            tempArray[j+1] = stringArray[n-i-1];
        }
        return tempArray;
    }

    @Test
    public void testSolution() {
        Assert.assertThat(insertionSort(new String[]{"-100","50","0","56.6","90","0.12",".12","02.34","000.000"},9), is(new String[]{"90","56.6","50","02.34","0.12",".12","0","000.000","-100"}));
    }

}

