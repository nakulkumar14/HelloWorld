package com.company.threads;

class A {
  boolean flagA = false;

  void processA(B b) {
    while (!b.flagB) {
      try {
        System.out.println(Thread.currentThread().getName() + " A ");
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    flagA = true;
  }
}

class B {
  boolean flagB = false;

  void processB(A a) {
    while (!a.flagA) {
      try {
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " B ");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    flagB = true;
  }
}

public class LiveLock {
  public static void main(String[] args) {
    A a = new A();
    B b = new B();

    Thread t1 = new Thread(() -> a.processA(b));
    Thread t2 = new Thread(() -> b.processB(a));
    t1.start();
    t2.start();
  }
}
