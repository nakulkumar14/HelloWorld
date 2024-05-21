package com.company.locks._2_lock_lock;

class Lock {
  private boolean isLocked = false;

  public synchronized void lock() throws InterruptedException {
    while (isLocked) {
      wait();
    }
    isLocked = true;
  }

  public synchronized void unlock() {
    isLocked = false;
    notify();
  }
}

class Counter {
  int count = 0;
  Lock lock = new Lock();

  public int inc() throws InterruptedException {
    lock.lock();
    count++;
    int newcount = count;
    lock.unlock();
    System.out.println(Thread.currentThread().getName() + ", " + count);
    return newcount;
  }
}

public class LockExample {
  public static void main(String[] args) {
    Counter counter = new Counter();
    for (int i = 0; i < 10; i++) {
      Thread t = new Thread(() -> {
        try {
          counter.inc();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      });
      t.start();
    }
    System.out.println(counter.count);
  }
}
