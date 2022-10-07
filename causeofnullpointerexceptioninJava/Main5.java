package com.causeofnullpointerexception;
//Access index of a null array
public class Main5 {
    public static void main(String[] args) {
        int[] dataArray = null;     //Array set to null
        //access value at index 2
        System.out.println("Value at index 2:" + dataArray[2]);
    }
}