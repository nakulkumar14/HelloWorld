package com.company;

import java.util.ArrayList;
import java.util.List;

public class Test2 {

  void show(){
    final List<String> list = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      list.add("i"+i);
    }
    System.out.println(list);
  }


  public static void main(String[] args) {
//    Test2 test2 = new Test2();
//    test2.show();

//    String s = "hello";
//    char[] chars = s.toCharArray();
//    String s1 = String.valueOf(chars);
//    System.out.println(s1);
//
//    s.compareTo(s1);

    System.out.println(minimumSwap("xx", "xy"));
  }

  static int minimumSwap(String s1, String s2) {
    int n = s1.length();

    int x = 0, y = 0;

    for (int i = 0; i < n; ++i)
      if (s1.charAt(i) != s2.charAt(i)) {
        if (s1.charAt(i) == 'x')
          ++x;
        else
          ++y;
      }

    int cnt = x + y;

    if (cnt % 2 == 1) return -1;

    return cnt / 2 + x % 2;
  }
}
