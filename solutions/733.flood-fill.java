class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(sr);
        queue.add(sc);
        
        int original = image[sr][sc];
        
        int maxC = image[0].length;
        
        if (original == newColor) return image;
        
        while (!queue.isEmpty()) {
            int srr = queue.remove();
            int scc = queue.remove();
            
            image[srr][scc] = newColor;
            
            if (srr - 1 >= 0 && image[srr - 1][scc] == original) {
                queue.add(srr - 1);
                queue.add(scc);
            }
            
            if (srr + 1 < image.length && image[srr + 1][scc] == original) {
                queue.add(srr + 1);
                queue.add(scc);
            }
            
            if (scc - 1 >= 0 && image[srr][scc - 1] == original) {
                queue.add(srr);
                queue.add(scc - 1);
            }
            
            if (scc + 1 < maxC && image[srr][scc + 1] == original) {
                queue.add(srr);
                queue.add(scc + 1);
            }
        }
        return image;
    }
}