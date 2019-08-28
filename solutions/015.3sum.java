class Solution {
    
    public List<List<Integer>> threeSum(int[] nums) {
        // all the pairs that sum up to some other number in the array 
        // just do 2sum on all values in the array to get 3 pairs
        // your 2sum target is -nums[i];
        ArrayList<Integer> sorted = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) sorted.add(nums[i]);
        Collections.sort(sorted);
        
        HashSet<String> set = new HashSet<>();
        ArrayList<List<Integer>> sol = new ArrayList<>();
        
        for (int i = 0; i < sorted.size(); i++) {
            int left = 0; 
            int right = nums.length - 1;
            int target = -sorted.get(i);
            
            while (left < right) {
                if (left == i) {
                    left++;
                    continue;
                }
                
                if (right == i) {
                    right--;
                    continue;
                }
                
                int a = sorted.get(left);
                int b = sorted.get(right);
                if (a + b < target) {
                    left++;
                } else if (a + b > target) {
                    right--;
                } else {
                    // a + b == target
                    PriorityQueue<Integer> pq = new PriorityQueue<>();
                    pq.add(a);
                    pq.add(b);
                    pq.add(-target);
                    int first = pq.poll();
                    int second = pq.poll();
                    int third = pq.poll();
                    ArrayList<Integer> ee = new ArrayList<>();
                    String key = first + ":" + second + ":" + third;
                    if (!set.contains(key)) {
                        set.add(key);
                        ee.add(first);
                        ee.add(second);
                        ee.add(third);
                        sol.add(ee);
                    }
                    left++;
                }
            }
        }
        return sol;
    }
}