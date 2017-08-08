package com.hackerrank.dashboard.java.strings;

import java.util.Scanner;

public class Desafio1 {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        int i = A.length()+B.length();
        System.out.println(i);
        int c = A.compareTo(B);
        if(c>0)
        		System.out.println("Yes");
        if(c<=0)
        		System.out.println("No");
        char aC = A.charAt(0);
        String Ac = Character.toString(aC);
        A.replace(A.charAt(0),Ac.toUpperCase().toCharArray()[0]);
        char bC = B.charAt(0);
        String Bc = Character.toString(bC);
        B.replace(B.charAt(0),Bc.toUpperCase().toCharArray()[0]);
        System.out.println(A.replace(A.charAt(0),Ac.toUpperCase().toCharArray()[0])+" "+        B.replace(B.charAt(0),Bc.toUpperCase().toCharArray()[0]));
        sc.close();
    }
}
