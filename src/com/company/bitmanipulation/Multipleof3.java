package com.company.bitmanipulation;

public class Multipleof3 {

  static int countBits(int n) {
    int sumofbits = 0;
    while (n > 0) {
      sumofbits += ((n & 1) == 1) ? 1 : 0;
      n >>= 1;
    }
    return sumofbits;
  }

  static boolean isMultipleOf3(int n) {
    int oddbits = 0x55555555 & n;
    int evenbits = 0xAAAAAAAA & n;
    int sumofoddbits = countBits(oddbits);
    int sumofevenbits = countBits(evenbits);
    return Math.abs(sumofevenbits-sumofoddbits)%3 == 0;
  }

  public static void main(String[] args) {
    System.out.println(isMultipleOf3(23));
    System.out.println(isMultipleOf3(30));
    System.out.println(isMultipleOf3(27));
    System.out.println(isMultipleOf3(18));
    System.out.println(isMultipleOf3(64));
  }
}
