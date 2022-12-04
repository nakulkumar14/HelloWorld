package com.company.threads;

public class Main {
  public static void main(String[] args) {
    for (int i = 0; i < 5; i++) {
      Thread thread = new Thread(new WorkerJob(i));
      thread.start();
    }

  }
}
