class Solution {
public:
    bool backtrack(vector<int>& nums, vector<int>& subsets,
                   int index, int target) {

        if (index == nums.size()) {
            return true;
        }

        for (int i = 0; i < subsets.size(); i++) {
            if (subsets[i] + nums[index] > target)
                continue;

            subsets[i] += nums[index];

            if (backtrack(nums, subsets, index + 1, target))
                return true;

            subsets[i] -= nums[index];

            if (subsets[i] == 0)
                break;
        }

        return false;
    }

    bool canPartitionKSubsets(vector<int>& nums, int k) {
        int sum = 0;

        for (int num : nums)
            sum += num;

        if (sum % k != 0)
            return false;

        int target = sum / k;

        sort(nums.rbegin(), nums.rend());

        if (nums[0] > target)
            return false;

        vector<int> subsets(k, 0);

        return backtrack(nums, subsets, 0, target);
    }
};