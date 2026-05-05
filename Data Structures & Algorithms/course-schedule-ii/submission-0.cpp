class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        vector<vector<int>> graph(numCourses);
        vector<int> indegree(numCourses, 0);

        for (auto& p : prerequisites) {
            graph[p[1]].push_back(p[0]);
            indegree[p[0]]++;
        }

        queue<int> q;
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.push(i);
            }
        }

        vector<int> result;

        while (!q.empty()) {
            int node = q.front();
            q.pop();
            result.push_back(node);

            for (int nei : graph[node]) {
                if (--indegree[nei] == 0) {
                    q.push(nei);
                }
            }
        }

        if (result.size() == numCourses) return result;
        return {};
    }
};