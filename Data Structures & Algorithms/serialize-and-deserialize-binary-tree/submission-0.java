public class Codec {

    // Encodes a tree to a single string (Preorder DFS)
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }
        sb.append(node.val).append(",");
        buildString(node.left, sb);
        buildString(node.right, sb);
    }

    // Decodes your encoded data to tree
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        java.util.Queue<String> queue = new java.util.LinkedList<>();
        for (String s : arr) {
            queue.offer(s);
        }
        return buildTree(queue);
    }

    private TreeNode buildTree(java.util.Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("null")) return null;

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = buildTree(queue);
        node.right = buildTree(queue);
        return node;
    }
}