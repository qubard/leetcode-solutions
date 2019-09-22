class RandomizedSet {

    /** Initialize your data structure here. */
    ArrayList<Integer> nums = new ArrayList<>();
    HashMap<Integer, Integer> locs = new HashMap<>();
    Random rand = new Random();
    public RandomizedSet() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (locs.containsKey(val)) return false;
        nums.add(val); // Add to the end -> O(1) time
        locs.put(val, nums.size() - 1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        // When we remove the trick is to find the element, and swap it with the last element then do
        // O(1) removal of the end element
        // Our constraint is that in any random access data structure you can only remove
        // in constant time from the end
        if (!locs.containsKey(val)) return false;
        int last = nums.get(nums.size() - 1);
        nums.set(locs.get(val), last); // Replace val with last element
        locs.put(last, locs.get(val)); // Update position of last element
        locs.remove(val); // Remove val from map
        nums.remove(nums.size() - 1); // Remove val
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */