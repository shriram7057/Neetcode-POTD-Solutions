class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = intervals.length;
        int m = queries.length;

        java.util.Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[][] q = new int[m][2];
        for (int i = 0; i < m; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }

        java.util.Arrays.sort(q, (a, b) -> a[0] - b[0]);

        int[] res = new int[m];
        java.util.Arrays.fill(res, -1);

        java.util.PriorityQueue<int[]> pq = new java.util.PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        ); // [length, right]

        int i = 0;

        for (int[] query : q) {
            int val = query[0];
            int idx = query[1];

            while (i < n && intervals[i][0] <= val) {
                int l = intervals[i][0];
                int r = intervals[i][1];
                int len = r - l + 1;
                pq.offer(new int[]{len, r});
                i++;
            }

            while (!pq.isEmpty() && pq.peek()[1] < val) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                res[idx] = pq.peek()[0];
            }
        }

        return res;
    }
}