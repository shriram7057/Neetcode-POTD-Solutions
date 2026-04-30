class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        java.util.List<java.util.List<Integer>> graph = new java.util.ArrayList<>();
        int[] indegree = new int[numCourses];

        // Initialize graph
        for (int i = 0; i < numCourses; i++) {
            graph.add(new java.util.ArrayList<>());
        }

        // Build graph
        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        // Queue for nodes with no prerequisites
        java.util.Queue<Integer> queue = new java.util.LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;

        // Topological sort (Kahn's algorithm)
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;

            for (int next : graph.get(course)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return count == numCourses;
    }
}