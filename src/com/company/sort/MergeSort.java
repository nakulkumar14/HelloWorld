package com.company.sort;

import java.util.Arrays;

public class MergeSort {

  static void sort(int arr[], int l, int h) {
    if (l < h) {
      int mid = (l + h) / 2;
      sort(arr, l, mid);
      sort(arr, mid + 1, h);
      merge(arr, l, mid, h);
    }
  }

  private static void merge(int[] arr, int l, int mid, int h) {
    int temp[] = new int[h + 1];
    int i = l;
    int j = mid + 1;
    int k = l;
    while (i <= mid && j <= h) {
      if (arr[i] <= arr[j]) {
        temp[k++] = arr[i++];
      } else {
        temp[k++] = arr[j++];
      }
    }

    if (j > h) {
      while (i <= mid) {
        temp[k++] = arr[i++];
      }
    }

    if (i > mid) {
      while (j <= h) {
        temp[k++] = arr[j++];
      }
    }

    for (int m = l; m <=h; m++) {
      arr[m] = temp[m];
    }
  }


  public static void main(String[] args) {
    int arr[] = {8, 12, 9, 11};
    System.out.println(Arrays.toString(arr));
    sort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));

  }
}
