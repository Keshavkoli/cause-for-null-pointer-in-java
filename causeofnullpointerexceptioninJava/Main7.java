package com.causeofnullpointerexception;
//Synchronization on a null object
public class Main7 {
    public static String mutex = null;      //mutex variable set to null
    public static void main(String[] args) {
        synchronized(mutex) {           //synchronized block for null mutex
            System.out.println("synchronized block");
        }
    }
}