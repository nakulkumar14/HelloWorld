package com.company.strings;

public class MinimumNoOfAppends {

  boolean isPalindrome(String str)
  {
    int l = 0;
    int r = str.length()-1;

    while (l < r) {
      if (str.charAt(l)!=str.charAt(r))
        return false;
      l++;
      r--;
    }

    return true;
  }

  int minAppends(String s) {
    if (isPalindrome(s)) {
      return 0;
    }

    s=s.substring(1);
    return 1+minAppends(s);
  }
  public static void main(String[] args) {
    MinimumNoOfAppends o = new MinimumNoOfAppends();
    System.out.println(o.minAppends("abede"));
  }
}
