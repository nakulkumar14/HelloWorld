package com.company;

// Java program for the above approach

import java.util.*;

// Structure of a Node
// in the Linked List
class Node {

    int val;
    Node next;

    // Constructor
    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

class MergeTransactions {

    // Function to merge the Bank sheets
    public static void mergeSheets(
            Node lists[]) {
        // Initialize Max_Heap
        PriorityQueue<Node> pq = new PriorityQueue<>(
                new Comparator<Node>() {

                    // Comparator Function
                    // to make it maxHeap
                    public int compare(Node a, Node b) {
                        return b.val - a.val;
                    }

                });

        // Stores the output list
        Node p, head = new Node(0);
        p = head;

        // Insert the first element
        // of each list
        for (int i = 0; i < lists.length; i++) {

            // If the list is not NULL
            if (lists[i] != null) {

                // Insert element in
                // the priority queue
                pq.add(lists[i]);
            }
        }

        // Iterate until PQ is non-empty
        while (!pq.isEmpty()) {
            p.next = pq.poll();
            p = p.next;

            if (p.next != null)
                pq.add(p.next);
        }

        p = head.next;

        // Print the output list
        while (p.next != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }

        System.out.print(p.val);
    }

    // Driver Code
    public static void main(String[] args) {
        int N = 2;

        Node arr[] = new Node[N];

        arr[0] = new Node(100);
        arr[0].next = new Node(400);
        arr[0].next.next = new Node(-1000);
        arr[0].next.next.next = new Node(-500);

        arr[1] = new Node(-300);
        arr[1].next = new Node(2000);
        arr[1].next.next = new Node(-500);

        // Function Call
        mergeSheets(arr);
    }
}


