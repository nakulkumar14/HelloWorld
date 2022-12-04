package com.company.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BlockingQueue2 {
  private List<Integer> list = new ArrayList<>();
  private int size;
  private Lock lock;
  private Condition produce, consume;

  public BlockingQueue2(int size) {
    this.size = size;
    lock = new ReentrantLock();
    produce = lock.newCondition();
    consume = lock.newCondition();
  }

  public void add(int data) throws InterruptedException {
    lock.lock();
    if (list.size() == size) {
      System.out.println("Waiting to consume...");
      produce.await();
    }
    list.add(data);
    System.out.println("Produced : " + data);
    consume.signal();
    lock.unlock();
  }

  public int remove() throws InterruptedException {
    lock.lock();
    if (list.size() == 0) {
      System.out.println("Waiting to produce...");
      consume.await();
    }
    int remove = list.remove(0);
    System.out.println("Consumed : " + remove);
    produce.signal();
    lock.unlock();
    return remove;
  }
}

class Consumer2 implements Runnable {
  BlockingQueue2 queue2;

  public Consumer2(BlockingQueue2 queue2) {
    this.queue2 = queue2;
  }

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      try {
        queue2.remove();
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

class Producer2 implements Runnable {

  BlockingQueue2 queue2;

  public Producer2(BlockingQueue2 queue2) {
    this.queue2 = queue2;
  }

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      try {
        queue2.add(i);
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

public class CustomBlockingQueue2 {
  public static void main(String[] args) {
    BlockingQueue2 queue2 = new BlockingQueue2(5);
    Thread t1 = new Thread(new Consumer2(queue2));
    Thread t2 = new Thread(new Producer2(queue2));
    t1.start();
    t2.start();
  }
}
