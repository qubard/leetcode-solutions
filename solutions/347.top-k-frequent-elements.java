class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) { 
            int v = nums[i];
            freq.put(v, freq.getOrDefault(v, 0) + 1);
        }
        
        // initialize sets
        ArrayList<ArrayList<Integer>> sets = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < nums.length + 1; i++) sets.add(new ArrayList<Integer>()); 
        
        for (Integer i : freq.keySet()) {
            int f = freq.get(i);
            sets.get(f).add(i);
        }
        
        // You can also use a heap here, but this runs in pseudopolynomial time
        // The heap version is O(nlogk)
        
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = nums.length; i >= 0; i--) {
            if (!sets.get(i).isEmpty()) {
                System.out.println(sets.get(i).size());
                // pull out Math.min(k, sets[i].length()) characters 
                int toTake = Math.min(k, sets.get(i).size());
                for (int j = 0; j < toTake; j++) {
                    result.add(sets.get(i).get(j));
                }
                k -= toTake;
            }
        }
        return result;
    }
}

/*
class Solution {
  public List<Integer> topKFrequent(int[] nums, int k) {
    // build hash map : character and how often it appears
    HashMap<Integer, Integer> count = new HashMap();
    for (int n: nums) {
      count.put(n, count.getOrDefault(n, 0) + 1);
    }

    // init heap 'the less frequent element first'
    PriorityQueue<Integer> heap =
            new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

    // keep k top frequent elements in the heap
    for (int n: count.keySet()) {
      heap.add(n);
      if (heap.size() > k)
        heap.poll(); // constrain the heap size to k
    }

    // build output list
    List<Integer> top_k = new LinkedList();
    while (!heap.isEmpty())
      top_k.add(heap.poll());
    Collections.reverse(top_k);
    return top_k;
  }
}
*/