class MaxStack {

    /** initialize your data structure here. */
    ArrayDeque<Integer> stk = new ArrayDeque<>();
    ArrayDeque<Integer> maxStack = new ArrayDeque<>();
    
    public MaxStack() {
        
    }
    
    public void push(int x) {
        if (!maxStack.isEmpty()) {
            maxStack.push(x > maxStack.peek() ? x : maxStack.peek());
        } else {
            maxStack.push(x);
        }
        stk.push(x);
    }
    
    public int pop() {
        int removed = stk.pop();
        maxStack.pop();
        return removed;
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    // question doesn't say what the runtime of popMax is, but
    // it has to be O(N) for a simple solution
    public int popMax() {
        if (top() == maxStack.peek()) {
            maxStack.pop();
            return stk.pop();
        }
        Stack<Integer> tmp = new Stack();
        int max = maxStack.peek();
        while (stk.peek() != max) {
            tmp.push(pop());
        }
        
        pop();
        
        while (!tmp.isEmpty()) 
            push(tmp.pop());
        
        return max;
    }
        
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */