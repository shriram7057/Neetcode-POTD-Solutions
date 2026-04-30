class Solution {
    public int kthSmallest(TreeNode root, int k) {
        java.util.Stack<TreeNode> stack = new java.util.Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // Go to leftmost node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            k--;

            if (k == 0) return curr.val;

            curr = curr.right;
        }

        return -1; // should never reach here
    }
}