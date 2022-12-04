package com.company.array;

import java.util.Arrays;

public class FirstOccurrence {

  static int firstOccurrence(int a[], int x) {
    if (a == null || a.length == 0)
      return -1;

    int l = 0, h = a.length - 1;
    while (l <= h) {
      System.out.println("l : " + l + ", h : " + h);
      int mid = (l + h) / 2;
      if (a[mid] == x) {
        return mid;
      }
      if (Math.abs(a[mid]) < x) {
        l = mid + 1;
      } else {
        h = mid - 1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    int a[] = {10, -20, 20, -20, 20, 30, 30, -30, -40, -50, -60, 70, 90};
    System.out.println(Arrays.toString(a));
    int i = firstOccurrence(a, 20);
    System.out.println(i == -1 ? -1 : a[i]);
  }
}
