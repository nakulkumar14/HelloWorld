package com.company;

public class SpiralMatrix {

  static void print(int a[][]) {
    int r1 = 0, c1 = 0, r2 = a.length - 1, c2 = a[0].length - 1;

    while (r1 <= r2 && c1 <= c2) {
      int temp = c1;
      while (temp <= c2) {
        System.out.print(a[r1][temp++] + " ");
      }
      r1++;

      if (r1 > r2)
        break;

      temp = r1;
      while (temp <= r2) {
        System.out.print(a[temp++][c2] + " ");
      }
      c2--;
      temp = c2;
      while (temp >= c1) {
        System.out.print(a[r2][temp--] + " ");
      }
      r2--;
      temp = r2;
      while (temp >= r1) {
        System.out.print(a[temp--][c1] + " ");
      }
      c1++;
    }
  }

  public static void main(String[] args) {
    int a[][] = {
        {1, 2, 3, 4, 5},
        {10, 20, 30, 40, 50},
        {11, 21, 31, 41, 51}
    };

    print(a);
    System.out.println();

    int b[][] = {
        {1,2},
        {3,4}
    };
    print(b);
  }
}
