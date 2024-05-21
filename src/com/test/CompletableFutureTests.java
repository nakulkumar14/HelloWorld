package com.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class CompletableFutureTests {

  ExecutorService executorService = Executors.newFixedThreadPool(10);

  void method1() {
    CompletableFuture.runAsync(() -> {
      System.out.println("Working in async " + Thread.currentThread().getName());
      try {
        Thread.sleep(1000);
        System.out.println("Work done..." + Thread.currentThread().getName());
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }, executorService).join();
    executorService.shutdown();
  }

  public static void main(String[] args) {
    CompletableFutureTests o = new CompletableFutureTests();
    o.method1();
    System.out.println("Main method " + Thread.currentThread().getName());

    Map<String, Integer> hashmap = new HashMap<>();

    //Inserting elements
    hashmap.put("Avocado", 80);
    hashmap.put("Honeydew", 60);
    hashmap.put("Blueberries", 45);
    hashmap.put("Cranberries", 60);
    hashmap.put("Mango", 75);

    List<Map.Entry<String, Integer>> list = hashmap.entrySet()
        .stream()
        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
        .collect(Collectors.toList());
    list.stream().forEach(item -> {
      System.out.println(item.getKey());
    });
  }
}
