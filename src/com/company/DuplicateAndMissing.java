package com.company;

import java.util.Arrays;

public class DuplicateAndMissing {
    static int[] find1(int[] arr) {
        int xor1;
        int n = arr.length;

        /* Will have only single set bit of xor1 */
        int set_bit_no;

        int i;
        int x = 0;
        int y = 0;

        xor1 = arr[0];

        /* Get the xor of all array elements */
        for (i = 1; i < n; i++)
            xor1 = xor1 ^ arr[i];

        System.out.println("xor array " + xor1);

		/* XOR the previous result with numbers from
	1 to n*/
        for (i = 1; i <= n; i++)
            xor1 = xor1 ^ i;

        System.out.println("xor nos " + xor1);

        /* Get the rightmost set bit in set_bit_no */
        set_bit_no = xor1 & ~(xor1 - 1);

        System.out.println("set_bit_no " + set_bit_no);

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

        System.out.println("x and y arrs " + x + " " + y);

        for (i = 1; i <= n; i++) {
            if ((i & set_bit_no) != 0)
                /* i belongs to first set */
                x = x ^ i;

            else
                /* i belongs to second set*/
                y = y ^ i;
        }

        System.out.println("x and y nos " + x + " " + y);

        int c = 0;
        for(i=0;i<n;i++)
            if(x == arr[i])
                c++;

        return c == 2? new int[] {x,y}:new int[] {y,x};
    }

    static int[] find2(int[] nums) {
        int len = nums.length;
        int xor = 0;
        for(int i=0;i<len;i++) {
            xor = xor ^ nums[i];
        }

//        System.out.println("xor array " + xor);

        for(int i=1;i<=len;i++) {
            xor = xor^i;
        }

//        System.out.println("xor nos " + xor);

        int setbit = xor & ~(xor-1);

//        System.out.println("set_bit_no " + setbit);

        int x = 0;
        int y = 0;

        for(int i=0;i<len;i++) {
            if((setbit & nums[i]) != 0) {
                x = x^nums[i];
            } else {
                y = y^nums[i];
            }
        }

//        System.out.println("x and y arrs " + x + " " + y);

        for(int i=1;i<=len;i++) {
            if((setbit & i) != 0) {
                x = x^i;
            } else {
                y = y^i;
            }
        }

//        System.out.println("x and y nos " + x + " " + y);

        return new int[] {x, y};
    }
    public static void main(String[] args) {
        int arr[] = { 3,2,3,4,6,5};
        System.out.println(Arrays.toString(find1(arr)));
        System.out.println(Arrays.toString(find2(arr)));
    }
}
