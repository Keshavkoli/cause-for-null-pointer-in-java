package com.causeofnullpointerexception;
//The method is invoked using a null object
 class  MyClass {
	 int numField = 100;
     public static MyClass initT() {     //method returns a null object
     return null;
 }   public void print(String s) {
     System.out.println(s.toLowerCase());
 }
}
public class Main{
 public static void main(String[] args) {
	 MyClass t = MyClass.initT();    //create a new object (null object)
     t.print("Hello, World!"); 
     int num = t.numField;
     System.out.println(num);//invoke  method using null object
 }

}