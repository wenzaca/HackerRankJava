package com.hackerrank.dashboard.java.strings;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SubstringComparison {
	  public static String getSmallestAndLargest(String s, int k) {
	        String smallest = "";
	        String largest = "";
	        Set<String> map = new TreeSet<>();
	         for(int i =0;i<=s.length()-k;i++){
	        	 map.add(s.substring(i, k+i));
	         }
	         smallest= (String) map.toArray()[0];
	        		 largest = (String) map.toArray()[map.size()-1];
	        
	        return smallest + "\n" + largest;
	    }

	    public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        String s = scan.next();
	        int k = scan.nextInt();
	        scan.close();
	      
	        System.out.println(getSmallestAndLargest(s, k));
	    }
}
