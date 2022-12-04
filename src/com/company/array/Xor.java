package com.company.array;

public class Xor {

  static int missing(int a[], int n) {
    int xor = 0;
    // xor of array elements.
    for(int i=0;i<a.length;i++) {
      xor = xor^a[i];
    }

    // xor of numbers from 1 to n.
    for(int i=1;i<=n;i++) {
      xor = xor^i;
    }

    System.out.println(xor);
    return xor;
  }

  public static void main(String[] args) {
  int a[] = {5,2,1,8,3,7,9,6};
  missing(a, 9);
  }
}
