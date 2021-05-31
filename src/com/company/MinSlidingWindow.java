package com.company;

import java.util.*;

public class MinSlidingWindow {
    public int[] printFirstNegativeInteger(int A[], int N, int K) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < K; i++) {
            if (A[i] < 0)
                dq.add(i);
        }

        System.out.println("Deque : " + dq);

        for (int i = K; i < N; i++) {

            if (!dq.isEmpty())
                list.add(A[dq.peekFirst()]);
            else
                list.add(0);

            // remove out of bound indexes
            while (!dq.isEmpty() && dq.peekFirst() <= i - K)
                dq.pollFirst();

            if (A[i] < 0)
                dq.add(i);

        }

        while(list.size() < N - K + 1) {
            list.add(0);
        }

        int[] o = new int[list.size()];
        for (int i = 0; i < o.length; i++) {
            o[i] = list.get(i);
        }
        return o;
    }

    public static void main(String[] args) {
        MinSlidingWindow obj = new MinSlidingWindow();
//        int A[] = {-8, 2, 3, -6, 10};
//        int A[] = {12,-1,-7,8,-15,30,16,28};
        int A[] = {48,974,5,-59,-451};
        System.out.println(Arrays.toString(obj.printFirstNegativeInteger(A, A.length, 3)));
    }
}
