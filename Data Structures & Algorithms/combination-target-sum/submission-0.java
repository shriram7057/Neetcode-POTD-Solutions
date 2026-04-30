class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int target, int start,
                           List<Integer> current, List<List<Integer>> result) {
        
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) return;

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            // allow reuse of same element → i (not i+1)
            backtrack(nums, target - nums[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }
}