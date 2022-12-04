package com.company.array;

import java.util.*;

public class SortArray {
  public static void main(String[] args) {
    int[] arr = {3, 3, 3, 3, 5, 5, 5, 2, 2, 7};

    Map<Integer, Integer> map = new HashMap<>();
    for (int e : arr) {
      map.put(e, map.getOrDefault(e, 0) + 1);
    }

    System.out.println(map);

    List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
    Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());

    Map<Integer, Integer> newmap = new LinkedHashMap<>();
    for (Map.Entry<Integer, Integer> e : list) {
      newmap.put(e.getKey(), e.getValue());
    }

    Iterator<Map.Entry<Integer, Integer>> iterator = newmap.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry<Integer, Integer> entry = iterator.next();

    }

    System.out.println(newmap);
  }
}
