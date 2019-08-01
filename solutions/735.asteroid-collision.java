class Solution {
    // OH LOL you can use a stack because when you pop off
    // you can look at the previous value to re-do explosions
    // continuous negatives afterward can only add explosions so
    // this is a nice property a stack solves
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            int v = asteroids[i];
            boolean pushV = true;
            // v = -5
            // last = 10
            while (!stk.isEmpty() && (stk.peek() > 0 && v < 0)) {
                int last = stk.peek();
                // Keep the larger magnitude
                if (-v == last) {
                    // remove the positive number, dont care
                    pushV = false;
                    stk.pop();
                    break;
                } else if (-v < last) {
                    // This just means an explosion occurs, but we need to keep the 
                    // larger, but we explode ourself
                    pushV = false;
                    break;
                } else if(-v > last) {
                    // the smaller explodes which is last, so we pop old and continue
                    stk.pop();
                }
            }
            
            if (pushV)
                stk.push(v);
        }
        
        return stk.stream().mapToInt(Integer::valueOf).toArray();
    }
}
