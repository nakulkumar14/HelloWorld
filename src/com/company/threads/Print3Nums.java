package com.company.threads;

class Printer3Numbers {
  Object o = new Object();
  volatile int x = 0;

  public void print(int i) throws InterruptedException {
    synchronized (o) {
      while (x != i) {
        o.wait();
      }
      System.out.println(Thread.currentThread().getName() + " " + x);
      x++;
      x = x % 3;
      o.notifyAll();
    }
  }
}

class CommonRunner implements Runnable {

  Printer3Numbers p;
  int limit;
  int num;

  public CommonRunner(Printer3Numbers p, int limit, int num) {
    this.p = p;
    this.limit = limit;
    this.num = num;
  }

  @Override
  public void run() {
    for (int i = 0; i < limit; i++) {
      try {
        p.print(num);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

public class Print3Nums {
  public static void main(String[] args) {
    Printer3Numbers p = new Printer3Numbers();
    Thread t1 = new Thread(new CommonRunner(p, 3, 0), "Thread-0");
    Thread t2 = new Thread(new CommonRunner(p, 3, 1), "Thread-1");
    Thread t3 = new Thread(new CommonRunner(p, 3, 2), "Thread-2");
    t1.start();
    t2.start();
    t3.start();
  }
}
