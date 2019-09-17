class TimeMap {

    
    HashMap<String, TreeMap<Integer, String>> trees = new HashMap<>(); // Global table of all timevals
    
    /** Initialize your data structure here. */
    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        if (!trees.containsKey(key)) {
            trees.put(key, new TreeMap<Integer, String>());
        }
        trees.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!trees.containsKey(key)) return "";
        if (trees.get(key).floorKey(timestamp) != null) {
            return trees.get(key).floorEntry(timestamp).getValue();
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */