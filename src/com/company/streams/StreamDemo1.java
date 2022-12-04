package com.company.streams;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo1 {
  public static void main(String[] args) {
    List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
    List<Integer> list1 = list.stream()
        .filter(i -> i > 1)
        .map(i -> i + 10)
        .sorted(Comparator.reverseOrder())
        .distinct()
        .limit(9)
        .collect(Collectors.toList());
    System.out.println(list1);

    System.out.println("flat map");
    List<Integer> list2 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
    list2.stream()
        .flatMap(StreamDemo1::apply)
        .forEach(System.out::print);

    System.out.println();
    System.out.println("peek");
    Consumer<Integer> consumer = (i) -> System.out.println("i : " + i);
    List<Integer> list3 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
    list3.stream().peek(consumer).collect(Collectors.toList());
  }

  private static Stream<? extends String> apply(Integer i) {
    return Stream.of(i).map(j -> j * 10 + ", ");
  }
}
