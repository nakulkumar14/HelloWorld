package com.company.java;

public class StringDemo {
  public static void main(String[] args) {
    System.out.println("a" + 5 + 6);
    System.out.println(5 + 6 + "b");
    String a = "hi";
    String b = "hi";
    String c = new String("hi");
    System.out.println(a==b);
    System.out.println(a==c);
  }
}
