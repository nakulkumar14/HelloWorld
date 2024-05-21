package com.test;

import java.util.Arrays;

public class MissingAndRepeated {
  int[] findTwoElement(int arr[], int n) {
    int a[] = new int[2];

//    int xor = 0;
//    for (int i = 1; i <= n; i++) {
//      xor = xor ^ i;
//    }
//
//    for (int i = 0; i < n; i++) {
//      xor = xor ^ arr[i];
//    }
//
//    int setbit = xor & ~(xor - 1);
//
//    int x = 0, y = 0;
//    for (int i = 0; i < n; i++) {
//      if ((arr[i] ^ setbit) != 0) {
//        x = x ^ arr[i];
//      } else {
//        y = y ^ arr[i];
//      }
//    }
//
//    for (int i = 1; i <= n; i++) {
//      if ((i ^ setbit) != 0) {
//        x = x ^ i;
//      } else {
//        y = y ^ i;
//      }
//    }
//
//    a[0] = x;
//    a[1] = y;

    /* Will hold xor of all elements
       and numbers from 1 to n  */
    int xor1;

    /* Will have only single set bit of xor1 */
    int set_bit_no;

    int i;
    int x = 0;
    int y = 0;

//    xor1 = arr[0];

    /* Get the xor of all array elements  */
//    for (i = 1; i < n; i++)
//      xor1 = xor1 ^ arr[i];

        /* XOR the previous result with numbers from
       1 to n*/
//    for (i = 1; i <= n; i++)
//      xor1 = xor1 ^ i;

    xor1 = 1;
    for (i = 2; i <= n; i++) {
      xor1 = xor1 ^ i;
    }

    for (i = 0; i < n; i++) {
      xor1 = xor1 ^ arr[i];
    }

    /* Get the rightmost set bit in set_bit_no */
    set_bit_no = xor1 & ~(xor1 - 1);

        /* Now divide elements into two sets by comparing
    rightmost set bit of xor1 with the bit at the same
    position in each element. Also, get XORs of two
    sets. The two XORs are the output elements. The
    following two for loops serve the purpose */
    for (i = 0; i < n; i++) {
      if ((arr[i] & set_bit_no) != 0)
        /* arr[i] belongs to first set */
        x = x ^ arr[i];

      else
        /* arr[i] belongs to second set*/
        y = y ^ arr[i];
    }
    for (i = 1; i <= n; i++) {
      if ((i & set_bit_no) != 0)
        /* i belongs to first set */
        x = x ^ i;

      else
        /* i belongs to second set*/
        y = y ^ i;
    }

    a[0] = x;
    a[1] = y;

    return a;
  }

  public static void main(String[] args) {
    MissingAndRepeated obj = new MissingAndRepeated();
    int a[] = {1, 3, 3};
    System.out.println(Arrays.toString(obj.findTwoElement(a, a.length)));
  }
}
