package com.company.strings;

import java.util.HashSet;
import java.util.Set;

public class PrintAllSubstrings {

  static int longestCommonSubstr(String S1, String S2, int n, int m){
    // code here
    Set<String> set1 = new HashSet<>();
    for(int i=0;i<S1.length();i++) {
      for (int j = i; j <= S1.length(); j++) {
        set1.add(S1.substring(i,j));
      }
    }

    Set<String> set2 = new HashSet<>();
    for(int i=0;i<S2.length();i++) {
      for (int j = i; j <= S2.length(); j++) {
        set2.add(S2.substring(i,j));
      }
    }

    System.out.println(set1);
    System.out.println(set2);

    set1.retainAll(set2);

    int res = 0;
    for(String s : set1) {
      if (res < s.length()) {
        res = s.length();
      }
    }

    return res;
  }
  static void printAllSubstrings(String s) {
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j <= s.length(); j++) {
        System.out.println(s.substring(i,j));
      }
    }
  }
  public static void main(String[] args) {
//    printAllSubstrings("hello");
    int i = longestCommonSubstr("ABCDGH", "ACDGHR", 6, 6);
    System.out.println(i);
  }
}
