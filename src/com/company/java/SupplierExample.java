package com.company.java;

import java.util.function.Supplier;

public class SupplierExample {
  public static void main(String[] args) {
    System.out.println("hello");
    SupplierExample o = new SupplierExample();
    Supplier<Object> s = () -> {
      o.someMethod();
      return new Object();
    };

    if (s != null) {
      s.get();
    }
    System.out.println("bye");
  }

  public void someMethod() {
    System.out.println("this method doing some execution");
    int a = 10;
    int c = 55;
    System.out.println(a + c);
  }
}
