class Solution {
public:
    int maxTurbulenceSize(vector<int>& arr) {
        int n = arr.size();
        if (n == 1) return 1;

        int ans = 1, left = 0;

        for (int right = 1; right < n; right++) {
            int c = (arr[right - 1] > arr[right]) ? 1 :
                    (arr[right - 1] < arr[right]) ? -1 : 0;

            if (c == 0) {
                left = right;
            } else if (right == n - 1 || 
                      c * ((arr[right] > arr[right + 1]) ? 1 :
                           (arr[right] < arr[right + 1]) ? -1 : 0) != -1) {
                ans = max(ans, right - left + 1);
                left = right;
            }
        }

        return ans;
    }
};