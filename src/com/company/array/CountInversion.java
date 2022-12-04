package com.company.array;

import java.util.Arrays;

public class CountInversion {
  static int countinversion(int[] a) {
    int count = 0;
    for (int i = 0; i < a.length; i++) {
      for (int j = i + 1; j < a.length; j++) {
        if (a[i] > a[j]) {
          count++;
        }
      }
    }
    return count;
  }

  static int countinversion2(int[] a, int l, int h) {
    int count = 0;
    if (l < h) {
      int m = (l + h) / 2;
      count += countinversion2(a, l, m);
      count += countinversion2(a, m + 1, h);
      count += sort(a, l, m, h);
    }
    return count;
  }

  static int sort(int[] a, int l, int m, int h) {
    int swaps = 0;
    int i = 0, j = 0;
    int k = l;

    int left[] = Arrays.copyOfRange(a, l, m + 1);
    int right[] = Arrays.copyOfRange(a, m + 1, h + 1);
    while (i < left.length && j < right.length) {
      if (left[i] <= right[j]) {
        a[k++] = left[i++];
      } else {
        a[k++] = right[j++];
        swaps += (m + 1) - (l + i);
      }
    }

    while (i < left.length)
      a[k++] = left[i++];

    while (j < right.length)
      a[k++] = right[j++];

    return swaps;
  }

  public static void main(String[] args) {
    int[] arr = {1, 20, 6, 4, 5};
    System.out.println(countinversion(arr));
    System.out.println(countinversion2(arr, 0, arr.length - 1));
  }
}
