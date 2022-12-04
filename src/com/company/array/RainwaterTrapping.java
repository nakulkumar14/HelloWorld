package com.company.array;

public class RainwaterTrapping {
  static void trap(int a[]){
    int[] left = new int[a.length];
    int[] right = new int[a.length];

    left[0] = a[0];
    for (int i = 1; i < a.length; i++) {
      left[i] = Math.max(left[i-1],a[i]);
    }

    right[right.length-1] = a[a.length-1];
    for (int i = right.length-2; i >=0 ; i--) {
      right[i] = Math.max(right[i+1],a[i]);
    }

    int sum = 0;
    for (int i = 0; i < a.length; i++) {
      int currTrap = Math.min(left[i], right[i]) - a[i];
      if (currTrap > 0) {
        sum+=currTrap;
      }
    }
    System.out.println(sum);
  }
  public static void main(String[] args) {
    int a[]={3,0,2,0,4};
    trap(a);
    a= new int[]{2, 0, 2};
    trap(a);
    a= new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    trap(a);
  }
}
