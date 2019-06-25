package com.hackerrank.interview.graph;

import java.util.*;

public class RoadsAndLibraries {

    private static Map<Integer, List<Integer>> cityLink;
    private static boolean visited[];
    // Complete the roadsAndLibraries function below.
    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {

        if (c_lib <= c_road) return new Long(n) * new Long(c_lib);

        Long result = 0l;
        cityLink = new LinkedHashMap<>();
        visited = new boolean[n];
        for (int i = 0; i < cities.length; i++) {
            int city1 = cities[i][1];
            int city0 = cities[i][0];
            cityLink.compute(cities[i][0], (key, value) -> {
                if (value == null) {
                    value = new ArrayList<>();
                }
                value.add(city1);
                return value;
            });
            cityLink.compute(cities[i][1], (key, value) -> {
                if (value == null) {
                    value = new ArrayList<>();
                }
                value.add(city0);
                return value;
            });
        }

        for(Integer key : cityLink.keySet()){
            if(visited[key-1]==false){
                result+=c_lib;
            } else {
                result+=c_road;
            }
            DFSUtil(key);
        }

        for (Boolean hasBeenVisited:visited) {
            if(hasBeenVisited==false) result+=c_lib;
        }
        

        return result;
    }

    // A function used by DFS
    static void DFSUtil(int v)
    {
        // Mark the current node as visited and print it
        visited[v-1] = true;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = cityLink.get(v).listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n-1])
                DFSUtil(n);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nmC_libC_road = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmC_libC_road[0]);

            int m = Integer.parseInt(nmC_libC_road[1]);

            int c_lib = Integer.parseInt(nmC_libC_road[2]);

            int c_road = Integer.parseInt(nmC_libC_road[3]);

            int[][] cities = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] citiesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowItems[j]);
                    cities[i][j] = citiesItem;
                }
            }

            long result = roadsAndLibraries(n, c_lib, c_road, cities);

            System.out.println(result);
        }

        scanner.close();
    }
}

