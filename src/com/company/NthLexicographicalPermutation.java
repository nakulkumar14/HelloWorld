package com.company;

import java.util.Arrays;

public class NthLexicographicalPermutation {

  static int factorial(int n) {
    int fact = 1;
    for (int i = 2; i <= n; i++) {
      fact = fact * i;
    }
    return fact;
  }

  static int[] generateFactorialString(int n) {
    StringBuilder sb = new StringBuilder();
    int i = 1;
    while (n > 0) {
      int r = n % i;
      sb.append(r);
      n /= i;
      i++;
    }
    char[] chars = sb.reverse().toString().toCharArray();
    int[] result = new int[sb.length()];
    for (int j = 0; j < chars.length; j++) {
      result[j] = (int) (chars[j] - '0');
    }
    return result;
  }

  private static void nthLexicographicalPermutation(String s, int n) {
    // 32010
    int[] factorialString = generateFactorialString(n);
//    System.out.println("factorialString : " + Arrays.toString(factorialString) + ", n : " + n);
    char[] chars = s.toCharArray();
    // dcade -> abcde
    Arrays.sort(chars);
    // abcde
    StringBuilder sb = new StringBuilder(String.valueOf(chars));
//    System.out.println("String after sorting : " + sb);
    StringBuilder result = new StringBuilder();


//    System.out.println(sb.length() +", " + factorialString.length);
    if (sb.length() > factorialString.length) {
      int diff = sb.length() - factorialString.length;
      int updatedFactorialString[] = new int[factorialString.length + diff];
      int i = 0;
      while (i < diff) {
        updatedFactorialString[i] = 0;
        i++;
      }

      for (int j = 0; j < factorialString.length; j++) {
        updatedFactorialString[j + i] = factorialString[j];
      }
//      System.out.println("updatedFactorialString : " + Arrays.toString(updatedFactorialString));
      factorialString = updatedFactorialString;
    }
//    System.out.println("updatedFactorialString : " + Arrays.toString(factorialString));
    boolean[] visited = new boolean[sb.length()];
    for (int i = 0; i < factorialString.length; i++) {
      int index = factorialString[i];
      char unusedChar = getUnusedChar(sb, visited, index);
      result.append(unusedChar);
    }

    System.out.println("n : " + n + ", Permutation : " + result);
  }

  private static char getUnusedChar(StringBuilder sb, boolean[] visited, int index) {
//    int count = -1;
    int count = 0;
    for (int j = 0; j < sb.length(); j++) {
      if (!visited[j]) {

        if (count == index) {
//          System.out.println("char : " + sb.charAt(j) + ", index : " + j);
          visited[j] = true;
          return sb.charAt(j);
        }
        count++;
      }
    }
    return ' ';
  }

  public static void main(String[] args) {
    String s = "abcd";
    int n = s.length();
    int totalPermutations = factorial(n);
    System.out.println("Original string : " + s + ", total permutations : " + totalPermutations);

    for (int i = 0; i < totalPermutations; i++) {
      nthLexicographicalPermutation(s, i);
    }
  }
}
