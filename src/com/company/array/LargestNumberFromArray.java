package com.company.array;

import java.util.Arrays;

public class LargestNumberFromArray {

  static String printLargest(String[] arr) {

    Arrays.sort(arr, (o1, o2) -> {
      Integer i1 = Integer.parseInt(o1 + o2);
      Integer i2 = Integer.parseInt(o2 + o1);
      return i2.compareTo(i1);
    });

    return String.join("", arr);
  }

  public static void main(String[] args) {
    System.out.println(printLargest(new String[]{"3", "30", "34", "5", "9"}));
    System.out.println(printLargest(new String[]{"54", "546", "548", "60"}));
  }
}
