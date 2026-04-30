class Solution {
    public boolean canAttendMeetings(java.util.List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) return true;

        intervals.sort((a, b) -> a.start - b.start);

        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start < intervals.get(i - 1).end) {
                return false; // overlap
            }
        }

        return true;
    }
}