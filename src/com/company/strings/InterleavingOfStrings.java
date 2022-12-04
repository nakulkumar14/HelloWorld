package com.company.strings;

public class InterleavingOfStrings {

  static boolean isInterleaved(String a, String b, String c) {
    if (a.length() + b.length() != c.length())
      return false;

    boolean[][] dp = new boolean[a.length() + 1][b.length() + 1];

    for (int i = 0; i <= a.length(); i++) {
      for (int j = 0; j <= b.length(); j++) {
        if (i == 0 && j == 0)
          dp[i][j] = true;
        else if (i == 0) {
          if (b.charAt(j - 1) == c.charAt(j - 1))
            dp[i][j] = dp[i][j - 1];
        } else if (j == 0) {
          if (a.charAt(i - 1) == c.charAt(i - 1))
            dp[i][j] = dp[i - 1][j];
        } else if (i - 1 >= 0 && j - 1 >= 0 && a.charAt(i - 1) != c.charAt(i + j - 1) &&
            b.charAt(j - 1) == c.charAt(i + j - 1))
          dp[i][j] = dp[i][j - 1];
        else if (i - 1 >= 0 && j - 1 >= 0 && b.charAt(j - 1) != c.charAt(i + j - 1) &&
            a.charAt(i - 1) == c.charAt(i + j - 1))
          dp[i][j] = dp[i - 1][j];
        else if (i - 1 >= 0 && j - 1 >= 0 && a.charAt(i - 1) == c.charAt(i + j - 1) &&
            b.charAt(j - 1) == c.charAt(i + j - 1))
          dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
      }
    }

    return dp[a.length()][b.length()];
  }

  static void test(String A, String B, String C) {
    if (isInterleaved(A, B, C))
      System.out.println(C + " is interleaved of " +
          A + " and " + B);
    else
      System.out.println(C + " is not interleaved of " +
          A + " and " + B);
  }

  public static void main(String[] args) {
    test("XXY", "XXZ", "XXZXXXY");
    test("XY", "WZ", "WZXY");
    test("XY", "X", "XXY");
    test("YX", "X", "XXY");
    test("XXY", "XXZ", "XXXXZY");
    test("aabcc", "dbbca", "aadbbcbcac");
  }
}
