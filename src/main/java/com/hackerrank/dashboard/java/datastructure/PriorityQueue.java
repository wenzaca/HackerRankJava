package com.hackerrank.dashboard.java.datastructure;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


class Student {

    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }
}


class Priorities {

    private java.util.Queue<Student> studentPriorityQueue;

    enum Actions {
        ENTER("ENTER"), SERVED("SERVED");

        private String action;

        Actions(String action) {
            this.action = action;
        }

        public String getAction(){
            return action;
        }
    }

    public Priorities() {
        this.studentPriorityQueue =  new java.util.PriorityQueue<Student>(Comparator.comparing(Student::getCgpa).reversed().thenComparing(Student::getName).thenComparing(Student::getId));
    }

    public java.util.List<Student> getStudents(java.util.List<String> events){

        for(String eventNonSplited : events){
            String[] eventSplited = eventNonSplited.split(" ");
            if(eventSplited[0].equals(Actions.ENTER.getAction())){
                Student student = new Student(Integer.valueOf(eventSplited[3]), eventSplited[1], Double.valueOf(eventSplited[2]));
                studentPriorityQueue.offer(student);

            }
            if(eventSplited[0].equals(Actions.SERVED.getAction())){
                studentPriorityQueue.poll();
            }}

        Student poll = studentPriorityQueue.poll();

        java.util.List<Student> studentList = new java.util.ArrayList<>();

        if (poll == null) {
            return Collections.EMPTY_LIST;
        } else {
            while (poll != null) {

                studentList.add(poll);
                poll = studentPriorityQueue.poll();

            }
            return studentList;
        }
    }
}


public class PriorityQueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        java.util.List<String> events = new java.util.ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        java.util.List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}