package com.company.topological;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSortDFS {

    public void sort(List<List<Integer>> adj) {
        Stack<Integer> s = new Stack<>();
        boolean visited[] = new boolean[adj.size()];

        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i])
                sortUtil(i, adj, visited, s);
        }

        while (!s.empty()) {
            System.out.print(s.pop() + " ");
        }
        System.out.println();
    }

    private void sortUtil(int i, List<List<Integer>> adj, boolean[] visited, Stack<Integer> s) {
        visited[i] = true;

        for(int u : adj.get(i)) {
            if (!visited[u]) {
                sortUtil(u, adj, visited, s);
            }
        }

        s.add(i);
    }

    public static void main(String[] args) {

        TopologicalSortDFS sortDFS = new TopologicalSortDFS();

        List<List<Integer>> adj= new ArrayList<>();
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>());
        adj.add(List.of(3));
        adj.add(List.of(1));
        adj.add(List.of(0,1));
        adj.add(List.of(0,2));
        sortDFS.sort(adj);

        adj= new ArrayList<>();
        adj.add(new ArrayList<>());
        adj.add(List.of(0));
        adj.add(List.of(1));
        adj.add(List.of(1));
        adj.add(new ArrayList<>());
        adj.add(List.of(4,2));
        adj.add(List.of(4,3));
        adj.add(List.of(5));
        sortDFS.sort(adj);

        adj= new ArrayList<>();
        adj.add(List.of(1,2));
        adj.add(List.of(3));
        adj.add(List.of(1,3));
        adj.add(new ArrayList<>());
        sortDFS.sort(adj);
    }
}
