package com.company.array;

import java.util.Arrays;

public class GenerateSubarray {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <=j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }

        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                System.out.print(arr[j] + " ");

            }
            System.out.println();
        }
    }
}
