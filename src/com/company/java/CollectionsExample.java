package com.company.java;

import java.util.*;

public class CollectionsExample {
  public static void main(String[] args) {
    List<Integer> list = List.of(1, 2, 3, 4);
    System.out.println(list);
//    list.add(5);
//    System.out.println(list);

    Set<Integer> set = Set.of(1, 2);
    System.out.println(set);
//    set.add(4);
//    System.out.println(set);

    Map<Integer, Integer> map = Map.of(1, 2, 3, 4);
    System.out.println(map);
    map.remove(1);
    System.out.println(map);

    List<Integer> integers = List.of(1, 2, 3);
    Collections.sort(integers, (x,y)-> {
      String xy = x+""+y;
      String yx = y+""+x;
      return xy.compareTo(yx) > 0 ? -1 : 1;
    });
    // A comparison function which is used by
// sort() in printLargest()
    Integer arr[] = {1,2,3,4};
    Arrays.sort(arr, (X, Y) -> {

      // first append Y at the end of X
      String XY = X +""+ Y;

      // then append X at the end of Y
      String YX = Y + ""+X;

      // Now see which of the two
      // formed numbers
      // is greater
      return XY.compareTo(YX) > 0 ? -1 : 1;
    });
  }
}
