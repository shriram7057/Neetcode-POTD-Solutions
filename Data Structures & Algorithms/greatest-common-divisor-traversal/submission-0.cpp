class Solution {
public:
    struct DSU {
        vector<int> parent, rank;

        DSU(int n) {
            parent.resize(n);
            rank.resize(n, 0);
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void unite(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py) return;

            if (rank[px] < rank[py])
                swap(px, py);

            parent[py] = px;

            if (rank[px] == rank[py])
                rank[px]++;
        }
    };

    bool canTraverseAllPairs(vector<int>& nums) {
        int n = nums.size();

        if (n == 1) return true;

        for (int x : nums) {
            if (x == 1)
                return false;
        }

        DSU dsu(n);
        unordered_map<int, int> primeIndex;

        for (int i = 0; i < n; i++) {
            int x = nums[i];

            for (int p = 2; p * p <= x; p++) {
                if (x % p == 0) {
                    if (primeIndex.count(p))
                        dsu.unite(i, primeIndex[p]);
                    else
                        primeIndex[p] = i;

                    while (x % p == 0)
                        x /= p;
                }
            }

            if (x > 1) {
                if (primeIndex.count(x))
                    dsu.unite(i, primeIndex[x]);
                else
                    primeIndex[x] = i;
            }
        }

        int root = dsu.find(0);

        for (int i = 1; i < n; i++) {
            if (dsu.find(i) != root)
                return false;
        }

        return true;
    }
};