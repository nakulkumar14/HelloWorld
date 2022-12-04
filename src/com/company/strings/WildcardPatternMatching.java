package com.company.strings;

import java.util.Arrays;

public class WildcardPatternMatching {

  static int strmatch(String str, String pattern,
                      int n, int m) {
    // empty pattern can only match with
    // empty string
    if (m == 0)
      return (n == 0) ? 1 : 0;

    // lookup table for storing results of
    // subproblems
    int[][] lookup = new int[n + 1][m + 1];

    // initialize lookup table to false
    for (int i = 0; i < n + 1; i++)
      Arrays.fill(lookup[i], 0);

    // empty pattern can match with empty string
    lookup[0][0] = 1;

    // Only '*' can match with empty string
    for (int j = 1; j <= m; j++)
      if (pattern.charAt(j - 1) == '*')
        lookup[0][j] = lookup[0][j - 1];

    for (int i = 0; i <= n; i++) {
      System.out.println(Arrays.toString(lookup[i]));
    }


    // fill the table in bottom-up fashion
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        // Two cases if we see a '*'
        // a) We ignore '*'' character and move
        //    to next  character in the pattern,
        //     i.e., '*' indicates an empty
        //     sequence.
        // b) '*' character matches with ith
        //     character in input
        if (pattern.charAt(j - 1) == '*')
          lookup[i][j] = lookup[i][j - 1] == 1 ? 1 : lookup[i - 1][j];

          // Current characters are considered as
          // matching in two cases
          // (a) current character of pattern is '?'
          // (b) characters actually match
        else if (pattern.charAt(j - 1) == '?'
            || str.charAt(i - 1)
            == pattern.charAt(j - 1))
          lookup[i][j] = lookup[i - 1][j - 1];

          // If characters don't match
        else
          lookup[i][j] = 0;
      }
    }

    System.out.println("==");
    for (int i = 0; i <= n; i++) {
      System.out.println(Arrays.toString(lookup[i]));
    }

    return lookup[n][m];
  }

  static boolean match(char[] txt, char[] patt, int n, int m, Boolean dp[][]) {
    if (n < 0 && m < 0) {
      return true;
    }
    if (m < 0) {
      return false;
    }
    if (n < 0) {
      while (m >= 0) {
        if (patt[m] != '*')
          return false;
        m--;
      }
      return true;
    }

    if (dp[n][m] == null) {
      if (patt[m] == '*') {
        dp[n][m] = match(txt, patt, n , m - 1, dp) || match(txt, patt, n - 1, m, dp);
      } else {
        if (txt[n] != patt[m] && patt[m] != '?') {
          dp[n][m] = false;
        } else {
          return dp[n][m] = match(txt, patt, n - 1, m - 1, dp);
        }
      }
    }
    return dp[n][m];
  }

  static boolean match(char[] txt, char[] patt) {
    Boolean dp[][] = new Boolean[txt.length][patt.length];
    return match(txt, patt, txt.length - 1, patt.length - 1, dp);
  }

  public static void main(String[] args) {
    System.out.println(strmatch("baabab", "ba*a?", 6, 5));
    System.out.println(match("abcabczzzde".toCharArray(), "*abc???de*".toCharArray()));
  }
}
