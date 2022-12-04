package com.company.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompleteableFutureExample {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    for (int i = 0; i < 10; i++) {
      CompletableFuture<Void> async = CompletableFuture.runAsync(() -> System.out.println(Thread.currentThread().getName()));
      async.get();
    }
  }
}
