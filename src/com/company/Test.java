package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class Test {

  static String recursive(String str) {

    if (str.length() == 1) {
      return str + '#';
    } else {
      char charNow = str.charAt(0);

      String nonDupString = recursive(str.substring(1));

      if (nonDupString.charAt(0) == charNow) {
        return nonDupString.substring(1);
      } else {
        return charNow + nonDupString;
      }
    }
  }

  public static void main(String[] args) {
    int arr[] = {2, 3, 6, 4, 1, 0};
    System.out.println(Arrays.toString(arr));
    int[] ints = Arrays.stream(arr).boxed()
        .sorted(Comparator.reverseOrder())
        .mapToInt(Integer::intValue)
        .toArray();
    System.out.println(Arrays.toString(ints));

    System.out.println(recursive("abxxxby"));



  }
}
