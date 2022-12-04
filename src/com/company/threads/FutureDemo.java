package com.company.threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {

  static boolean method() {
    System.out.println("Method is called");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return true;
  }

  static boolean method1() {
    System.out.println("Method1 is called");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return true;
  }

  public static void main(String[] args) throws InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    Future<Boolean> future = executorService.submit(FutureDemo::method);
    Future<Boolean> future2 = executorService.submit(FutureDemo::method1);
    while (!future.isDone() || !future2.isDone()) {
      System.out.println(
          String.format(
              "future1 is %s and future2 is %s",
              future.isDone() ? "done" : "not done",
              future2.isDone() ? "done" : "not done"
          )
      );
      Thread.sleep(300);
    }
    try {
      Boolean aBoolean = future.get();
      Boolean aBoolean1 = future2.get();
      System.out.println("returned : " + aBoolean + ", " + aBoolean1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
    System.out.println("Main method exit");

    executorService.shutdown();
  }
}
