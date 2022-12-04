package com.company.maps;

import java.util.HashMap;
import java.util.Map;

public class MapDemo1 {
  public static void main(String[] args) {
    Map<Integer, Integer> map = new HashMap<>();
    map.putIfAbsent(1, 2);
//    map.putIfAbsent(2, 3);
//    map.putIfAbsent(2, 4);
    System.out.println(map);

    map.computeIfAbsent(2 , i-> Integer.valueOf(4));
  }
}
