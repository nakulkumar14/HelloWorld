package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        int arr[] = {2,3,6,4,1,0};
        System.out.println(Arrays.toString(arr));
        int[] ints = Arrays.stream(arr).boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println(Arrays.toString(ints));

    }
}
