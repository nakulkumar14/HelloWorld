package com.company.threads;

class SharedClass {
  Object o1 = new Object();
  Object o2 = new Object();
}

class T1 extends Thread{

  SharedClass sharedClass;

  public T1(SharedClass sharedClass, String t1) {
    super(t1);
    this.sharedClass = sharedClass;
  }

  @Override
  public void run() {
    synchronized (sharedClass.o1) {
      System.out.println(Thread.currentThread().getName() + " O1 acquired");
      synchronized (sharedClass.o2) {
        System.out.println(Thread.currentThread().getName() + "O2 acquired");
      }
    }
  }
}

class T2 extends Thread{

  SharedClass sharedClass;

  public T2(SharedClass sharedClass, String t2) {
    super(t2);
    this.sharedClass = sharedClass;
  }

  @Override
  public void run() {
    synchronized (sharedClass.o2) {
      System.out.println(Thread.currentThread().getName() + "O2 acquired");
      synchronized (sharedClass.o1) {
        System.out.println(Thread.currentThread().getName() + " O1 acquired");
      }
    }
  }
}

public class Deadlock {
  public static void main(String[] args) {
    SharedClass sharedClass = new SharedClass();
    T1 t1 = new T1(sharedClass, "t1");
    T2 t2 = new T2(sharedClass, "t2");
    t1.start();
    t2.start();
  }
}
