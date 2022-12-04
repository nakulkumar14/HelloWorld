package com.company;

@FunctionalInterface
interface Vehicle {
  int show(int i, String x);

  default void method1() {
    System.out.println("method1 called");
  }

  default void method2() {
    System.out.println("method2 called");
  }

  static void method3() {
    System.out.println("method3 called");
  }
}

public class FunctionalInterfaceDemo
{
  public static void main(String[] args) {
    Vehicle d = (i, s) -> {
      System.out.println("hello" + s + i);
      return s.length();
    };
    int length = d.show(10, "abc");
    System.out.println("len : " + length);
    d.method1();
    d.method2();
  }
}
