package com.hackerrank.dashboard.java.advanced;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.System.in;

public class PrimeChecker {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            Prime ob = new Prime();
            ob.checkPrime(n1);
            ob.checkPrime(n1, n2);
            ob.checkPrime(n1, n2, n3);
            ob.checkPrime(n1, n2, n3, n4, n5);
            Method[] methods = Prime.class.getDeclaredMethods();
            Set<String> set = new HashSet<>();
            boolean overload = false;
            for (int i = 0; i < methods.length; i++) {
                if (set.contains(methods[i].getName())) {
                    overload = true;
                    break;
                }
                set.add(methods[i].getName());

            }
            if (overload) {
                throw new Exception("Overloading not allowed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class Prime {

    public void checkPrime(int... primes) {
        List<Integer> primesInteger = new ArrayList<>(primes.length);
        for (int prime : primes) {

            if (prime < 2) continue;
            if (prime < 4) {
                primesInteger.add(prime);
                continue;
            }
            if (prime % 2 == 0) continue;
            boolean isPrime = true;
            for (int i = 3; i < prime; i += 2) {
                if (prime % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) primesInteger.add(prime);
        }

        for (Integer prime : primesInteger) {
            System.out.print(prime + " ");
        }
        System.out.println();

    }
}
