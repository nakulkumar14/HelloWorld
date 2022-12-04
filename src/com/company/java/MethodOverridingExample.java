package com.company.java;

class Class1 {
  public void show() {
    System.out.println("in class1");
  }
}

class Class2 extends Class1{
  public void show() {
    System.out.println("in class2");
  }
}

public class MethodOverridingExample {

  public static void main(String[] args) {
    Class1 class1 = new Class2();
    class1.show();

  }
}
