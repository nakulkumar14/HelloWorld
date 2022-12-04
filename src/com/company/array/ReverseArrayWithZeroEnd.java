package com.company.array;

import java.util.Arrays;

public class ReverseArrayWithZeroEnd {

  static void reverseArr(int a[]) {

    if (a == null || a.length == 0)
      return;

    int j = 0;
    for (int i = 0; i < a.length; i++) {
      if (a[i] != 0) {
        a[j] = a[i];
        j++;
      }
    }
    while (j < a.length) {
      a[j++] = 0;
    }

//    System.out.println(Arrays.toString(a));

    int k = -1;
    int low = 0, high = a.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (a[mid] == 0) {
        if (mid == 0 || a[mid - 1] != 0) {
          k = mid;
          break;
        } else {
          high = mid;
        }
      } else {
        low = mid + 1;
      }
    }

    j = 0;
    k = k != -1 ? k - 1 : a.length - 1;

    while (j <= k) {
      int temp = a[j];
      a[j] = a[k];
      a[k] = temp;
      j++;
      k--;
    }

  }

  public static void main(String[] args) {
    int a[] = {0, 4, 2, 3, 0, 9, 10, 0, 34, 8, 0, 23, 56, 12};
//    int a[] = null;
//    int a[] = {1,2,3,4,5};
//    int a[] = {0,0,0,0};

    reverseArr(a);
    System.out.println(Arrays.toString(a));
  }
}
