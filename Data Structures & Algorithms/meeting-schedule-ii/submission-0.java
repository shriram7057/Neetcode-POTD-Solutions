class Solution {
    public int minMeetingRooms(java.util.List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return 0;

        intervals.sort((a, b) -> a.start - b.start);

        java.util.PriorityQueue<Integer> minHeap = new java.util.PriorityQueue<>();

        for (Interval interval : intervals) {
            if (!minHeap.isEmpty() && interval.start >= minHeap.peek()) {
                minHeap.poll(); // reuse room
            }
            minHeap.offer(interval.end);
        }

        return minHeap.size();
    }
}