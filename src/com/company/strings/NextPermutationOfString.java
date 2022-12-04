package com.company.strings;

import java.util.Arrays;

public class NextPermutationOfString {
  private static void swap(char[] chars, int i, int j) {
    char ch = chars[i];
    chars[i] = chars[j];
    chars[j] = ch;
  }

  private static void reverse(char[] chars, int start) {
    for (int i = start, j = chars.length - 1; i < j; i++, j--) {
      swap(chars, i, j);
    }
  }

  static boolean permutations(char c[]) {
    int i = c.length - 1;
    while (c[i - 1] >= c[i]) {
      if (--i == 0) {
        return false;
      }
    }
    int j = c.length - 1;
    while (j > i && c[j] <= c[i - 1]) {
      j--;
    }
    swap(c, i - 1, j);
    Arrays.sort(c, i, c.length);

//    StringBuilder sb = new StringBuilder();
//    sb.append(c, 0, i);
//    Arrays.sort(c, i, c.length);
//
//    for (int j = 0; j < sb.length(); j++) {
//      c[j] = sb.charAt(j);
//    }

    return true;
  }

  static void nextPermutation(String s) {
    char c[] = s.toCharArray();
    while (true) {
      System.out.print(new String(c) + " ");
      if (!permutations(c)) {
        break;
      }
    }
  }

  public static void main(String[] args) {
//    String str = "BADC";
    String str = "BACD";
    nextPermutation(str);
  }
}
