package com.hackerrank.interview.array;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Array2D {

    private int hourglassSum(int[][] arr) {
        LinkedList<Integer> results = new LinkedList<>();
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                results.add(arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2]);
            }
        }
        results.sort(Integer::compareTo);
        return results.getLast();
    }

    @Test
    public void validateTheHourglassSum() {

        int[][] arr = new int[6][6];

        List<String[]> list = new ArrayList<>();

        list.add("1 1 1 0 0 0".split(" "));
        list.add("0 1 0 0 0 0".split(" "));
        list.add("1 1 1 0 0 0".split(" "));
        list.add("0 0 2 4 4 0".split(" "));
        list.add("0 0 0 2 0 0".split(" "));
        list.add("0 0 1 2 4 0 ".split(" "));
        int counter = 0;

        for (String[] row : list) {

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(row[j]);
                arr[counter][j] = arrItem;
            }
            counter++;
        }

        Assert.assertEquals(19, hourglassSum(arr));
    }
}
