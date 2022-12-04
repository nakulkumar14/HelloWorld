package com.company.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WorkBreak {

  private static boolean wordBreak1(String word, Set<String> set) {
    if (word == null || word.length() == 0) {
      return true;
    }
    for (int i = 1; i <= word.length(); i++) {
      String str = word.substring(0, i);
      if (set.contains(str) && wordBreak1(word.substring(i), set)) {
        System.out.println(str);
        return true;
      }
    }
    return false;
  }

  private static void wordBreak2(String word, Set<String> set) {
    String ans = "";
    System.out.println("len : " + word.length());
    wordBreak2Util(word, set, ans, word.length());
  }

  private static void wordBreak2Util(String word, Set<String> set, String ans, int length) {
    for (int i = 1; i <= word.length(); i++) {
      String str = word.substring(0, i);
      if (set.contains(str)) {
        if (i == length) {
          System.out.println(i);
          ans += str;
          System.out.println("ans : " + ans);
          return;
        }
        wordBreak2Util(word.substring(i), set, ans + str + " ", length - i);
      }
    }
  }

  static Boolean dp[];

  static void wordBreak3(String word, Set<String> set) {
    dp = new Boolean[word.length()];
    System.out.println(wordBreak3Util(word, set, 0));
  }

  private static boolean wordBreak3Util(String word, Set<String> set, int p) {
    if (p == word.length()) {
      return true;
    }
    if (dp[p] != null)
      return dp[p];
    for (int i = p + 1; i <= word.length(); i++) {
      String s = word.substring(p, i);
      if (set.contains(s) && wordBreak3Util(word, set, i)) {
        dp[p] = true;
        return dp[p];
      }
    }
    return dp[p];
  }

  public static void main(String[] args) {
    String dict[] = {"this", "th", "is", "famous", "Word", "break", "b",
        "r", "e", "a", "k", "br", "bre", "brea", "ak", "problem" };
    Set<String> set = new HashSet<>(Arrays.asList(dict));

    System.out.println(wordBreak1("Wordbreakproblem", set));
    System.out.println();

    wordBreak2("Wordbreakproblem", set);
    wordBreak3("Wordbreakproblem", set);
  }
}
