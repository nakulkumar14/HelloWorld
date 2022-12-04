package com.company.java16;

import java.util.List;

public class Demo1 {
  public static void main(String[] args) {

    // 1. toList on streams
    List<String> list = List.of("1", "2", "3", "4");
    List<Integer> integers = list.stream().map(Integer::parseInt).toList();
    System.out.println(integers);

    // 2. Final class replacement with record
    Book book = new Book("ds", "a1", 1.0);
    System.out.println(book);

    // 3. instanceof
    Object o = "newspaper";
    if (o instanceof String s) {
      System.out.println(s.toUpperCase() + " : " + s.length());
    }
  }
}
