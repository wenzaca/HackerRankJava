package com.hackerrank.interview.tree;

import java.util.Scanner;
import java.util.Stack;

public class LowestCommonAncestor {

    static Stack<Node> stackV1;
    static Stack<Node> stackV2;

    /*
    class Node
        int data;
        Node left;
        Node right;
    */
    public static Node lca(Node root, int v1, int v2) {
        // Write your code here.

        stackV2 = new Stack<>();

        binarySearch(root, v1);
        stackV1 = stackV2;
        stackV2 = new Stack<>();
        binarySearch(root, v2);

        while (stackV1.size() > stackV2.size()) {
            stackV1.pop();
        }
        while (stackV1.size() < stackV2.size()) {
            stackV2.pop();
        }

        while (!stackV2.isEmpty()) {
            Node popV1 = stackV1.pop();
            if (popV1.data == stackV2.pop().data)
                return popV1;
        }
        return root;
    }

    private static void binarySearch(Node root, int value) {

        if (root != null) {
            stackV2.push(root);
            if (root.data == value) {
                return;
            }
            if (value < root.data) {
                binarySearch(root.left, value);

            } else {
                binarySearch(root.right, value);
            }
        } else {
            return;
        }
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
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root, v1, v2);
        System.out.println(ans.data);
    }
}


