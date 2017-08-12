package com.hackerrank.dashboard.algorithms.implementation;

	import java.util.Scanner;

	public class TheHurdleRace {

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int k = in.nextInt();
	        int[] height = new int[n];
	        for(int height_i=0; height_i < n; height_i++){
	            height[height_i] = in.nextInt();
	        }
	        int j=0;
	        for(int i=0;i<height.length;i++){
	        	if(j<height[i]){
	        		j=height[i];
	        	}
	        }
	        if(k>=j){
	        	System.out.println(0);
	        }else{
	        	System.out.println(j-k);
	        }
	    }
	}
