package com.company.singleton;

class SingletonStatic {
  private static SingletonStatic obj = null;

  static {
    obj = new SingletonStatic();
  }

  private SingletonStatic() {
  }

  public static SingletonStatic getInstance() {
    return obj;
  }
}

public class SingletonStaticImpl {
  public static void main(String[] args) {
    SingletonStatic o1 = SingletonStatic.getInstance();
    SingletonStatic o2 = SingletonStatic.getInstance();
    System.out.println(o1 == o2);
  }
}
