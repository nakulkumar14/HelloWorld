package com.company.array;

class SubsetXOR {
    public static void main(String[] args) {
        int arr[] = {5,1,6};
        System.out.println("result : " + subsetXORSum(arr));
    }
    public static int subsetXORSum(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int xor = 0;
                System.out.println("subarray :  " + i + " " + j);
                for (int k = i; k <= j; k++) {
                    xor = xor ^ nums[k];
                }
                System.out.println(xor);
                res += xor;
            }
            // System.out.println();
        }

        return res;
    }
}