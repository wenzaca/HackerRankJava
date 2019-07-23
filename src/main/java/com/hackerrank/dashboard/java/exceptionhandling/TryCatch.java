package com.hackerrank.dashboard.java.exceptionhandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatch {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        try {
            int int1 = scanner.nextInt();
            int int2 = scanner.nextInt();
            System.out.println(int1/int2);
        } catch(InputMismatchException e){
            System.out.println(e.getClass().getName());
        } catch (ArithmeticException e){
            System.out.println(e);
        }
        scanner.close();
    }
}
