package com.company;

import java.util.Arrays;

public class MedianArr {

  static int median1(int a[], int b[]) {
    int[] temp = new int[a.length + b.length];
    int i = 0;
    for (int j = 0; j < a.length; j++) {
      temp[i++] = a[j];
    }
    for (int j = 0; j < b.length; j++) {
      temp[i + j] = b[j];
    }
    Arrays.sort(temp);
    System.out.println(Arrays.toString(temp));
    if (temp.length % 2 != 0) {
      return temp[temp.length / 2];
    } else {
      return (temp[temp.length / 2] + temp[temp.length / 2 - 1]) / 2;
    }
  }

  public static void main(String[] args) {
    int ar1[] = {900};
    int ar2[] = {5, 8, 10};
    System.out.println(median1(ar1, ar2));
  }
}
