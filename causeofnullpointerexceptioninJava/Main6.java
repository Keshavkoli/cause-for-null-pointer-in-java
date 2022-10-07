package com.causeofnullpointerexception;
//Access index of a null array
//Similar to length, even if we try to access a value in a null array using an index, it is the cause of java.lang.NullPointerException.
public class Main6 {
    public static void main(String[] args) {
        int[] dataArray = null;     //Array set to null
        //access value at index 2
        System.out.println("Value at index 2:" + dataArray[2]);
    }
}