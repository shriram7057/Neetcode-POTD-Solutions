class Solution {
    private int preIndex = 0;
    private java.util.Map<Integer, Integer> inMap = new java.util.HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Build value -> index map for inorder
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int left, int right) {
        if (left > right) return null;

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        int mid = inMap.get(rootVal);

        root.left = helper(preorder, left, mid - 1);
        root.right = helper(preorder, mid + 1, right);

        return root;
    }
}