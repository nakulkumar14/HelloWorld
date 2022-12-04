package com.company.singleton;

class SingletonLazy {
  private static SingletonLazy obj = null;

  private SingletonLazy() {
  }

  public static SingletonLazy getInstance() {
    if (obj == null) {
      obj = new SingletonLazy();
    }
    return obj;
  }
}

public class SingletonLazyImpl {
  public static void main(String[] args) {
    SingletonLazy o1 = SingletonLazy.getInstance();
    SingletonLazy o2 = SingletonLazy.getInstance();
    System.out.println(o1 == o2);
  }
}
