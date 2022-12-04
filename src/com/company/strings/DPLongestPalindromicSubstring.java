package com.company.strings;

public class DPLongestPalindromicSubstring {

  static String longestPalin(String S){
    // code here
    int dp[][] = new int[S.length()][S.length()];
    for(int i=0;i<S.length();i++){
      dp[i][i] = 1;
    }

    int max = 1;
    int start = 0;
    for(int i=0;i<S.length()-1;i++){
      if(S.charAt(i) == S.charAt(i+1)) {
        dp[i][i+1] = 1;
        start = i;
        max = 2;
      }
    }

    for(int k=3;k<=S.length();k++){
      for(int i=0;i<S.length()-k+1;i++){
        int j = i + k - 1;
        if(dp[i+1][j-1] == 1 && S.charAt(i) == S.charAt(j)) {
          dp[i][j] = 1;

          if (k > max) {
            max = k;
            start = i;
          }

        }
      }
    }

//    for(int i=0;i<S.length();i++){
//      for(int j=0;j<S.length();j++){
//        System.out.print(dp[i][j]+" ");
//      }
//      System.out.println();
//    }

    System.out.println(S.substring(start, start + max));

    return "";
  }

  public static void main(String[] args) {
    System.out.println(longestPalin("aaaabbaa"));
    System.out.println(longestPalin("forgeeksskeegfor"));
    System.out.println(longestPalin("rfkqyuqfjkxy"));
  }
}
