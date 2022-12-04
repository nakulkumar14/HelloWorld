package com.company.array;

import java.util.Arrays;

public class Box {

  static void show(int arr[][]) {
    for (int[] a : arr) {
      System.out.println(Arrays.toString(a));
    }
  }

  public static void main(String[] args) {
    int boxes[][] = {
        {2, 5, 4},
        {3, 4, 18},
        {2, 6, 28}
    };
    show(boxes);
//    Arrays.sort(boxes, new Comparator<int[]>() {
//      @Override
//      public int compare(int[] o1, int[] o2) {
//        int o = o2[0]*o2[1] - o1[0]*o1[1];
//        if (o!=0)
//          return o;
//        return o2[2] - o1[2];
//      }
//    });

    Arrays.sort(boxes, (o1, o2) -> {
      int o = o2[0] * o2[1] - o1[0] * o1[1];
      if (o != 0)
        return o;
      return o2[2] - o1[2];
    });

    System.out.println("sorted");
    show(boxes);
  }
}