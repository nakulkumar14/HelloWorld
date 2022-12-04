package com.company.sort;

import java.util.Arrays;

public class InsertionSort {
  static void sort(int[] a) {
    for (int i = 1; i < a.length; i++) {
      int value = a[i];
      int j = i;
      while (j > 0 && a[j - 1] > value) {
        a[j] = a[j - 1];
        j--;
      }
      a[j] = value;
    }
  }

  static void sort_recur(int a[], int i) {
    if (i == a.length) {
      return;
    }
    int value = a[i];
    int j = i;
    while (j > 0 && a[j - 1] > value) {
      a[j] = a[j - 1];
      j--;
    }
    a[j] = value;
    sort_recur(a, i + 1);
  }

  public static void main(String[] args) {
    int arr[] = {4, -6, 9, 7, 6, -3, 2, 0, 1, -5, 12, -1};
    System.out.println(Arrays.toString(arr));
//    sort(arr);
    sort_recur(arr, 1);
    System.out.println(Arrays.toString(arr));
  }
}
