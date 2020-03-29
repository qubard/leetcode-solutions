class MedianFinder {
public:
    /** initialize your data structure here. */
    priority_queue<int, vector<int>, greater<int>> min;
    priority_queue<int, vector<int>, less<int>> max;

    MedianFinder() {
        
    }
    
    // If the heaps become imbalanced
    // take the top element of the max heap
    // and add it to min heap
    void addNum(int num) {
        max.push(num);
        
        min.push(max.top());
        max.pop();
        
        if (max.size() < min.size()) {
            max.push(min.top());
            min.pop();
        }
    }
    
    double findMedian() {
        if (max.size() > min.size()) {
            return (double)max.top();
        }
        return ((double)max.top() + (double)min.top()) / 2.0;
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */