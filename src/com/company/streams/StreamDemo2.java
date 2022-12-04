package com.company.streams;

import java.util.Arrays;
import java.util.List;

public class StreamDemo2 {
  public static void main(String[] args) {
    List<Integer> list = List.of(1, 2, 3, 4);
    Integer[] integers = list.stream().toArray(Integer[]::new);
    System.out.println(Arrays.toString(integers));

    List<Integer> list1 = Arrays.asList(1, 2, 3, 4, null);
    Integer integer = list1.stream()
        .filter(i->i!=null)
        .reduce((i1, i2) -> i1 + i2)
        .get();
    System.out.println(integer);

    List<String> list2 = List.of("abc", "sdfd", "dsef", "dth", "fyj");
    boolean match = list2.stream()
        .allMatch(i -> i.contains("d"));
    System.out.println(match);
  }
}
