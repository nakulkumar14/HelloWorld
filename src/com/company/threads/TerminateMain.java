package com.company.threads;

class Slave extends Thread {

  @Override
  public void run() {
    work();
  }

  public void work() {
    for (int i = 0; i < 100; i++) {
      System.out.println("Work done : " + i);
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

// Simulating if main thread gets killed or terminates, child thread will be killed.

public class TerminateMain {
  public static void main(String[] args) {
    Slave slave = new Slave();
    slave.start();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Exiting main thread...");
    System.exit(0);
  }
}
