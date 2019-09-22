// Another way to do this is to instead store the index of the character instead of the count
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> seen = new HashMap<>(); // window map of all characters seen
        int left = 0;
        int right = 0;
        int sol = 0;
        while (right < s.length()) {
            if (seen.keySet().size() <= 2) {
                char c = s.charAt(right);
                seen.put(c, seen.getOrDefault(c, 0) + 1);
                right++;
            }
            while (seen.keySet().size() > 2) {
                char c = s.charAt(left);
                seen.put(c, seen.get(c) - 1);
                if (seen.get(c) == 0) seen.remove(c);
                left++;
            }
            sol = Math.max(right - left, sol);
        }
        return sol;
    }
}