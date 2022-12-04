package com.company.threads;

class Printer {
  volatile int i = 0;
  volatile boolean f = true;
  Object o = new Object();

  void even(int j) {
//    synchronized (this) {
    synchronized (o) {
//      while(i%2 != 0) {
      while(!f) {
        try {
//          wait();
          o.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      System.out.println(j);
//      i++;
      f = !f;
//      notify();
      o.notify();
    }
  }

  void odd(int j) {
//    synchronized (this) {
    synchronized (o) {
//      while(i%2 != 1) {
      while(f) {
        try {
//          wait();
          o.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      System.out.println(j);
//      i++;
      f=!f;
//      notify();
      o.notify();
    }
  }
}

public class PrintNums {
  public static void main(String[] args) {
    Printer p = new Printer();
    Thread e = new Thread(() -> {
      for (int i = 0; i < 10; i+=2) {
        p.even(i);
      }
    });
    Thread o = new Thread(() -> {
      for (int i = 1; i < 10; i+=2) {
        p.odd(i);
      }
    });
    o.start();
    e.start();
  }
}
