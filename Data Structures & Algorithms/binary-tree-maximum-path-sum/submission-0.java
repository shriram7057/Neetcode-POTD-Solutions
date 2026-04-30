class Solution {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        // Path passing through this node
        int currentPath = node.val + left + right;
        maxSum = Math.max(maxSum, currentPath);

        // Return max path going down
        return node.val + Math.max(left, right);
    }
}