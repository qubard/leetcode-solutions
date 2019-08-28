class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.split("\\P{L}+");
        // Remove punctuation
        
        HashSet<String> ignore = new HashSet<>();
        for (String s : banned) {
            ignore.add(s);
        }
        int max = 0;
        String maxWord = "";
        HashMap<String, Integer> freq = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String s = words[i].toLowerCase();
            String n = "";
            for (int j = 0; j < s.length(); j++) {
                if ((int)s.charAt(j) >= 97 && (int)s.charAt(j) <= 122) {
                    n += s.charAt(j);
                }
            }
            words[i] = n;
            freq.put(n, freq.getOrDefault(n, 0) + 1);
            if (freq.get(n) > max && !ignore.contains(n)) {
                max = freq.get(n);
                maxWord = n;
            }
        }
        
        return maxWord;
    }
}