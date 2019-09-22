class Solution {
    ArrayList<List<Integer>> sol = new ArrayList<>();
    // Generate solutions from index i of candidates
    public void backtrack(int[] candidates, int sum, int i, ArrayList<Integer> result) {
        if (sum == 0) {
            // add the solution, do a copy
            sol.add((ArrayList<Integer>)result.clone());
            return;
        }
        
        if (sum < 0 || i >= candidates.length) {
            return; // invalid solution
        }
        
        result.add(candidates[i]);
        backtrack(candidates, sum - candidates[i], i, result);
        result.remove(result.size() - 1); // remove last entry
        backtrack(candidates, sum, i + 1, result); 
        // Some solutions replace the 2 backtrack calls with 1 call in a loop, but there is no difference between these two solutions
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Sorting the values so they're in ascending order wil prevent duplicates
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>());
        return sol;
    }
}