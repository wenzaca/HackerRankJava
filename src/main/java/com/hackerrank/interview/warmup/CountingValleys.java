package com.hackerrank.interview.warmup;

import junit.framework.Assert;
import org.junit.Test;

/*
A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.
Given Gary's sequence of up and down steps during his last hike, find and print the number of valleys he walked through.

For example, if Gary's path is , he first enters a valley  units deep. Then he climbs out an up onto a mountain  units high. Finally, he returns to sea level and ends his hike.

Function Description

Complete the countingValleys function in the editor below. It must return an integer that denotes the number of valleys Gary traversed.

countingValleys has the following parameter(s):

n: the number of steps Gary takes
s: a string describing his path
 */
public class CountingValleys {

    private int calculateValey(String walksString) {
        int valley = 0;
        int level = 0;
        char[] walks = walksString.toCharArray();

        for (char c : walks) {
            if (c == 'U') {
                if (level == -1) {
                    valley++;
                }
                level++;
            } else {
                level--;
            }
        }
        return valley;
    }

    @Test
    public void checkJumpCount() {
        String walks1 = "UDDDUDUU";
        String walks2 = "DDDDUDUU";
        String walks3 = "UDDUUDUDDU";
        Assert.assertEquals(1, calculateValey(walks1));
        Assert.assertEquals(0, calculateValey(walks2));
        Assert.assertEquals(2, calculateValey(walks3));
    }
}
