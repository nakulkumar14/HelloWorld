package com.company.topological;

import java.util.*;

public class TopologicalSort {

    public void sort(List<List<Integer>> adj) {
        int size = adj.size();
        int inorder[] = new int[size];
        int i = 0;
        for(List<Integer> node : adj) {
            node.forEach(v -> inorder[v]++);
        }

        System.out.println(Arrays.toString(inorder));

        Queue<Integer> q = new LinkedList<>();
        for (int j = 0; j < size; j++) {
            if (inorder[j] == 0) {
                q.add(j);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            Integer v = q.poll();
            result.add(v);

            for(int node : adj.get(v)) {
                inorder[node]--;
                if (inorder[node] == 0){
                    q.add(node);
                }
            }
        }

        for (int j = 0; j < size; j++) {
            if (inorder[j] != 0){
                System.out.println("Cyclic graph");
            }
        }

        System.out.println(result);
    }

    public static void main(String[] args) {

        TopologicalSort sort = new TopologicalSort();

        List<List<Integer>> adj= new ArrayList<>();
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>());
        adj.add(List.of(3));
        adj.add(List.of(1));
        adj.add(List.of(0,1));
        adj.add(List.of(0,2));
        sort.sort(adj);

        adj= new ArrayList<>();
        adj.add(new ArrayList<>());
        adj.add(List.of(0));
        adj.add(List.of(1));
        adj.add(List.of(1));
        adj.add(new ArrayList<>());
        adj.add(List.of(4,2));
        adj.add(List.of(4,3));
        adj.add(List.of(5));
        sort.sort(adj);
    }
}
