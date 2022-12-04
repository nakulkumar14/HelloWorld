package com.company.strings;

import java.util.Arrays;

// https://www.geeksforgeeks.org/remove-consecutive-duplicates-string/
public class RemoveConsecutiveChars {
  public static void main(String[] args) {
    System.out.println(removeConsecutive("geeksforgeeks"));
    System.out.println(removeConsecutive("aabcca"));
    System.out.println(removeConsecutive("azxxxzy"));
  }

  private static String removeConsecutive(String str) {
    if (str.length() < 2) {
      return str;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < str.length(); i++) {
      if (str.charAt(i)!=str.charAt(i-1)) {
        sb.append(str.charAt(i-1));
      }
    }

    if (str.charAt(str.length()-1) !=sb.charAt(sb.length()-1)){
      sb.append(str.charAt(str.length()-1));
    }

    char[] c = str.toCharArray();
    int j = 0;
    for (int i = 1; i < c.length; i++) {
      if (c[j]!=c[i]){
        c[++j] = c[i];
      }
    }

    String s = String.copyValueOf(c, 0, j+1);
    System.out.println(Arrays.copyOfRange(c, 0, j+1));
    System.out.println("Result: " + s);

    return sb.toString();
  }
}
