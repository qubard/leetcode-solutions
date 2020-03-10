class RLEIterator {
public:
    int i = 0;
    RLEIterator(vector<int>& A): A(A) {
        
    }
    
    int next(int n) {
        if (i+1 >= A.size()) return -1;

        int ele = A[i + 1];
        int d = A[i];
        A[i] -= min(d, n);

        if (A[i] == 0) {
            i = i + 2;
        }
        
        if (n > d) {
            return next(n - d); 
        }
        
        return ele;
    }
    
    private:
    vector<int> A;
};

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator* obj = new RLEIterator(A);
 * int param_1 = obj->next(n);
 */