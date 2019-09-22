class Solution {
    private String sort(String str) {
        char temp[] = str.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String key = sort(s);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        
        ArrayList<List<String>> sol = new ArrayList<>();
        
        for (String key : map.keySet()) {
            sol.add(map.get(key));
        }
        return sol;
    }
}