package com.company.dp;

import java.util.Arrays;

public class SubsetSum {

  // recursive
  static boolean isSubsetSum(int a[], int sum, int n) {
    if (sum == 0)
      return true;
    if (n == 0)
      return false;
    return isSubsetSum(a, sum, n - 1)
        || isSubsetSum(a, sum - a[n - 1], n - 1);
  }

  // memoization
  static boolean isSubsetSumMemoize(int a[], int sum, int n) {
    Boolean t[][] = new Boolean[n + 1][sum + 1];
    return isSubsetSumMemoizeUtil(a, sum, n, t);
  }

  static boolean isSubsetSumMemoizeUtil(int[] a, int sum, int n, Boolean[][] t) {
    if (sum == 0)
      return true;
    if (n == 0)
      return false;
    if (t[n][sum] != null)
      return t[n][sum];
    if (a[n - 1] > sum)
      return t[n][sum] = isSubsetSumMemoizeUtil(a, sum, n - 1, t);
    return t[n][sum] = isSubsetSumMemoizeUtil(a, sum, n - 1, t) || isSubsetSumMemoizeUtil(a, sum - a[n - 1], n - 1, t);
  }

  static boolean isSubsetSumTopDown(int a[], int sum, int n) {
    boolean[][] t = new boolean[n + 1][sum + 1];
    for (int i = 0; i < sum + 1; i++) {
      t[0][i] = false;
    }
    for (int i = 0; i < n + 1; i++) {
      t[i][0] = true;
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < sum + 1; j++) {
        if (a[i - 1] > j)
          t[i][j] = t[i - 1][j];
        else
          t[i][j] = t[i - 1][j] || t[i - 1][j - a[i - 1]];
      }
    }

    for (int i = 0; i < n + 1; i++) {
      System.out.println(Arrays.toString(t[i]));
    }

    return t[n][sum];
  }

  public static void main(String[] args) {
    int a[] = {1, 5, 3, 7, 4};
    int sum = 12;
    System.out.println("recursive " + isSubsetSum(a, sum, a.length));
    System.out.println("memo " + isSubsetSumMemoize(a, sum, a.length));
    System.out.println("top down " + isSubsetSumTopDown(a, sum, a.length));

    int set[] = {3, 34, 4, 12, 5, 2};
    sum = 9;
    System.out.println("recursive " + isSubsetSum(set, sum, set.length));
    System.out.println("memo " + isSubsetSumMemoize(set, sum, set.length));
    System.out.println("top down " + isSubsetSumTopDown(set, sum, set.length));

    int b[] = {2,3,5,6,8,10};
    sum = 10;
    System.out.println("top down " + isSubsetSumTopDown(b, sum, b.length));
  }
}
