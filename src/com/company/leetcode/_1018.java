package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

class _1018 {
  public List<Boolean> prefixesDivBy5(int[] nums) {
    List<Boolean> answer = new ArrayList<>();

    StringBuilder x = new StringBuilder();
    for(int i=0;i<nums.length;i++) {
      x.append(nums[i]);
      answer.add(check(x));
    }

    return answer;
  }

  boolean check(StringBuilder x) {
//    x.reverse();

    System.out.println(x);
    long num = 0;
    for(int i=0;i<x.length();i++){
      double v = (x.charAt(i) - '0') * Math.pow(2, i);
      if (v!=0) {
        int i1 = new StringBuilder(v + "").charAt(0) - '0';
        num += i1;
        num %= 10;
      }
    }
//    x.reverse();
    System.out.println(num);
    return num%5==0;
  }

  // 110001 -> 100011
  public static void main(String[] args) {
//    int[] arr = {1,0,1,0,0,0,0,0,0,0,0,1,1,1,0,0,1,0,1,1,1,1,1,1,0,0,0,1,0,1,1,1,1,0,1,1,0,1,0,1,0,0,0,1,0,0,0,0,0,1,0,0,1,1,0,0,1,1,1};
    int[] arr = {1,1,0,0,0,1,0,0,1};
    _1018 o = new _1018();
    System.out.println(o.prefixesDivBy5(arr));
  }
}
