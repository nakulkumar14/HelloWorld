package com.company.sort;

import java.util.Arrays;

public class SelectionSort {

  public static void sort(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      int min = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[min] > arr[j]) {
          min = j;
        }
      }

      if (min != i) {
        swap(arr, i, min);
      }
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    int arr[] = {4, -6, 9, 7, 6, -3, 2, 0, 1, -5, 12, -1};
    System.out.println(Arrays.toString(arr));
    sort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
