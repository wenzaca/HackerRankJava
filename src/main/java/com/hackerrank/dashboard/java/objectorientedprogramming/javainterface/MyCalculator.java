package com.hackerrank.dashboard.java.objectorientedprogramming.javainterface;

class MyCalculator implements AdvancedArithmetic {
    public int divisor_sum(int n) {
        int soma = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                soma += i;
            }
        }
        return soma;
    }
}