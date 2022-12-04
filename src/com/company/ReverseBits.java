package com.company;

import java.util.Iterator;
import java.util.List;

public class ReverseBits {

  static int reverse(int n) {
    int rev = 0;
    while (n != 0) {
      rev = rev << 1;
      if ((n & 1) == 1) {
        rev = rev ^ 1;
      }
        n >>= 1;
    }
    return rev;
  }

  public static void main(String[] args) {
    System.out.println(reverse(10));
    System.out.println(reverse(11));

    List<Integer> integers = List.of(1, 2, 3);
    Iterator<Integer> iterator = integers.iterator();
    List<Integer> iterator1 = (List<Integer>) iterator;
  }
}
