package com.company.strings;

import java.util.*;

public class FrequentWords {
  public static List<String> topKFrequent(String[] words, int k) {
    List<String> list = new ArrayList<>();

    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }

    PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
      @Override
      public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        if (o1.getValue() != o2.getValue()) {
          return o2.getValue() - o1.getValue();
        } else {
          return o1.getKey().compareTo(o2.getKey());
        }
      }
    });

    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      pq.offer(entry);
    }

    while(pq.size() > 0 && k > 0) {
      String key = pq.poll().getKey();
      list.add(key);
      k--;
    }

    return list;
  }

  public static void main(String[] args) {
    String words[] = {"i", "love", "leetcode", "i", "love", "coding"};
    System.out.println(topKFrequent(words, 2));
  }
}
