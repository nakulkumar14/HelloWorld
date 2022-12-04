package com.company.strings;

import java.util.HashSet;
import java.util.Set;

public class PalindromicSubstrings {
  static void palindromicsubstrings(String s) {
    Set<String> set = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      eval(s, i, i, set);
      eval(s, i, i + 1, set);
    }

    System.out.println(set);
  }

  static void eval(String s, int l, int h, Set<String> set) {
    while (l >= 0 && h < s.length() && s.charAt(l) == s.charAt(h)) {
      set.add(s.substring(l, h + 1));
      l--;
      h++;
    }
  }

  public static void main(String[] args) {
    palindromicsubstrings("refer");
    palindromicsubstrings("nitin");
    palindromicsubstrings("cdccbade");
  }
}
