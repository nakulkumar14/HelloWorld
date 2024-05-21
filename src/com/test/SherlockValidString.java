package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
public class SherlockValidString {

  public static String isValid(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    }

    Map<Integer, Integer> fmap = new HashMap<>();
    for (int count : map.values()) {
      fmap.put(count, fmap.getOrDefault(count, 0) + 1);
    }

    if (fmap.size() == 1) {
      return "YES";
    }

    if (fmap.size() == 2) {
      int[] frequencies = fmap.keySet().stream().mapToInt(Integer::intValue).toArray();
      int frequency1 = frequencies[0];
      int frequency2 = frequencies[1];

      if ((fmap.get(frequency1) == 1 && (frequency1 == 1 || Math.abs(frequency1 - frequency2) == 1))
          || (fmap.get(frequency2) == 1 && (frequency2 == 1 || Math.abs(frequency1 - frequency2) == 1))) {
        return "YES";
      }


    }

    return "NO";
  }

  public static void main(String[] args) {
    List<Integer> a = new ArrayList<>();
    int[] array = a.stream().mapToInt(Integer::intValue).toArray();
    System.out.println(isValid("abcdefghhgfedecba"));
  }
}
