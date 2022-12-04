package com.company.strings;

public class ContainsString {
  static boolean contains(String s1, String s2) {
    int j = 0;
    for (int i = 0; i < s1.length() && j < s2.length(); i++) {
      if (s1.charAt(i)!=s2.charAt(j)) {
        j = 0;
      } else {
        j++;
      }
    }
    return j == s2.length();
  }
  public static void main(String[] args) {
    System.out.println(contains("abcdabcd","cdab"));
    System.out.println(contains("abcdabcd","cdaz"));
    System.out.println(contains("abcdabcd","ddab"));
    System.out.println(contains("abcdabcd","a"));
  }
}
