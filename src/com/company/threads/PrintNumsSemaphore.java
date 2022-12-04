package com.company.threads;

import java.util.concurrent.Semaphore;

class SharedPrinter {
  Semaphore se = new Semaphore(1);
  Semaphore so = new Semaphore(0);

  void even(int i) {
    try {
      se.acquire();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(i);
    so.release();
  }

  void odd(int i) {
    try {
      so.acquire();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(i);
    se.release();
  }
}

public class PrintNumsSemaphore {
  public static void main(String[] args) {
    SharedPrinter s = new SharedPrinter();
    Thread evenT = new Thread(() -> {
      for (int i = 0; i < 10; i += 2) {
        s.even(i);
      }
    });

    Thread oddT = new Thread(() -> {
      for (int i = 1; i < 10; i += 2) {
        s.odd(i);
      }
    });

    oddT.start();
    evenT.start();
  }
}
