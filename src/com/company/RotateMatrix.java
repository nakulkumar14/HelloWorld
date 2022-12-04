package com.company;

import java.util.Arrays;

public class RotateMatrix {

  static void show(int a[][]) {
    for (int i = 0; i < a.length; i++) {
      System.out.println(Arrays.toString(a[i]));
    }
  }

  static void rotateRight90_1(int a[][]) {
    if (a == null || a.length == 0) {
      return;
    }
    System.out.println("Before Right rotation");
    show(a);

    int m = a.length;
    int n = a[0].length;
    int mat[][] = new int[n][m];

    for (int i = 0, j = m - 1; i < n && j>=0; i++, j--) {
      for (int k = 0; k < n; k++) {
        mat[k][j] = a[i][k];
      }
    }
    System.out.println("After rotation");
    show(mat);
  }

  static void leftRotate(int a[][]) {
    if (a == null || a.length == 0) {
      return;
    }
    System.out.println("===================");
    System.out.println("Before Left rotation");
    show(a);

    int m = a.length;
    int n = a[0].length;
    int mat[][] = new int[n][m];

    for (int i = 0; i < m; i++) {
      int j = n - 1;
      int k = 0;
      while (k < n && j >= 0) {
        mat[k++][i] = a[i][j--];
      }
    }

    System.out.println("After rotation");
    show(mat);
  }

  public static void main(String[] args) {
    int a[][] = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };

    rotateRight90_1(a);
    leftRotate(a);

    int b[][] = {
        {1, 2, 3},
        {4, 5, 6}
    };
    rotateRight90_1(b);
    leftRotate(b);
  }
}
