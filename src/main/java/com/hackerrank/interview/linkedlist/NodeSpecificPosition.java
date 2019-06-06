package com.hackerrank.interview.linkedlist;

import java.util.Scanner;

public class NodeSpecificPosition {

        static class SinglyLinkedListNode {
            public int data;
            public SinglyLinkedListNode next;

            public SinglyLinkedListNode(int nodeData) {
                this.data = nodeData;
                this.next = null;
            }
        }

        static class SinglyLinkedList {
            public SinglyLinkedListNode head;
            public SinglyLinkedListNode tail;

            public SinglyLinkedList() {
                this.head = null;
                this.tail = null;
            }

            public void insertNode(int nodeData) {
                SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

                if (this.head == null) {
                    this.head = node;
                } else {
                    this.tail.next = node;
                }

                this.tail = node;
            }
        }

        public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep)  {
            while (node != null) {
                System.out.println(String.valueOf(node.data));

                node = node.next;

                if (node != null) {
                    System.out.println(sep);
                }
            }
        }

        // Complete the insertNodeAtPosition function below.

        /*
         * For your reference:
         *
         * SinglyLinkedListNode {
         *     int data;
         *     SinglyLinkedListNode next;
         * }
         *
         */
        static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {

            SinglyLinkedListNode linkedListNode = head;
            int counter = 0;
            while (counter<position-1){
                head = head.next;
                counter++;
            }

            SinglyLinkedListNode tail = head.next;
            SinglyLinkedListNode newInsertion = new SinglyLinkedListNode(data);
            head.next = newInsertion;
            newInsertion.next = tail;
            return linkedListNode;
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {

            SinglyLinkedList llist = new SinglyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            int data = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int position = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            SinglyLinkedListNode llist_head = insertNodeAtPosition(llist.head, data, position);

            printSinglyLinkedList(llist_head, " ");

            scanner.close();
        }
    }