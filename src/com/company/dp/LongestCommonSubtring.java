package com.company.dp;

public class LongestCommonSubtring {

//  int longestCommonSubstr(String S1, String S2, int n, int m) {
//
//    // Initialize memoization table
//    int[][] memo = new int[n + 1][m + 1];
//    for (int i = 0; i <= n; i++) {
//      for (int j = 0; j <= m; j++) {
//        memo[i][j] = -1; // -1 indicates that the result is not yet computed
//      }
//    }
//
//    return longestCommonSubstrRecur(S1, S2, n, m, 0, memo);
//  }
//
//  int longestCommonSubstrRecur(String s1, String s2, int n, int m, int result, int[][] memo) {
//    if (n == 0 || m == 0)
//      return 0;
//
//    if (memo[n][m] != -1) {
//      // Return the stored result if it's already computed
//      return memo[n][m];
//    }
//
//
//    if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
////      return longestCommonSubstrRecur(s1, s2, n - 1, m - 1, result + 1, memo);
//      memo[n][m] = longestCommonSubstrRecur(s1, s2, n - 1, m - 1, result + 1, memo);
//      return memo[n][m];
//    }
//    int a = longestCommonSubstrRecur(s1, s2, n - 1, m, result, memo);
//    int b = longestCommonSubstrRecur(s1, s2, n, m - 1, result, memo);
////    return Math.max(result, Math.max(a, b));
//    memo[n][m] = Math.max(result, Math.max(a, b));
//    return memo[n][m];
//  }
public int longestCommonSubstr(String S1, String S2, int n, int m) {
  int[][] memo = new int[n + 1][m + 1];
  for (int i = 0; i <= n; i++) {
    for (int j = 0; j <= m; j++) {
      memo[i][j] = -1;
    }
  }

  return longestCommonSubstrRecur(S1, S2, n, m, 0, memo);
}

  private int longestCommonSubstrRecur(String s1, String s2, int n, int m, int result, int[][] memo) {
    if (n == 0 || m == 0) {
      return result;
    }

    if (memo[n][m] != -1) {
      return memo[n][m];
    }

    if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
      memo[n][m] = longestCommonSubstrRecur(s1, s2, n - 1, m - 1, result + 1, memo);
      return memo[n][m];
    }

    int a = longestCommonSubstrRecur(s1, s2, n - 1, m, 0, memo);
    int b = longestCommonSubstrRecur(s1, s2, n, m - 1, 0, memo);
    memo[n][m] = Math.max(result, Math.max(a, b));
    return memo[n][m];
  }

  public static void main(String[] args) {
    LongestCommonSubtring o = new LongestCommonSubtring();
    System.out.println(o.longestCommonSubstr("ABCDGH", "ACDGHR", 6, 6));
  }
}
