class Solution {
    public int[] dailyTemperatures(int[] T) {
        ArrayDeque<Integer> stk = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int sol[] = new int[T.length];
        int j = 0;
        for (int i = 0; i < T.length; i++) {
            while (!stk.isEmpty() && T[stk.peek()] < T[i]) {
                //System.out.println(T[stk.peek()] + "<" + T[i] + "(" + i +"," + stk.peek());
                map.put(stk.pop(), i);
            }
            stk.push(i);
        }
        
        for (int i = 0; i < sol.length; i++) {
            if (map.containsKey(i)) {
                sol[i] = map.get(i) - i;
            }
        }
        
        return sol;
    }
}