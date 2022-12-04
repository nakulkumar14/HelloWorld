package com.company.threads;

class CommonPrinter {

  Object o = new Object();
  boolean odd = true;

  public void printEven(int i) {
    synchronized (o) {
      while(odd) {
        try {
          o.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      System.out.println(i);
      odd = true;
      o.notify();
    }
  }

  public void printOdd(int i) {
    synchronized (o) {
      while(!odd) {
        try {
          o.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      System.out.println(i);
      odd = false;
      o.notify();
    }
  }

}
class CustomThread implements Runnable {

  private int start;
  private int end;
  private CommonPrinter commonPrinter;

  public CustomThread(int n, int i, CommonPrinter commonPrinter) {
    this.start = i;
    this.end = n;
    this.commonPrinter = commonPrinter;
  }

  @Override
  public void run() {
    for (int i = start; i <= end; i += 2) {
      if (i % 2 == 0) {
        commonPrinter.printEven(i);
      } else {
        commonPrinter.printOdd(i);
      }
    }
  }
}


public class PrintOddEvenNumbers {
  public static void main(String[] args) {
    int n = 20;
    CommonPrinter commonPrinter = new CommonPrinter();
    Thread t1 = new Thread(new CustomThread(n, 1, commonPrinter));
    Thread t2 = new Thread(new CustomThread(n, 2, commonPrinter));
    t1.start();
    t2.start();
//    Thread t1 = new Thread(() -> {
//      for (int i = 1; i < n; i += 2) {
//        commonPrinter.printOdd(i);
//      }
//    });
//    Thread t2 = new Thread(() -> {
//      for (int i = 2; i <= n; i += 2) {
//        commonPrinter.printEven(i);
//      }
//    });
//    t1.start();
//    t2.start();
  }
}
