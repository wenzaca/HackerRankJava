package com.hackerrank.interview.warmup;

import junit.framework.Assert;
import org.junit.Test;

/*
Function Description

Complete the jumpingOnClouds function in the editor below. It should return the minimum number of jumps required, as an integer.

jumpingOnClouds has the following parameter(s):

c: an array of binary integers

https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
 */
public class JumpingOnTheClouds {

    private int calculateJumps(Integer[] ints) {
        int counter = 0;
        int jumps = 0;
        while (counter < ints.length - 1) {
            if (ints[counter + 1] != 0) {
                jumps++;
                counter += 2;
                continue;
            }
            if (ints[counter + 1] == 0 && ints.length > counter + 2 && ints[counter + 2] == 0) {
                jumps++;
                counter += 2;
            } else {
                jumps++;
                counter += 1;
            }
        }
        return jumps;
    }

    @Test
    public void checkJumpCount() {
        Integer[] ints1 = {0, 0, 1, 0, 0, 1, 0};
        Integer[] ints2 = {0, 0, 0, 1, 0, 0};
        Integer[] ints3 = {0, 0, 0, 0, 1, 0};
        Assert.assertEquals(4, calculateJumps(ints1));
        Assert.assertEquals(3, calculateJumps(ints2));
        Assert.assertEquals(3, calculateJumps(ints3));
    }


}
