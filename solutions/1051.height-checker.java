class Solution {
    public int heightChecker(int[] heights) {
        // There is an O(n) solution that uses counting (radix) sort
        ArrayList<Integer> h = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) h.add(heights[i]);
        Collections.sort(h);
        int c = 0;
        for (int i = 0; i < heights.length; i++)
            if (h.get(i) != heights[i]) c++;
        return c;
    }
}