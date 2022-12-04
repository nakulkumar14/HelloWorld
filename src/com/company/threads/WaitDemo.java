package com.company.threads;

import java.time.LocalDateTime;

class Demo {
  void waitdemo() {
    System.out.println("starting to wait..." + LocalDateTime.now());
    synchronized (this) {
      try {
        this.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("wait ends now..." + LocalDateTime.now());
    }
  }
}

public class WaitDemo {

  public static void main(String[] args) {
    WaitDemo o = new WaitDemo();
    Demo o1 = new Demo();
    o1.waitdemo();
  }
}
