package com.company.locks._0_without_lock;

class Counter {
  int count = 0;

  public void inc() {
    count++;
    System.out.println(Thread.currentThread().getName() + ", " + count);
  }
}

public class NoLockCounter {
  public static void main(String[] args) {
    Counter counter = new Counter();
    for (int i = 0; i < 10; i++) {
      Runnable runnable = () -> counter.inc();
      Thread t = new Thread(runnable);
      t.start();
    }
    System.out.println(counter.count);
  }
}
