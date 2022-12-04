package com.company.threads;

import java.util.concurrent.CompletableFuture;

public class CompleteableFutureThenCombine {
  public static void main(String[] args) {
    CompletableFuture<String> async = CompletableFuture.supplyAsync(() -> " how r u");
    CompletableFuture<String> combine = CompletableFuture.supplyAsync(() -> "hi")
        .thenCombine(async, (v1, v2) -> v1 + v2);
    combine.thenAccept(System.out::println);
  }
}
