package com.company.strings;

public class StringRotations {

  static boolean areRotations(String a, String b) {
    if (a == null || b == null)
      return false;
    if (a.length() != b.length())
      return false;

    if ((a + a).indexOf(b) == -1) {
      return false;
    }

    return true;
  }

  static boolean areRotations2(String a, String b) {
    if (a == null || b == null)
      return false;
    if (a.length() != b.length())
      return false;

    for (int i = 0; i < a.length(); i++) {
      a = a.substring(1) + a.charAt(0);
      if (a.equals(b))
        return true;
    }

    return false;
  }

  public static void main(String[] args) {
    System.out.println(areRotations("abcd", "dabc"));
    System.out.println(areRotations2("abcd", "dabc"));
  }
}
