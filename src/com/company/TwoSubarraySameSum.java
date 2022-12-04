package com.company;

import java.util.HashMap;
import java.util.Map;

public class TwoSubarraySameSum {

  public int minSumOfLengths(int[] arr, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    int sum = 0;
    for(int i = 0; i < arr.length; i++) {
      sum += arr[i];
      map.put(sum, i);
    }
    System.out.println("Map : " + map);
    int ans = Integer.MAX_VALUE;
    sum = 0;

    int leftBest = Integer.MAX_VALUE;
    for(int i = 0; i < arr.length; i++) {
      sum += arr[i];
      if(map.containsKey(sum - target)) {
        leftBest = Math.min(leftBest, i - map.get(sum - target));
      }
      if(leftBest < Integer.MAX_VALUE && map.containsKey(sum + target)) {
        ans = Math.min(ans, leftBest + map.get(sum + target) - i);
      }
    }
    return ans < Integer.MAX_VALUE ? ans : -1;
  }

  public int minSumOfLengths2(int[] arr, int target) {
    int sum = 0;
    int ans = Integer.MAX_VALUE;
    int l1 = Integer.MAX_VALUE;
    int l2 = Integer.MAX_VALUE;
    int s1 = 0;
    int s2 = 0;
    for (int i = 0; i < arr.length; i++) {
      while (i< arr.length && sum < target) {
        sum+=arr[i];
        i++;
      }
      if (sum == target) {
        l1 = Math.min(i - s1, l1);
        s1 = i;
      }
      
      int j = i;
      s2 = i;
      sum = 0;
      while (j< arr.length && sum < target) {
        sum+=arr[j];
        j++;
      }
      if (sum == target) {
        s2 = j;
        l2 = Math.min(s2 - j, l2);
      }
      
    }

    return l1 + l2;
  }

    // two non overlapping subarray with same sum
  public static void main(String[] args) {
    TwoSubarraySameSum o = new TwoSubarraySameSum();
    int a[] = {3,1,1,1,5,1,2,1};
    int target = 3;
    int minSumOfLengths = o.minSumOfLengths(a, target);
    System.out.println(minSumOfLengths);
    System.out.println(o.minSumOfLengths2(a, target));
  }
}
