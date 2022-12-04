package com.company;

public class FirstAndLastOccurance {

  static int firstIndex(int arr[], int l, int h, int item) {
    if (l <= h) {
      int mid = (l + h) / 2;
      if ((mid == 0 || arr[mid - 1] < arr[mid]) && arr[mid] == item) {
        return mid;
      } else if ( (mid > 0 && arr[mid] == arr[mid - 1]) || arr[mid] >= item) {
        return firstIndex(arr, l, mid - 1, item);
      } else {
        return firstIndex(arr, mid + 1, h, item);
      }
    }
    return -1;
  }

  static int lastIndex(int arr[], int l, int h, int item) {
    if (l <= h) {
      int mid = (l + h) / 2;
      if ((mid == arr.length - 1 || arr[mid] < arr[mid + 1]) && arr[mid] == item) {
        return mid;
      } else if ((mid + 1 < arr.length && arr[mid] == arr[mid + 1]) || arr[mid] <= item) {
        return lastIndex(arr, mid + 1, h, item);
      } else {
        return lastIndex(arr, l, mid - 1, item);
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int arr[] = {6,6};
    int first = firstIndex(arr, 0, arr.length - 1, 8);
    int last = lastIndex(arr, 0, arr.length - 1, 8);
    System.out.println("first : " + first + ", last : " + last);
  }
}
