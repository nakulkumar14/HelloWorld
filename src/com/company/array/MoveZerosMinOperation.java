package com.company.array;

import java.util.Arrays;

public class MoveZerosMinOperation {
  static void move(int a[]) {
    int j = -1;
    for (int i = 0; i < a.length; i++) {
      if (a[i] == 0) {
        System.out.println(i);
        j++;
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
      }
    }
  }

  public static void main(String[] args) {
    int[] a = {6, 0, 8, 2, 3, 0, 4, 0, 1};
    System.out.println(Arrays.toString(a));
    move(a);
    System.out.println(Arrays.toString(a));
  }
}
