class Solution {
    public java.util.List<java.util.List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // DFS from borders
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0, Integer.MIN_VALUE);       // left
            dfs(heights, atlantic, i, n - 1, Integer.MIN_VALUE);  // right
        }

        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j, Integer.MIN_VALUE);       // top
            dfs(heights, atlantic, m - 1, j, Integer.MIN_VALUE);  // bottom
        }

        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(java.util.Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, int r, int c, int prevHeight) {
        int m = heights.length, n = heights[0].length;

        if (r < 0 || c < 0 || r >= m || c >= n
                || visited[r][c]
                || heights[r][c] < prevHeight) {
            return;
        }

        visited[r][c] = true;

        dfs(heights, visited, r + 1, c, heights[r][c]);
        dfs(heights, visited, r - 1, c, heights[r][c]);
        dfs(heights, visited, r, c + 1, heights[r][c]);
        dfs(heights, visited, r, c - 1, heights[r][c]);
    }
}