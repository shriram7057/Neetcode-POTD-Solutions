class Solution {
    public String foreignDictionary(String[] words) {
        // Step 1: Initialize graph
        java.util.Map<Character, java.util.Set<Character>> graph = new java.util.HashMap<>();
        java.util.Map<Character, Integer> indegree = new java.util.HashMap<>();

        // Add all unique characters
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new java.util.HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        // Step 2: Build graph using adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            // Invalid case: prefix issue
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }

            int len = Math.min(w1.length(), w2.length());
            for (int j = 0; j < len; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);

                if (c1 != c2) {
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        indegree.put(c2, indegree.get(c2) + 1);
                    }
                    break;
                }
            }
        }

        // Step 3: Topological Sort (Kahn's Algorithm)
        java.util.Queue<Character> queue = new java.util.LinkedList<>();
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {
            char curr = queue.poll();
            result.append(curr);

            for (char nei : graph.get(curr)) {
                indegree.put(nei, indegree.get(nei) - 1);
                if (indegree.get(nei) == 0) {
                    queue.offer(nei);
                }
            }
        }

        // If not all characters are used → cycle exists
        if (result.length() != indegree.size()) {
            return "";
        }

        return result.toString();
    }
}