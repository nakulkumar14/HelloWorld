package com.company.functionalinterfaces;

import java.util.function.Consumer;

public class ConsumerExample {
  public static void main(String[] args) {
    Consumer<String> consumer = s -> {
      System.out.println(transform(s));
    };

    consumer.accept("h3llo w0rld   %");

    print("software engineer", (var s) -> System.out.println(s));
  }

  static <T> void print(T t, Consumer<T> c) {
    c.accept(t);
  }

  static String transform(String s) {
    String transform = "";
    for (int i = 0; i < s.length(); i++) {
      if (Character.isAlphabetic(s.charAt(i))) {
        transform += s.charAt(i);
      }
    }
    return transform;
  }
}
