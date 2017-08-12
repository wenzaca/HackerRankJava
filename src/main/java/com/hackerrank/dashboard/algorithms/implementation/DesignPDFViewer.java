package com.hackerrank.dashboard.algorithms.implementation;

import java.util.Scanner;

public class DesignPDFViewer {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[] alpha = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','x','w','y','z'};
		int[] h = new int[26];
		for (int h_i = 0; h_i < 26; h_i++) {
			h[h_i] = in.nextInt();
		}
		int major=0;
		String word = in.next();
		int w = word.length();
		for(int i=0;i<w;i++){
			word.charAt(i);
			for(int j=0;j<alpha.length;j++){
				if(word.charAt(i)==alpha[j]){
					if(h[j]>major){
						major=h[j];
					}
				}
			}
		}
		System.out.println(major*w);
		
	}
}
