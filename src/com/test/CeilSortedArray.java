package com.test;

public class CeilSortedArray {
  static void ceil(int a[], int x) {
    int i = 0;
    int j = a.length - 1;
    while (i <= j) {
      int m = (i + j) / 2;
      if (a[m] == x) {
        break;
      }
      if (a[m] < x) {
        i = m + 1;
      } else {
        j = m - 1;
      }
    }

    System.out.println(i < a.length ? a[i] : -1);
  }

  static void linear(int a[], int x) {
    boolean flag = true;
    for (int i = 0; i < a.length; i++) {
      if (a[i] >= x) {
        flag = false;
        System.out.println(a[i]);
        break;
      }
    }

    if (flag) {
      System.out.println(-1);
    }
  }

  static void ceil2(int a[], int x, int l, int h) {
    int i = ceil2util(a, x, l, h);
    System.out.println(i != -1 ? a[i] : -1);
  }

  static int ceil2util(int[] a, int x, int l, int h) {
    if (l <= h) {
      int m = (l + h) / 2;
      if (a[m] == x) {
        return m;
      }
      if (a[m] < x) {
        int ans = ceil2util(a, x, l, m - 1);
        return ans >= x ? ans : a[m];

      } else {
        return ceil2util(a, x, m + 1, h);
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 8, 10, 10, 12, 19};
    ceil(a, 3);
    ceil(a, 23);
    ceil(a, 11);
    linear(a, 3);
    linear(a, 32);
    linear(a, 11);
    ceil2(a, 3, 0, a.length - 1);
    ceil2(a, 32, 0, a.length - 1);
    ceil2(a, 11, 0, a.length - 1);
  }
}
