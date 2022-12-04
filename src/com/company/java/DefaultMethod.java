package com.company.java;

interface IDemo {
  default void test() {
    System.out.println("this is default method");
  }
}
class Demonstration implements IDemo {
public void test() {
  System.out.println("this is impl");
}
}

public class DefaultMethod {
  public static void main(String[] args) {
    IDemo demo = new Demonstration();
    demo.test();
  }
}
