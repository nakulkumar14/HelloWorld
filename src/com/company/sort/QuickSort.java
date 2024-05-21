package com.company.sort;

import java.util.Arrays;

public class QuickSort {

  public static void sort(int a[], int beg, int end) {
    if (beg < end) {
      int pivot = parition(a, beg, end);
      sort(a, beg, pivot - 1);
      sort(a, pivot + 1, end);
    }
  }

  static int parition(int[] a, int beg, int end) {
    int i = beg - 1;
    int pivot = a[end];

    for (int j = beg; j < end; j++) {
      if (a[j] <= pivot) {
        i++;
        swap(a, i, j);
      }
    }

    swap(a, i + 1, end);

    return i + 1;
  }

  private static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }


  public static void main(String[] args) {
    int arr[] = {339, 341, 534, 441, 485, 314, 180, 977};
    int[] copy = Arrays.copyOf(arr, arr.length);
    Arrays.sort(copy);
    System.out.println(Arrays.toString(arr));
    System.out.println("copy : " + Arrays.toString(copy));
    sort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }
}
