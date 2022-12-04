package com.company.singleton;

class SingletonEager {
  private static SingletonEager obj = new SingletonEager();

  private SingletonEager() {
  }

  public static SingletonEager getInstance() {
    return obj;
  }

}

public class SingletonImpl {
  public static void main(String[] args) {
    SingletonEager instance1 = SingletonEager.getInstance();
    SingletonEager instance2 = SingletonEager.getInstance();
    System.out.println(instance1 == instance2);
  }
}
