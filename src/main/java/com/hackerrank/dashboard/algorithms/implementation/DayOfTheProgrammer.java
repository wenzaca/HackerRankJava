package com.hackerrank.dashboard.algorithms.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DayOfTheProgrammer {
    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {

        if (year > 1918) return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) ? "12.09." + year : "13.09." + year;
        else if(year == 1918) return "26.09." + year;
        else return (year % 4 == 0) ? "12.09." + year : "13.09." + year;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        System.out.println(result);

        bufferedReader.close();
    }
}

