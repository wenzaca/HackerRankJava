package com.hackerrank.interview.stringmanipulation;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;


/*
You are given a string containing characters A and B only. Your task is to change it into a string such
that there are no matching adjacent characters. To do this, you are allowed to delete zero or more
characters in the string.

Your task is to find the minimum number of required deletions.

For example, given the string AABAAB, remove an A at positions 0 and 3 to make ABAB in 2 deletions.
 */
public class AlternatingCharacter {
    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        if(s==null || s.isEmpty()) return 0;
        StringBuffer sb = new StringBuffer();
        int result=0;
        for (Character c : s.toCharArray()){
            if(sb.length()==0 || sb.charAt(sb.length()-1)!=c)
                sb.append(c);
            else result++;
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);

        }


        scanner.close();
    }

    @Test
    public void testSolution(){
        Assert.assertThat(AlternatingCharacter.alternatingCharacters("AABAAB"), is(2));
        Assert.assertThat(AlternatingCharacter.alternatingCharacters("AABAABABBABBBA"), is(5));
        Assert.assertThat(AlternatingCharacter.alternatingCharacters("AAAAA"), is(4));
        Assert.assertThat(AlternatingCharacter.alternatingCharacters("ABCDEFG"), is(0));
        Assert.assertThat(AlternatingCharacter.alternatingCharacters(null), is(0));
        Assert.assertThat(AlternatingCharacter.alternatingCharacters(""), is(0));
    }
}