package com.company.threads;

class Printer1 {

  Object lock = new Object();
  boolean flag = true;

  public void even(int i) {
    synchronized (lock) {
      while (flag) {
        try {
          lock.wait();
        } catch (Exception e) {}
      }
      System.out.println(i);
      flag = true;
      lock.notify();
    }
  }

  public void odd(int i) {
    synchronized (lock) {
      while (!flag) {
        try {
          lock.wait();
        } catch (Exception e) {}
      }
      System.out.println(i);
      flag = false;
      lock.notify();
    }
  }
}

class CustomThread1 implements Runnable {

  Printer1 printer;

  CustomThread1(Printer1 printer) {
    this.printer = printer;
  }


  public void run() {
    for (int i = 1; i <= 10; i+=2) {
      if (i % 2 == 0) {
        printer.even(i);
      } else {
        printer.odd(i);
      }
    }
  }
}

class CustomThread2 implements Runnable {

  private int start;
  private int end;
  private Printer1 printer1;

  public CustomThread2(int n, int i, Printer1 commonPrinter) {
    this.start = i;
    this.end = n;
    this.printer1 = commonPrinter;
  }

  @Override
  public void run() {
    for (int i = start; i <= end; i += 2) {
      if (i % 2 == 0) {
        printer1.even(i);
      } else {
        printer1.odd(i);
      }
    }
  }
}

public class PrintOddEvenNumbers1 {
  public static void main(String[] args) {
    Printer1 printer1 = new Printer1();
    Thread t1 = new Thread(new CustomThread2(10, 1 , printer1));
    Thread t2 = new Thread(new CustomThread2(10, 2, printer1));
    t1.start();
    t2.start();
//    Thread a = new Thread(() -> {
//      for (int i = 2; i < 10; i+=2) {
//        printer1.even(i);
//      }
//    });
//
//    Thread b = new Thread(() -> {
//      for (int i = 1; i < 10; i+=2) {
//        printer1.odd(i);
//      }
//    });
//
//    a.start();
//    b.start();
  }
}
