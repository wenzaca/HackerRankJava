package com.hackerrank.dashboard.algorithms.implementation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BreakingTheRecords {
    static Integer[] breakingRecords(Integer[] scores) {
        List<Integer> scoreList = Arrays.asList(scores);
        int max = scoreList.get(0);
        int min = scoreList.get(0);
        int counterMin = 0, counterMax = 0;
        for (Integer score : scores) {
            if (score > max) {
                counterMax++;
                max = score;
            }
            if (score < min) {
                counterMin++;
                min = score;
            }


        }
        Integer[] result = {counterMax, counterMin};
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] score = new Integer[n];
        for (int score_i = 0; score_i < n; score_i++) {
            score[score_i] = in.nextInt();
        }
        Integer[] result = breakingRecords(score);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
