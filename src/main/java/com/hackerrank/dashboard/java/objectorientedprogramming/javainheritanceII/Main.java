package com.hackerrank.dashboard.java.objectorientedprogramming.javainheritanceII;

import java.util.Scanner;

public class Main {
	static Adder adder = new Adder();
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<2;i++)
        {
            int num1=sc.nextInt();
            int num2=sc.nextInt();
            adder.add(num1, num2);
            System.out.println();
        }
        System.out.println("================================");
        sc.close();
	}
}