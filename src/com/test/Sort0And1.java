package com.test;

import java.util.Arrays;

public class Sort0And1 {
  public static void main(String[] args) {
    int a[] = {0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0};
    System.out.println(Arrays.toString(a));
    int i = 0;
    int j = a.length - 1;
    while (i < j) {
      if (a[i] == 1) {
        swap(a, i, j);
        j--;
      }
      i++;
//      i++;
//      j--;
    }

    System.out.println(Arrays.toString(a));
  }

  static void swap(int a[], int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
