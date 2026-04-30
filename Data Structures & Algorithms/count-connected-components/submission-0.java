class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];

        // Initialize
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int components = n;

        for (int[] edge : edges) {
            if (union(edge[0], edge[1], parent, rank)) {
                components--;
            }
        }

        return components;
    }

    private int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent); // path compression
        }
        return parent[x];
    }

    private boolean union(int a, int b, int[] parent, int[] rank) {
        int rootA = find(a, parent);
        int rootB = find(b, parent);

        if (rootA == rootB) return false;

        if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        } else if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
        } else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }

        return true;
    }
}