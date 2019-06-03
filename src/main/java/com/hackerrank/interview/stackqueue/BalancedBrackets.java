package com.hackerrank.interview.stackqueue;

import com.hackerrank.interview.stringmanipulation.MakingAnagrams;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

import static org.hamcrest.CoreMatchers.is;

public class BalancedBrackets {
    // Complete the isBalanced function below.
    static String isBalanced(String s) {

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(Character c : chars){
            if (c == '{' || c == '[' || c == '('){
                stack.push(c);
            }
            else {
                if(stack.isEmpty()) return "NO";
                Character top = stack.pop();
                if((c == '}' && '{' != top) || (c == ']' && '[' != top) || (c == ')' && '(' != top)) return "NO";
            }
        }
        if (stack.isEmpty())
            return "YES";
        return "NO";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            System.out.println(isBalanced(s));

        }

        scanner.close();
    }

    @Test
    public void testSolution() {
        Assert.assertThat(isBalanced("{[()]}"), is("YES"));
        Assert.assertThat(isBalanced("{[(])}"), is("NO"));
        Assert.assertThat(isBalanced("{{[[(())]]}}"), is("YES"));
        Assert.assertThat(isBalanced("}"), is("NO"));

    }
}
