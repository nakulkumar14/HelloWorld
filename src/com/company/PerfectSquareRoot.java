package com.company;

public class PerfectSquareRoot {

  static int sqrtBinarySearch(int n) {
    int low = 0;
    int high = n;
    int ans = 0;
    while (low <= high) {
      int mid = (high + low) / 2;
      if (mid * mid == n) {
        return mid;
      }
      if (mid*mid < n) {
        low = mid+1;
        ans = mid;
      } else {
        high = mid-1;
      }
    }
    return ans;
  }

  static int sqrt(int n) {
    if (n < 2) {
      return n;
    }
    for (int i = 2; i <= n / 2; i++) {
      if (i * i == n) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    for (int i = 0; i < 100; i++) {
      int sqrt = sqrt(i);
      if (sqrt != -1) {
//        System.out.println(i + ": " + sqrt);
//        System.out.println(i + ": bs : " + sqrtBinarySearch(i));
      }
      System.out.println(i + ": bs : " + sqrtBinarySearch(i));
    }
  }
}
