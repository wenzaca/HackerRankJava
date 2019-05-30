package com.hackerrank.dashboard.java.introduction;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class CurrencyFormatter {

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        String us, india, china, france;

        DecimalFormat df = new DecimalFormat("0.00");
        payment = (Double) df.parse(df.format(payment));

        france = NumberFormat.getNumberInstance(Locale.FRANCE).format(payment);
        us = NumberFormat.getNumberInstance(Locale.US).format(payment);
        china = NumberFormat.getNumberInstance(Locale.CHINA).format(payment);
        india = NumberFormat.getNumberInstance(Locale.US).format(payment);

        System.out.println("US: $" + us);
        System.out.println("India: Rs." + india);
        System.out.println("China: ¥" + china);
        System.out.println("France: " + france + " €");
    }
}
