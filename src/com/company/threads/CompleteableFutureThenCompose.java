package com.company.threads;

import java.util.concurrent.CompletableFuture;

public class CompleteableFutureThenCompose {
  public static void main(String[] args) {
    CompletableFuture<String> compose = CompletableFuture.supplyAsync(() -> "Hello")
        .thenCompose(value -> CompletableFuture.supplyAsync(() -> value + " world"));
    compose.thenAccept(System.out::println);

    CompletableFuture<CompletableFuture<String>> completableFuture = CompletableFuture.supplyAsync(() -> "Hello")
        .thenApply(value -> CompletableFuture.supplyAsync(() -> value + " world"));
    completableFuture.thenAccept(f -> f.thenAccept(System.out::println));
  }
}
