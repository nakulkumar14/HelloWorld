package com.test;

public class PowerOfNumber {

  public static double myPow(double x, int n) {
    if (n == 0)
      return 1;
    if (x == 0)
      return 0;
    if (n < 0) {
      n = -n;
      x = 1/x;
    }
    return n%2 == 0? myPow(x*x, n/2) : x * myPow(x*x, n/2);
  }

  public static void main(String[] args) {
//    System.out.println(myPow(2, -2));
    System.out.println(myPow(34.00515, -3));
//    System.out.println(myPow(2, 10));
  }
}
