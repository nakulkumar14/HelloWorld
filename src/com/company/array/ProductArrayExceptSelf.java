package com.company.array;

import java.util.Arrays;

public class ProductArrayExceptSelf {

  static void productArray1(int a[]) {
    int n = a.length;

    int left[] = new int[n];
    int right[] = new int[n];
    int prod[] = new int[n];

    left[0] = 1;
    for (int i = 1; i < n; i++) {
      left[i] = left[i - 1] * a[i - 1];
    }
    System.out.println(Arrays.toString(left));

    right[n - 1] = 1;
    for (int i = n - 2; i >= 0; i--) {
      right[i] = right[i + 1] * a[i + 1];
    }

    for (int i = 0; i < n; i++) {
      prod[i] = left[i] * right[i];
    }

    System.out.println(Arrays.toString(prod));
  }

  static void productArray2(int[] a) {
    int n = a.length;
    int[] prod = new int[n];
    Arrays.fill(prod, 1);

    int temp = 1;
    for (int i = 0; i < n; i++) {
      prod[i] = prod[i] * temp;
      temp = temp * a[i];
    }

    temp = 1;
    for (int i = n - 1; i >= 0; i--) {
      prod[i] = prod[i] * temp;
      temp = temp * a[i];
    }

    System.out.println(Arrays.toString(prod));
  }

  public static void main(String[] args) {
    int[] array = {10, 3, 5, 6, 2};
    productArray1(array);
    productArray2(array);
  }
}
