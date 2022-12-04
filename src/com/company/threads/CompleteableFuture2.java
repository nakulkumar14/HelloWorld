package com.company.threads;

import java.util.concurrent.*;

public class CompleteableFuture2 {

  static String print() {
    System.out.println("Printing " + Thread.currentThread().getName());
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
//    throw new RuntimeException("job done");
    return "job done";
  }

  static String toUpper(String str) {
    System.out.println("Str : " + Thread.currentThread().getName());
    return str.toUpperCase();
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService pool = Executors.newFixedThreadPool(10);
    CompletableFuture<String> future = CompletableFuture.supplyAsync(CompleteableFuture2::print, pool)
        .thenApply(result -> toUpper(result));
    System.out.println(future.get());
    pool.shutdown();
  }
}
