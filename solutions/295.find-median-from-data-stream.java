class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> lower = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> upper = new PriorityQueue<>();
    
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        // add to either queue depending on if it's belonging to the lower or upper half
        if (lower.isEmpty() && upper.isEmpty()) {
            lower.add(num);
            return;
        }
        
        if (lower.peek() > num) {
            lower.add(num);
        } else {
            upper.add(num);
        }
        
        // If one of them is imbalanced, balance them
        if (upper.size() - lower.size() > 1) {
            lower.add(upper.poll());
        } else if (lower.size() - upper.size() > 1) {
            upper.add(lower.poll());
        }
    }
    
    public double findMedian() {
        if (lower.size() == upper.size()) {
            return (lower.peek() + upper.peek()) / 2.0;
        }
        
        return upper.size() > lower.size() ? upper.peek() : lower.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

// 