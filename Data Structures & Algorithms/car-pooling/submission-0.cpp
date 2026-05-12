class Solution {
public:
    bool carPooling(vector<vector<int>>& trips, int capacity) {
        vector<int> stops(1001, 0);

        for (auto &trip : trips) {
            int passengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            stops[from] += passengers;
            stops[to] -= passengers;
        }

        int curr = 0;

        for (int i = 0; i <= 1000; i++) {
            curr += stops[i];

            if (curr > capacity)
                return false;
        }

        return true;
    }
};