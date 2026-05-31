package com.dsa.patterns.graphs;

public class NumberOfConnectedComponents {

    private int[] parent, rank;

    public static void main(String[] args) {
        NumberOfConnectedComponents numberOfConnectedComponents = new NumberOfConnectedComponents();
        int n = 5;
        int[][] edges = {
                {0, 1},
                {1, 2},
                {3, 4}
        };
        System.out.println(numberOfConnectedComponents.countComponents(n, edges));
    }

    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) parent[i] = i;

        int components = n;

        for (int[] edge : edges) {
            if (union(edge[0], edge[1])) {
                components--;
            }
        }
        return components;
    }

    private int find(int x) {
        if (parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return false;

        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
        } else {
            parent[py] = px;
            rank[px]++;
        }
        return true;
    }
}
