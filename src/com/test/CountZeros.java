package com.test;

public class CountZeros {
  static int countZeros(int A[][], int N) {
    // Your code here
    int count = 0;

    int j = N - 1;
    int i = 0;

    while (i<N && j>=0) {
      if (A[i][j] == 0) {
        count+=i+1;
        i++;
      } else {
        j--;
      }
    }

    return count;
  }

  public static void main(String[] args) {
    int a[][] = {
        {0, 0, 1},
        {0, 1, 1},
        {1, 1, 1}
    };
    System.out.println(countZeros(a, a.length));
  }
}
