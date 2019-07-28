class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int maxCount = 0;
        int currCount = 0;
        int i = 0;
        // yes, the dp solution is simpler (keep a sliding window and extend bounds i,j respectively)
        while (i < s.length()) {
            char c = s.charAt(i);
            Integer index = map.get(c);
            if (index != null && index != -1) {
                currCount = i - index.intValue();
                for (Map.Entry<Character, Integer> pair: map.entrySet()) {
                    char k = pair.getKey();
                    int v = pair.getValue();
                    if (v <= index.intValue()) {
                       map.put(k, -1);
                   }
                }
            } else {
                currCount += 1;
            }
            maxCount = Math.max(currCount, maxCount);
            map.put(c, i);
            i++;
        }
        return maxCount;
    }
}