package com.company;

import java.util.Arrays;

public class MedianEqualArr {

  // O(n) space and time
  static int median1(int a[], int b[]) {
    int temp[] = new int[a.length + b.length];
    int i = 0;
    for (i = 0; i < a.length; i++) {
      temp[i] = a[i];
    }
    for (int j = 0; j < b.length; j++) {
      temp[i + j] = b[j];
    }
    Arrays.sort(temp);
    System.out.println(Arrays.toString(temp));
    return (temp[a.length - 1] + temp[a.length]) / 2;
  }

  // O(n) time and O(1) space
  static int median2(int a[], int b[]) {
    int n = a.length;
    int m1 = -1;
    int m2 = -1;
    int j = 0, i = 0;
    for (int k = 0; k <= n; k++) {
      if (i == n) {
        m1 = m2;
        m2 = b[0];
        break;
      }
      if (j == n) {
        m1 = m2;
        m2 = a[0];
        break;
      }
      if (a[i] <= b[j]) {
        m1 = m2;
        m2 = a[i];
        i++;
      } else if (a[i] > b[j]) {
        m1 = m2;
        m2 = b[j];
        j++;
      }
    }
    return (m1 + m2) / 2;
  }

  // O(logn) time and O(1) space
  static int median3(int a[], int b[], int startA, int endA, int startB, int endB) {
    // length == 2
    if (endA - startA == 1) {
      return (Math.max(a[startA], b[startB]) + Math.min(a[endA], b[endB])) / 2;
    }

    int m1 = median(a, startA, endA);
    int m2 = median(b, startB, endB);
    if (m1 == m2) {
      return m1;
    }

    if (m1 < m2) {
      return median3(a, b, (endA + startA + 1) / 2, endA, startB, (endB + startB + 1) / 2);
    } else {
      return median3(a, b, startA, (endA + startA + 1) / 2, (endB + startB + 1) / 2, endB);
    }
  }

  static int median(int a[], int start, int end) {
    int n = end - start + 1;
    if (n % 2 == 0) {
      return (a[start + (n / 2)] + a[start + (n / 2 - 1)]) / 2;
    } else {
      return a[start + n / 2];
    }
  }

  public static void main(String[] args) {
    int ar1[] = {1, 12, 15, 26, 38};
    int ar2[] = {2, 13, 17, 30, 45};
    System.out.println(median1(ar1, ar2));
    System.out.println(median2(ar1, ar2));
    System.out.println(median3(ar1, ar2, 0, ar1.length - 1, 0, ar2.length - 1));
  }
}
