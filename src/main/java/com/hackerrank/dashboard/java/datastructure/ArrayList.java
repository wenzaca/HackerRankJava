package com.hackerrank.dashboard.java.datastructure;

import java.util.List;
import java.util.Scanner;

public class ArrayList {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int nestedListSize = scan.nextInt();

        List<List<Integer>> nestedList = new java.util.ArrayList<>(nestedListSize);
        for (int i = 0; i < nestedListSize; i++) {
            int innerListSize = scan.nextInt();
            List<Integer> innerList = new java.util.ArrayList<>(innerListSize);

            for (int j = 0; j < innerListSize; j++) {
                innerList.add(scan.nextInt());
            }

            nestedList.add(innerList);
        }

        int numberOfQueries = scan.nextInt();

        for (int i = 0; i < numberOfQueries; i++) {
            int nestedQuery = scan.nextInt();
            int innerQuery = scan.nextInt();
            if (nestedList.size() - 1 >= nestedQuery) {
                List<Integer> innerList = nestedList.get(nestedQuery - 1);
                if (innerList.size() >= innerQuery) {
                    System.out.println(innerList.get(innerQuery - 1));
                } else {
                    System.out.println("ERROR!");
                }
            } else {
                System.out.println("ERROR!");
            }
        }

    }
}
