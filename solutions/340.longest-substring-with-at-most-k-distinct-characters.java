class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxCount = 0;
        
        if (k == 0) return 0;
        
        while(j < s.length()) {
            if (!map.containsKey(s.charAt(j)) && map.keySet().size() >= k) {
                int idx = Collections.min(map.values());
                map.remove(s.charAt(idx));
                i = idx + 1;
            } else {
                map.put(s.charAt(j), j);
                maxCount = Math.max(maxCount, j - i + 1);
                j++;
            }
        }
        return maxCount;
    }
}