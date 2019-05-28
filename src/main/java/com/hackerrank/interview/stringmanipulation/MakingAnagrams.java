package com.hackerrank.interview.stringmanipulation;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;

/*
Alice is taking a cryptography class and finding anagrams to be very useful. We consider two strings
to be anagrams of each other if the first string's letters can be rearranged to form the second string.
In other words, both strings must contain the same exact letters in the same exact frequency For
example, bacdc and dcbac are anagrams, but bacdc and dcbad are not.
Alice decides on an encryption scheme involving two large strings where encryption is dependent on the
minimum number of character deletions required to make the two strings anagrams. Can you help her find
this number?
 */
public class MakingAnagrams {
    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        if (a == null || b == null) return 0;
        int result = 0;
        for (Character charB : b.toCharArray()) {
            int index = a.indexOf(charB);
            if (index >= 0) {
                a = a.replaceFirst(charB.toString(), "");
            } else {
                result++;
            }
        }

        return result + a.length();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        scanner.close();

    }

    @Test
    public void testSolution() {
        Assert.assertThat(MakingAnagrams.makeAnagram("cde", "dcf"), is(2));
        Assert.assertThat(MakingAnagrams.makeAnagram("cde", "abc"), is(4));
        Assert.assertThat(MakingAnagrams.makeAnagram("aaa", "aaa"), is(0));
        Assert.assertThat(MakingAnagrams.makeAnagram("abcde", "abcdf"), is(2));
        Assert.assertThat(MakingAnagrams.makeAnagram("abcdeg", "abceg"), is(1));
        Assert.assertThat(MakingAnagrams.makeAnagram(null, "abceg"), is(0));
        Assert.assertThat(MakingAnagrams.makeAnagram("abc", null), is(0));
        Assert.assertThat(MakingAnagrams.makeAnagram(null, null), is(0));
        Assert.assertThat(MakingAnagrams.makeAnagram("", "abceg"), is(5));
        Assert.assertThat(MakingAnagrams.makeAnagram("abc", ""), is(3));
    }
}
