package com.company.streams;

import java.util.List;

public class StreamMax {
  public static void main(String[] args) {
    List<Integer> list = List.of(1, 2, 4, 0, -2);
    System.out.println(list.stream().max(Integer::compareTo).get());
  }
}
