package com.company.java;

class SuperA {
  SuperA() {
    System.out.println("this is super a");
  }

  SuperA(String a) {
    System.out.println("this is super a : " + a);
  }

  public void show() {
    System.out.println("super a show");
  }
}

class SuperB extends SuperA{
  SuperB() {
//    super();
    super("hello");
    System.out.println("this is super b");
  }

  public void show() {
    System.out.println("super b show");
    super.show();
  }
}

public class SuperExample {
  public static void main(String[] args) {
    SuperB b = new SuperB();
    b.show();
  }
}
