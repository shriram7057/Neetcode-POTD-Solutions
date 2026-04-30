class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        java.util.Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        java.util.List<int[]> result = new java.util.ArrayList<>();
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= current[1]) {
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                result.add(current);
                current = intervals[i];
            }
        }

        result.add(current);

        return result.toArray(new int[result.size()][]);
    }
}