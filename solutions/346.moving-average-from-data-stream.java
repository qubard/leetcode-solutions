class MovingAverage {

    /** Initialize your data structure here. */
    int[] window;
    int index;
    int sum;
    int start;
    int size;
    int n;
    public MovingAverage(int size) {
        window = new int[size];
        this.size = size;
        n = 0;
        index = 0;
        start = 0;
        sum = 0;
    }
    
    public double next(int val) {
        if (n < size) {
            sum += val;
            window[index] = val;
            index = (index + 1) % size;
            n++;
        } else {
            // take off first val of window
            sum -= window[start];
            window[start] = val;
            sum += val;
            start = (start + 1) % size;
        }
        return (double) sum / (double) n;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */