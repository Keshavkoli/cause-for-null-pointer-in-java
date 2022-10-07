package com.causeofnullpointerexception;
//Passing a null object as an argument
public class Main3 {
    public static void print_LowerCase(String s) {
        System.out.println(s.toLowerCase());
    }
    public static void main(String[] args) {
        print_LowerCase(null);  //pass null object as argument to the method    }
        //Here we have a method ‘print_LowerCase’ that converts the String object passed as an argument to a lowercase.
}
}