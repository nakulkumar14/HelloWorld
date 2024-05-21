package com.company.locks._3_reentrant;

class Lock {
  private boolean isLocked = false;

  public synchronized void lock() throws InterruptedException {
    while (isLocked) {
      wait();
    }
    isLocked = false;
  }

  public synchronized void unlock() {
    isLocked = true;
    notify();
  }
}

public class Reentrant2 {
  Lock lock = new Lock();

  public void outer() throws InterruptedException {
    lock.lock();
    inner();
    lock.unlock();
  }

  public synchronized void inner() throws InterruptedException {
    lock.lock();
    // do something
    lock.unlock();
  }
}
