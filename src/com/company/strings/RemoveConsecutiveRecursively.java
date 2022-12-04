package com.company.strings;

// https://www.geeksforgeeks.org/recursively-remove-adjacent-duplicates-given-string/
public class RemoveConsecutiveRecursively {
  public static void main(String[] args) {
    System.out.println("Result : " + remove("azxxzy"));
    System.out.println("Result : " + remove("azxxxzy"));

    System.out.println("Result : " + remove("aabbaa"));

    System.out.println("Result : " + remove("abba"));
    System.out.println("Result : " + remove("abcdeedcba"));
    System.out.println("Result : " + remove("aadaa"));
    System.out.println("Result : " + remove("abccbccba"));
  }

  private static String remove(String s) {
    if (s == null)
      return " ";
    if (s.length() < 2) {
      return s;
    }

    char first = s.charAt(0);
    String str = remove(s.substring(1));
    if (str.length()==0) {
      return String.valueOf(first);
    }
    if (first == str.charAt(0)) {
      return str.substring(1);
    } else {
      return first + str;
    }
  }
}
