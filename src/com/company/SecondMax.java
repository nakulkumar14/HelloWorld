package com.company;

public class SecondMax {

  static String secondMax(String a[]) {

    if (a == null || a.length <=1) {
      return "-1";
    }

    if(a.length == 2) {
      int i = compareTo(a[0], a[1]);
      if (i == 0) {
        return "-1";
      } else {
        return i < 0 ? a[0] : a[1];
      }
    }

    int i = compareTo(a[0], a[1]);
    String fmax = "";
    String smax = "";
    if (i >= 0) {
      fmax = a[0];
      if (i > 0) {
        smax = a[1];
      }
    } else {
      fmax = a[1];
      smax = a[0];
    }

    for (int j = 2; j < a.length-1; j++) {
      if (compareTo(fmax,a[j]) < 0 ) {
        smax = fmax;
        fmax = a[j];
      } else if (!a[j].equals(fmax) && compareTo(smax, a[j]) < 0){
        smax = a[j];
      }
    }

    return smax.length() > 0 ? smax : "-1";

//    BigInteger max=BigInteger.valueOf(Integer.MIN_VALUE);
//    BigInteger secmax = max;
//    for (int i = 0; i < a.length; i++) {
//      BigInteger num = new BigInteger(a[i]);
//      if (max.compareTo(num) < 0) {
//        secmax = max;
//        max = num;
//      } else if (max.compareTo(num)!=0 && secmax.compareTo(num) < 0){
//        secmax = num;
//      }
//    }
//    return secmax.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) == 0 ? "-1" : secmax.toString();
  }

  public static int compareTo(String x, String y) {
    if(x.length() > y.length()) {
      int diff = x.length() - y.length();
      y = "0".repeat(diff) + y;
    } else if (y.length() > x.length()) {
      int diff = y.length() - x.length();
      x = "0".repeat(diff) + x;
    }

    for (int i = 0; i < x.length(); i++) {
      if (x.charAt(i) < y.charAt(i)) {
        return -1;
      }
      if (x.charAt(i) > y.charAt(i)) {
        return 1;
      }
    }

    return 0;
  }

  public static void main(String[] args) {
    System.out.println(secondMax(new String[]{"3","-2"}));
    System.out.println(secondMax(new String[]{"5","5","4","2"}));
    System.out.println(secondMax(new String[]{"4","4","4"}));
    System.out.println(secondMax(new String[]{"1"}));
    System.out.println(secondMax(new String[]{"1","2"}));
    System.out.println(secondMax(new String[]{"-214748364801", "214748364802"}));
  }
}
