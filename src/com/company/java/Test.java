package com.company.java;

class A extends Test.Demo{
  public A(int a) {
    super(a);
  }

  public void show() {
    System.out.println(a);
  }
}

public class Test {

  static class Demo {
    int a;

    public Demo(int a) {
      this.a = a;
    }

    public int getA() {
      return a;
    }

    public void setA(int a) {
      this.a = a;
    }
  }

  public static void main(String[] args) {
    Demo demo = new Demo(10);
    System.out.println(demo.getA());

    A a = new A(5);
    System.out.println(a.getA());
  }
}
