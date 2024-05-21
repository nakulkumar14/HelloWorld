package com.company.threads;

import java.util.ArrayList;
import java.util.List;

class BlockingQueue1 {
  private List<Integer> list = new ArrayList<>();
  private int size;

  BlockingQueue1(int size) {
    this.size = size;
  }

  public synchronized void add(int data) throws InterruptedException {
    System.out.println("size before adding : " + list.size());
    while (list.size() == size) {
      wait();
    }
    list.add(data);
    System.out.println("Added data : " + data);
    notify();
  }

  public synchronized int remove() throws InterruptedException {
    System.out.println("size before removing : " + list.size());
    while (list.size() == 0) {
      wait();
    }
    int ele = list.remove(0);
    notify();
    return ele;
  }
}

class Consumer1 implements Runnable {

  private BlockingQueue1 queue1;

  public Consumer1(BlockingQueue1 queue1) {
    this.queue1 = queue1;
  }

  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      try {
        int remove = queue1.remove();
        System.out.println("Consumed : " + remove);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

class Producer1 implements Runnable {
  private BlockingQueue1 queue1;

  public Producer1(BlockingQueue1 queue1) {
    this.queue1 = queue1;
  }

  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      try {
        queue1.add(i);
        System.out.println("Produced : " + i);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

public class CustomBlockingQueue1 {
  public static void main(String[] args) {
    BlockingQueue1 queue1 = new BlockingQueue1(1);
    Consumer1 c = new Consumer1(queue1);
    Producer1 p = new Producer1(queue1);

    Thread thread1 = new Thread(c);
    Thread thread2 = new Thread(p);
    thread1.start();
    thread2.start();
  }
}
