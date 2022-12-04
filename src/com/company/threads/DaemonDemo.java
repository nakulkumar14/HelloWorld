package com.company.threads;

public class DaemonDemo {
  public static void main(String[] args) {
    Thread t = new Thread() {
      @Override
      public void run() {
        for (int i = 0; i < 100; i++) {
          System.out.println(i);
          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    };

    t.start();
    t.setDaemon(true);
  }
}
