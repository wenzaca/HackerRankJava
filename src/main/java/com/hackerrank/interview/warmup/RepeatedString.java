package com.hackerrank.interview.warmup;

import junit.framework.Assert;
import org.junit.Test;

/*
Function Description

Complete the repeatedString function in the editor below. It should return an integer representing the number of occurrences of a in the prefix of length  in the infinitely repeating string.

repeatedString has the following parameter(s):

s: a string to repeat
n: the number of characters to consider

https://www.hackerrank.com/challenges/repeated-string/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=warmup
 */
public class RepeatedString {

    private long getA(long size, String word) {
        long length = word.length();
        long result = 0;
        long normalWord = 0;
        if (length > size) {
            for (char letter : word.substring(0, (int) size).toCharArray()) {
                if (letter == 'a') result++;
            }
            return result;
        }
        for (char letter : word.toCharArray()) {
            if (letter == 'a') normalWord++;
        }
        result += normalWord * (size / length);

        for (int i = 0; i < size % length; i++) {
            if (word.charAt(i) == 'a') result++;
        }

        return result;
    }

    @Test
    public void validateTheNumberOfAOnStrings() {
        String word1 = "abcac";
        long charactNum1 = 10;
        String word2 = "aba";
        long charactNum2 = 10;
        String word3 = "a";
        long charactNum3 = 1000000000000L;
        String word4 = "epsxyyflvrrrxzvnoenvpegvuonodjoxfwdmcvwctmekpsnamchznsoxaklzjgrqruyzavshfbmuhdwwmpbkwcuomqhiyvuztwvq";
        long charactNum4 = 549382313570L;
        Assert.assertEquals(4l, getA(charactNum1, word1));
        Assert.assertEquals(7, getA(charactNum2, word2));
        Assert.assertEquals(charactNum3, getA(charactNum3, word3));
        Assert.assertEquals(16481469408L, getA(charactNum4, word4));
    }
}
