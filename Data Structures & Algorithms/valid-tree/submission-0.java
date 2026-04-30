class Solution {
    public boolean validTree(int n, int[][] edges) {
        // A valid tree must have exactly n - 1 edges
        if (edges.length != n - 1) return false;

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int[] edge : edges) {
            int rootA = find(edge[0], parent);
            int rootB = find(edge[1], parent);

            // If both nodes have same root → cycle
            if (rootA == rootB) return false;

            parent[rootA] = rootB; // union
        }

        return true;
    }

    private int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }
}