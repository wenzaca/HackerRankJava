package com.hackerrank.dashboard.java.datastructure;

import java.util.Map;
import java.util.*;

public class Dequeue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<Integer>();
        Deque queue = new LinkedList<Integer>();
        int n = in.nextInt();
        int m = in.nextInt();

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.push(num);
        }
        int result = Integer.MIN_VALUE;

        Map<Integer, Integer> intsMap = new LinkedHashMap<>(n);

        for (int i = 0; i < m; i++) {
            Integer pop = (Integer) deque.pop();
            if (intsMap.containsKey(pop)) intsMap.computeIfPresent(pop, (key, value) -> value + 1);
            else intsMap.put(pop, 1);
            queue.push(pop);
            if (intsMap.size() > result) result = intsMap.size();
        }

        for (int i = n - 1; i > n - m - 1 || n != m; i--) {
            if (deque.size() == 0) break;
            Integer pop = (Integer) deque.pop();
            queue.push(pop);
            Integer remove = (Integer) queue.removeLast();
            if (intsMap.get(remove) == 1) {
                intsMap.remove(remove);
            } else {
                intsMap.put(remove, intsMap.get(remove) - 1);
            }

            if (intsMap.containsKey(pop)) {
                intsMap.computeIfPresent(pop, (key, value) -> value + 1);
            } else intsMap.put(pop, 1);

            if (intsMap.size() > result) result = intsMap.size();


        }

        System.out.println(result);

    }

}
