package com.company.threads;

class TriplePrinter {
  Object o = new Object();
  volatile int i = 1;
  int limit = 10;
  public void task() {
    while (i < limit-1) {
      synchronized (o) {
        int threadName = Integer.parseInt(Thread.currentThread().getName());
        try {
          while (i % 3 != threadName) {
            o.wait();
          }
          System.out.println(threadName + " " + i);
          i++;
          o.notifyAll();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}

public class PrintNumsThreeThreads {
  public static void main(String[] args) {
    TriplePrinter tp = new TriplePrinter();
    Thread t1 = new Thread(() -> tp.task(), String.valueOf(1));
    Thread t2 = new Thread(() -> tp.task(),String.valueOf(2));
    Thread t3 = new Thread(() -> tp.task(), String.valueOf(0));
    t1.start();
    t2.start();
    t3.start();
  }
}
