package com.company.strings;

import java.util.ArrayList;
import java.util.List;

public class PalindromicPermutations {

  static List<String> generate(String s) {
    int c[] = new int[26];
    for (int i = 0; i < s.length(); i++) {
      c[s.charAt(i) - 'a']++;
    }

    List<String> result = new ArrayList<>();

    int oddIndex = 0;
    boolean odd = false;
    for (int i = 0; i < 26; i++) {
      if (c[i] % 2 == 1) {
        if (odd) {
          return result;
        }
        odd = true;
        oddIndex = i;
      }
    }

    String base = "";
    if (odd) {
      base = base + (char) (oddIndex + 'a');
      c[oddIndex] = 0;
    }
    collect(base, result, c, s.length());

    return result;
  }

  private static void collect(String base, List<String> result, int[] c, int n) {
    if (base.length() == n) {
      result.add(base);
      return;
    }
    for (int i = 0; i < c.length; i++) {
      if (c[i] > 0) {
        c[i] -= 2;
        char ch = (char) (i + 'a');
        collect(ch + base + ch, result, c, n);
        c[i] += 2;
      }
    }
  }


  public static void main(String[] args) {
    System.out.println(PalindromicPermutations.generate("nitin"));
    System.out.println(PalindromicPermutations.generate("aabb"));
  }
}
