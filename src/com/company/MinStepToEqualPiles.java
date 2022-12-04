package com.company;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

// https://leetcode.com/discuss/interview-question/364618/
public class MinStepToEqualPiles {
  public static void main(String[] args) {
//    int piles[] = {5, 1, 2};
//    int piles[] = {10,10};
//    int piles[] = {10};
//    int piles[] = {4,2,1};
//    int piles[] = {4, 5, 5, 4, 2};
//    int piles[] = {4, 8, 8};
//    int piles[] = {4,4, 8, 8};
    int piles[] = {1, 1, 2, 2, 2, 3, 3, 3, 4, 4}; // wrong
//    int piles[] = {1, 2, 2, 3, 3, 4}; // wrong
//    int piles[] = {4, 8, 16, 32}; // wrong

    int steps = 0;
    int min = Integer.MAX_VALUE;
    Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
    for (int i = 0; i < piles.length; i++) {
      map.put(piles[i], map.getOrDefault(piles[i], 0) + 1);
      min = Math.min(min, piles[i]);
    }

    System.out.println(map);
    System.out.println(min);

    int prev = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (min == entry.getKey())
        break;
      steps += entry.getValue() + prev;
//      System.out.println(prev + ", " + entry.getValue() + ", " + steps);
      prev += entry.getValue();
    }

    System.out.println(steps);
  }
}
