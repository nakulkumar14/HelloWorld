package com.company.functionalinterfaces;

interface A {
  void showA();
}

//@FunctionalInterface // Give compilation error
interface B extends A{
  void showB();
}

interface C {
  default void showC() {

  }

  static void showC1() {

  }
}

@FunctionalInterface // no abstract method in inherited interface
interface D extends C {
  void showD();
}

public class FIExample {
  public static void main(String[] args) {
    System.out.println("");
  }
}
