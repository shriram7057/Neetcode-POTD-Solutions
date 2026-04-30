class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        java.util.Map<Node, Node> map = new java.util.HashMap<>();
        return dfs(node, map);
    }

    private Node dfs(Node node, java.util.Map<Node, Node> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node copy = new Node(node.val);
        map.put(node, copy);

        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(dfs(neighbor, map));
        }

        return copy;
    }
}