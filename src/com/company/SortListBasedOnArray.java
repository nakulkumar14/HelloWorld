package com.company;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// https://www.geeksforgeeks.org/sort-linked-list-order-elements-appearing-array/
public class SortListBasedOnArray {

  static List<Integer> sortListByArray(int a[], List<Integer> list) {
    Map<Integer, List<Integer>> map = new LinkedHashMap<>();
    for (int num : a) {
      map.put(num, new ArrayList<>());
    }

    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < list.size(); i++) {
      Integer ele = list.get(i);
      map.get(ele).add(ele);
    }

    map.forEach((k,v) -> {
      result.addAll(v);
    });

    return result;
  }

  public static void main(String[] args) {
    int[] arr = {5, 1, 3, 2, 8};
    List<Integer> list = List.of(3, 2, 5, 8, 5, 2, 1);
    System.out.println(sortListByArray(arr, list));
  }
}
