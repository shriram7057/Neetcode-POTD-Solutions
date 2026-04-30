class MedianFinder {

    private java.util.PriorityQueue<Integer> maxHeap; // left half (max heap)
    private java.util.PriorityQueue<Integer> minHeap; // right half (min heap)

    public MedianFinder() {
        maxHeap = new java.util.PriorityQueue<>((a, b) -> b - a);
        minHeap = new java.util.PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // Step 1: add to maxHeap
        maxHeap.offer(num);
        
        // Step 2: balance - move largest of left to right
        minHeap.offer(maxHeap.poll());
        
        // Step 3: ensure size property (left >= right)
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}