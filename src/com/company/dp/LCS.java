package com.company.dp;

import java.util.Arrays;

public class LCS {

  static int lcs1(String a, String b, int n, int m) {
    if (n == 0 || m == 0)
      return 0;
    if (a.charAt(n - 1) == b.charAt(m - 1))
      return 1 + lcs1(a, b, n - 1, m - 1);
    else
      return Math.max(lcs1(a, b, n - 1, m), lcs1(a, b, n, m - 1));
  }

  static void lcs2(String a, String b) {
    int m = a.length();
    int n = b.length();
    int dp[][] = new int[m + 1][n + 1];
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0 || j == 0)
          dp[i][j] = 0;
        else if (a.charAt(i - 1) == b.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    // print dp table
//    for (int i = 0; i <= m; i++) {
//      System.out.println(Arrays.toString(dp[i]));
//    }

    // print lcs length
//    System.out.println("len : " + dp[m][n]);

    String ans = "";
    int index = dp[m][n];
    char[] res = new char[index];
    int i = m;
    int j = n;
    while (i > 0 && j > 0) {
      if (a.charAt(i - 1) == b.charAt(j - 1)) {
        res[index - 1] = a.charAt(i - 1);
        ans = a.charAt(i - 1) + ans;
        i--;
        j--;
        index--;
      } else if (dp[i - 1][j] > dp[i][j - 1]) {
        i--;
      } else {
        j--;
      }
    }

    System.out.println(Arrays.toString(res));
    System.out.println("ans : " + ans);
  }


  public static void main(String[] args) {
    String a = "XMJYAUZ", b = "MZJAWXU";
    int n = a.length(), m = b.length();
    System.out.println(lcs1(a, b, n, m));
    lcs2(a, b);
  }
}
