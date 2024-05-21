package com.test;


import java.util.Arrays;

public class LeftRotateMatrix {

  static void print(int mat[][]) {
    for (int i = 0; i < mat.length; i++) {
      System.out.println(Arrays.toString(mat[i]));
    }
    System.out.println();
  }

  static int[][] rotate(int mat[][]) {
    int n = mat.length;

    int ans[][] = new int[n][n];

    for (int i = 0; i < n; i++) {
      int k = 0;
      for (int j = n-1; j >=0; j--) {
        ans[k][i] = mat[i][j];
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
