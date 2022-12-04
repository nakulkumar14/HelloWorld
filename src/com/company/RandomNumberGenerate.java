package com.company;

import java.util.Random;

public class RandomNumberGenerate {

  static int magicNumber() {
    Random r = new Random();
    return r.nextInt(2);
  }

  static int generate(int n) {

    int result = 0;
    int i = 0;
    while (result < n) {
      int increment = (int) (magicNumber() * Math.pow(2, i));
      if (result + increment < n) {
        result += increment;
      } else {
        break;
      }
      i++;
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(generate(10));
    System.out.println(generate(100));
  }
}
