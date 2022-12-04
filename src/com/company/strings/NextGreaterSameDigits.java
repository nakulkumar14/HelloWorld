package com.company.strings;

import java.util.Arrays;

public class NextGreaterSameDigits {

  static String nextNumber(String n) {
    int i;
    for (i = n.length() - 1; i >= 0; i--) {
      if (i-1 >=0 && n.charAt(i-1) < n.charAt(i)) {
        break;
      }
    }

    if (i<=0) {
      return "Not possible";
    }

//    System.out.println(i);

    StringBuilder sb = new StringBuilder();
    sb.append(n.substring(0,i-1));
    char[] chars = n.substring(i).toCharArray();
    Arrays.sort(chars);
//    System.out.println(Arrays.toString(chars));
    int min = 0;
//    for (int j = 0; j < chars.length; j++) {
//      if (chars[min] > chars[j]) {
//        min = j;
//      }
//    }

//    System.out.println(min);

    char c = chars[min];
    chars[min] = n.charAt(i-1);


//    System.out.println(Arrays.toString(chars));

    sb.append(c);
    sb.append(chars);

    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(nextNumber("218765"));
    System.out.println(nextNumber("4321"));
    System.out.println(nextNumber("1234"));
    System.out.println(nextNumber("534976"));
    System.out.println(nextNumber("badc"));
  }
}
