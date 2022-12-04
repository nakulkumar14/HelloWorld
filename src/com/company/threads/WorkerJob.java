package com.company.threads;

public class WorkerJob implements Job{
  public WorkerJob(int i) {
    Thread.currentThread().setName("Thread-" + i);
  }

  @Override
  public void execute() {
    System.out.println(Thread.currentThread().getName() + " started");
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName() + " finished");
  }
}
