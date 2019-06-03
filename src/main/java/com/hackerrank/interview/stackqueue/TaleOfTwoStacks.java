package com.hackerrank.interview.stackqueue;

import org.junit.Test;
import sun.misc.Queue;

import java.util.Arrays;
import java.util.Scanner;

public class TaleOfTwoStacks {

    /* Test Sample
    10
    1 42
    2
    1 14
    3
    1 28
    3
    1 60
    1 78
    2
    2
     */

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        MyQueue<Integer> queue = new MyQueue<Integer>(n);

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }

}

class MyQueue<T> {

    Integer[] fifo;
    int positionFilled = 0;
    int size;

    public MyQueue(Integer n) {
        fifo = new Integer[n];
        size=n;
    }

    public void enqueue(Integer value){
        fifo[positionFilled] = value;
        positionFilled++;

    }

    public void dequeue(){
        fifo = Arrays.copyOfRange(fifo,1,size);
        positionFilled--;


    }

    public Integer peek(){
        return fifo[0];

    }

}
