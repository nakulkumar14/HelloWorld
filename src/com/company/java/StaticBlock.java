package com.company.java;

class SomeOtherClass {

  static {
    System.out.println("Some other class");
  }

  SomeOtherClass() {
    System.out.println("SomeOtherClass init");
  }
}

public class StaticBlock {
  static {
    System.out.println("main class");
  }

  StaticBlock() {
    System.out.println("main init");
  }

  public static void main(String[] args) {
    SomeOtherClass obj1 = new SomeOtherClass();
    StaticBlock obj2 = new StaticBlock();
  }


  static {
    System.out.println("main 2");
  }
}
