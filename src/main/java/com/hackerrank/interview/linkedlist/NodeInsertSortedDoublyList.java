package com.hackerrank.interview.linkedlist;

import java.util.Scanner;

public class NodeInsertSortedDoublyList {

        static class DoublyLinkedListNode {
            public int data;
            public DoublyLinkedListNode next;
            public DoublyLinkedListNode prev;

            public DoublyLinkedListNode(int nodeData) {
                this.data = nodeData;
                this.next = null;
                this.prev = null;
            }
        }

        static class DoublyLinkedList {
            public DoublyLinkedListNode head;
            public DoublyLinkedListNode tail;

            public DoublyLinkedList() {
                this.head = null;
                this.tail = null;
            }

            public void insertNode(int nodeData) {
                DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

                if (this.head == null) {
                    this.head = node;
                } else {
                    this.tail.next = node;
                    node.prev = this.tail;
                }

                this.tail = node;
            }
        }

        public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep) {
            while (node != null) {
                System.out.println(String.valueOf(node.data));

                node = node.next;

                if (node != null) {
                    System.out.println(sep);
                }
            }
        }

        // Complete the sortedInsert function below.

        /*
         * For your reference:
         *
         * DoublyLinkedListNode {
         *     int data;
         *     DoublyLinkedListNode next;
         *     DoublyLinkedListNode prev;
         * }
         *
         */
        static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {


            if(head==null) return head;
            boolean isChanged = false;
            DoublyLinkedListNode initialHead = head;
            DoublyLinkedListNode newHead = new DoublyLinkedListNode(data);

            while(head != null){

                if (head.data>data){
                    if(head.prev != null){
                        head.prev.next = newHead;

                    } else{
                        initialHead = newHead;
                    }
                    newHead.prev = head.prev;
                    newHead.next = head;
                    head.prev = newHead;
                    isChanged=true;
                    break;
                }
                if(head.next==null){
                    break;
                }
                head = head.next;
            }
            if(!isChanged){
                head.next = newHead;
                newHead.prev = head;
            }
            return initialHead;
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            int t = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int tItr = 0; tItr < t; tItr++) {
                DoublyLinkedList llist = new DoublyLinkedList();

                int llistCount = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int i = 0; i < llistCount; i++) {
                    int llistItem = scanner.nextInt();
                    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                    llist.insertNode(llistItem);
                }

                int data = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                DoublyLinkedListNode llist1 = sortedInsert(llist.head, data);

                printDoublyLinkedList(llist1, " ");
            }


            scanner.close();
        }
}
