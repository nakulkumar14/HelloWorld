package com.company.functionalinterfaces;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample {
  public static void main(String[] args) {
    Predicate<String> predicate = str -> {
      for (int i = 0; i < str.length(); i++) {
        if (Character.isDigit(str.charAt(i))) {
          return true;
        }
      }
      return false;
    };

    System.out.println(predicate.test("abcd"));
    System.out.println(predicate.test("ab1cd"));

    List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
    Predicate<Integer> integerPredicate = i -> i > 5 && i % 2 == 0;
    List<Integer> integers = list.stream()
        .filter(i -> integerPredicate.test(i))
        .collect(Collectors.toList());

    System.out.println(integers);
  }
}
