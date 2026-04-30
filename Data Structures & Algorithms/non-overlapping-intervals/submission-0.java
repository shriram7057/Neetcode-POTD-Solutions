class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) return 0;

        java.util.Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                count++; // overlap → remove this interval
            } else {
                end = intervals[i][1]; // no overlap → update end
            }
        }

        return count;
    }
}