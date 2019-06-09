package com.hackerrank.interview.tree;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class HeightOfBinaryTree {

    /*
    class Node
        int data;
        Node left;
        Node right;
    */
    List<Integer> ints = new ArrayList<>();

    public static int height(Node root) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addFirst(root);
        int result = 0;
        while (true) {
            int counter = 0;
            int previouslySize = queue.size();
            while (previouslySize!=counter) {
                Node first = queue.removeFirst();
                if (first.left != null) {
                    queue.add(first.left);
                }
                if (first.right != null) {
                    queue.add(first.right);
                }
                counter++;
            }
            result++;
            if (queue.isEmpty()) break;
        }
        return result-1;
    }

    private boolean containsNodeRecursive(Node current) {
        if (current == null) {
            return false;
        }

        return current != null
                ? containsNodeRecursive(current.left)
                : containsNodeRecursive(current.right);
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
        int height = height(root);
        System.out.println(height);
    }
}
