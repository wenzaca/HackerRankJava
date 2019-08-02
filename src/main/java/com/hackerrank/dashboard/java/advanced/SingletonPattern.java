package com.hackerrank.dashboard.java.advanced;

public class SingletonPattern {

    public String str;
    private static volatile SingletonPattern INSTANCE = null;

    private SingletonPattern() {
    }

    public static SingletonPattern getSingleInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonPattern();
        }
        return INSTANCE;
    }
}

// Hackerrank solution
class Singleton {

    public String str;
    private static volatile Singleton INSTANCE = null;

    private Singleton() {
    }

    public static Singleton getSingleInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }
}