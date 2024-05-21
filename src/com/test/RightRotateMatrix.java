package com.test;

import java.util.Arrays;

public class RightRotateMatrix {

  static void print(int mat[][]) {
    for (int i = 0; i < mat.length; i++) {
      System.out.println(Arrays.toString(mat[i]));
    }
    System.out.println();
  }

  static int[][] rotate(int mat[][]) {
    int n = mat.length;

    int ans[][] = new int[n][n];
    for (int j = 0; j < n; j++) {
      int k = 0;
      for (int i = n - 1; i >= 0; i--) {
        ans[j][k] = mat[i][j];
        k++;
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    int mat[][] = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };

    print(mat);
    print(rotate(mat));

  }
}
