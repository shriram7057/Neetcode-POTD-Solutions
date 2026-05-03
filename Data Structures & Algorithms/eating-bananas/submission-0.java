class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        
        for (int p : piles) {
            right = Math.max(right, p);
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            long hours = 0;
            for (int p : piles) {
                hours += (p + mid - 1) / mid;
            }
            
            if (hours > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}