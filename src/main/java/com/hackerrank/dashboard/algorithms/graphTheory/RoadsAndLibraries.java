package com.hackerrank.dashboard.algorithms.graphTheory;

import java.util.Scanner;

public class RoadsAndLibraries {

    private static int total;
    private static boolean[] visited;
    private static int[][] adjCities;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt(); // number of queries
        for (int a0 = 0; a0 < q; a0++) {
            int cities = in.nextInt(); // number of cities
            int roads = in.nextInt(); // number of roads
            int libCost = in.nextInt(); // cost of building a library
            //System.out.println("Cost of building library: "+libCost);
            int roadCost = in.nextInt(); // cost of repairing a road
            //System.out.println("Cost of repairing road: "+roadCost);

            if (roadCost >= libCost) { // optimal scenario
                total = libCost * cities;
            } else {

                visited = new boolean[cities];

                adjCities = new int[cities][cities];

                //initializing adjacency matrix
                for (int i = 0; i < roads; i++) {
                    int c1 = in.nextInt();
                    int c2 = in.nextInt();

                    adjCities[c1 - 1][c1 - 1] = c1;
                    adjCities[c2 - 1][c2 - 1] = c2;
                    dfs(c1);
                }

            }

            System.out.println(total);
        }
    }

    private static void dfs(int city) {
        visited[city] = true;
        for (int c : adjCities[city]) {
            if (!visited[c]) {
                //total += roadCost;
                dfs(c);
            }
        }
    }

}

