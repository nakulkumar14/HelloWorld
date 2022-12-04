package com.company.strings;

import java.util.Arrays;

public class LexicographicalSorting {
  public static void main(String[] args) {
    String s = "lexicographic sorting of a set of keys can be accomplished with " +
        "a simple trie based algorithm we insert all keys in a trie output " +
        "all keys in the trie by means of preorder traversal which results " +
        "in output that is in lexicographically increasing order preorder " +
        "traversal is a kind of depth first traversal";
    String[] strings = s.split(" ");
    for(String str : strings)
      System.out.println(str);

    Arrays.sort(strings);
    System.out.println("After sorting..");

    for(String str : strings)
      System.out.println(str);
  }
}
