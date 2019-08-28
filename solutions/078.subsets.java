class Solution {
    ArrayList<List<Integer>> solution = new ArrayList<>();
    
    public void subsets(int[] nums, int i, ArrayList<Integer> stk) {
        if (i >= nums.length) {
            solution.add((ArrayList<Integer>)stk.clone());
            return;
        }
        
        stk.add(nums[i]);
        subsets(nums, i + 1, stk);
        stk.remove(stk.size() - 1);
        subsets(nums, i + 1, stk);
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer> vec = new ArrayList<>();
        subsets(nums, 0, vec);
        return solution;
    }
}