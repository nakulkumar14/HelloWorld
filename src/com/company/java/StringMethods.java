package com.company.java;

public class StringMethods {
  public static void main(String[] args) {
    String blank1 = "  ";
    String blank2 = "";
    System.out.println(blank1.isBlank());
    System.out.println(blank2.isBlank());

    String lines = "This is first line\nThis is second line\nThis is carriage return\rThis is new line";
    lines.lines().forEach(System.out::println);

    String strip1 = "     new  ";
    System.out.println(strip1.strip());

    String strip2 = "    empty spaces in front.";
    String strip3 = "    empty spaces in end.     ";
    System.out.println(strip2.stripLeading());
    System.out.println(strip3.stripTrailing());

    System.out.println("hello".repeat(2));
  }
}
