package com.test;

import java.util.*;

public class TreeMapTests {
  public static void main(String[] args) {
    Map<String, Integer> map = new TreeMap<>(Comparator.reverseOrder());
    map.put("hello",1);
    map.put("car",1);
    map.put("apple",1);
    System.out.println(map);

    ArrayList<Long> list = new ArrayList<>();
    list.add(1l);
    list.add(-1l);
    list.add(11l);
    list.add(-11l);

    Collections.sort(list, (o1, o2) -> (int) (Math.abs(o1) - Math.abs(o2)));

    System.out.println(list);
  }
}
