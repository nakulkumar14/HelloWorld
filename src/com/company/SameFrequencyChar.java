package com.company;

import java.util.HashMap;
import java.util.Map;

// https://www.geeksforgeeks.org/check-if-a-string-has-all-characters-with-same-frequency-with-one-variation-allowed/
public class SameFrequencyChar {

  static boolean sameFrequency(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    }

    int counts[][] = new int[2][2];
    for (Integer value : map.values()) {
      if (counts[0][0] == 0 || counts[0][0] == value) {
        counts[0][0] = value;
        counts[0][1]++;
      } else if (counts[1][0] == 0 || counts[1][0] == value){
        counts[1][0] = value;
        counts[1][1]++;
      } else
        return false;
    }

    if (counts[0][1] > 1 && counts[1][1] > 1)
      return false;

    return true;
  }

  public static void main(String[] args) {
    System.out.println(sameFrequency("abbca"));
    System.out.println(sameFrequency("aabbcd"));
    System.out.println(sameFrequency("abbca"));
    System.out.println(sameFrequency("abbccd"));
  }
}
