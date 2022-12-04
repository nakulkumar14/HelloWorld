package com.company.threads;

import java.time.LocalDateTime;

public class InterruptDemo {
  public static void main(String[] args) {
    Thread t = new Thread() {
      @Override
      public void run() {
        while(!Thread.interrupted()) {
          System.out.println(LocalDateTime.now());
//          try {
//            Thread.sleep(500);
//          } catch (InterruptedException e) {
//            e.printStackTrace();
//          }
        }
        System.out.println("Stopping execution");
      }
    };

    t.start();

    System.out.println("Interrupting thread now");
    try {
      Thread.sleep(15);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    t.interrupt();
  }
}
