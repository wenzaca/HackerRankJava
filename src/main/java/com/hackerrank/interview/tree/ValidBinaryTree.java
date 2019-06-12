package com.hackerrank.interview.tree;

import java.util.Scanner;

public class ValidBinaryTree {

    /* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
    */


    static boolean checkBST(Node root) {

        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isValid(Node root, int min, int max) {

        if(root==null)
            return true;
        if(root.data <= min || root.data >= max)
            return false;
        return isValid(root.left, min, root.data)
                && isValid(root.right, root.data, max);
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        System.out.println(checkBST(root));
    }

}
