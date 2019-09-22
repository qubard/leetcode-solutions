/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int left = 0;
        int right = n - 1;
        // The best solution (which I didn't figure out) 
        // is to go from left to right and choose a candidate
        // and update it when knows(candidate, i) i.e 
        // the candidate's outdegree is > 1. By definition
        // all nodes to the left know the candidate so you can use
        // this property to get the answer
        while (left < right) {
            if (knows(left, right) && knows(right,left)) {
                left++;
                right--;
            } else if (knows(left,right)) {
                left++;
            } else if (knows(right, left)) {
                right--;
            } else if(!knows(left, right) && !knows(right, left)) {
                left++;
                right--;
            }
            
            if (left == right) {
                // Check if it has outdegree 0
                int in = 0;
                for (int i = 0; i < n; i++) {
                    if (i != left) {
                        if (knows(i, left)) in++;
                        if (knows(left, i)) return -1;
                    }
                }
                return in == n - 1 ? left : -1;
            }
        }
        return -1;
    }
}