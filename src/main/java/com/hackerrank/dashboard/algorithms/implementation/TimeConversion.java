package com.hackerrank.dashboard.algorithms.implementation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TimeConversion {

    static String timeConversion(String s) throws ParseException {
        Date parse = null;
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss a");
        if (s.contains("PM")) {
            parse = format.parse(s.replace("PM", " PM"));
        } else {
            parse = format.parse(s.replace("AM", " AM"));
        }
        format = new SimpleDateFormat("HH:mm:ss");
        return format.format(parse);
    }

    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }
}
