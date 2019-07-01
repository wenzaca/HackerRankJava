package com.hackerrank.dashboard.algorithms.implementation;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;

public class MigratoryBirds {
    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {

        arr.sort(Integer::compareTo);
        int majorAmount = 0;
        int birdResult = 0;
        Integer temp = arr.get(0);
        int count = 0;
        for(Integer bird : arr){
            if(bird != temp) {
                if(count>majorAmount) {
                    majorAmount = count;
                    birdResult = temp;
                }
                System.out.println(temp + ": " +count);
                count = 0;
            }
            temp = bird;
            count++;
        }

        if(count>majorAmount) {
            majorAmount = count;
            birdResult = temp;
        }

    return birdResult;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = migratoryBirds(arr);

        System.out.println(result);
        bufferedReader.close();
    }

    @Test
    public void testSolution(){
        Assert.assertThat(migratoryBirds(Arrays.asList(1,4,4,4,5,3)), is(4));
        Assert.assertThat(migratoryBirds(Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4)), is(3));
    }
}
