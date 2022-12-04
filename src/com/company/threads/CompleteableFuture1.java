package com.company.threads;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

class Adder implements Supplier<String> {

  private String a;
  private String b;

  public Adder(String a, String b) {
    this.a = a;
    this.b = b;
  }

  @Override
  public String get() {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return a + " " + b;
  }
}

public class CompleteableFuture1 {
  public static void main(String[] args) throws InterruptedException {
    Adder adder = new Adder("nakul", "kumar");
    CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(adder);
    completableFuture.thenAccept(result -> {
      System.out.println("result : " + result);
    });
    Thread.sleep(1000);
    System.out.println();
  }
}
