class Solution {
    // Our algorithm will start from left to right
    // looking for a height first, using that height = a
    // it looks for a height that is >= a, so it can
    // find the end boundary. Then it recursively calls it
    // with a as the fill height, i.e the lowest of the two heights
    // and calculates the total water volume
    private int water_height(int a, int[] height, int i, int j) {
        int totalHeight = 0;
        for (int x = i; x <= j; x++) {
            int h = height[x];
            int d = a - h;
            if (d > 0) {
                totalHeight += d; // We have that each h is guaranteed to be <= a
            }
        }
        return totalHeight;
    }
    
    // We find gaps: then calculate the water height using the left and right boundary
    // A gap is a situation where we see height h_t > 0 s.t the next height
    // at index t+1: h_{t+1} < h_t. Then we find the next instance of
    // h_{t+i} for some i > 1 where h_{t+i} >= h_{t}. This is a gap.
    // Then we scan between (t+1, t+i) for water levels using heights h_{t+1}, h_{t+i}
    // The default case is where we use the min of 2 boundaries.. to subtract the height by
    // We only need 1 parameter then, min(h_{t+1}, h_{t+i})
    // -> n^2 algo
    public int trap(int[] height) {
        int total = 0;
        
        for (int i = 0; i < height.length; i++) {
            if (height[i] > 0 && i + 1 < height.length && height[i+1] < height[i]) {
                // We have a flood condition at i, find b
                int maxJ = -1;
                for (int j = i + 2; j < height.length; j++) {
                    
                    if (height[j] >= height[i]) {
                        maxJ = j;
                        break;
                    } else if (maxJ == -1 && height[j] >= height[i + 1] || (maxJ > 0 && height[j] >= height[maxJ])) {
                        maxJ = j;
                    }
                }
                
                if (maxJ > 0) {
                    //System.out.println("i:"+i + ",j:"+maxJ + "added:" + water_height(Math.min(height[i], height[maxJ]), height, i + 1, maxJ - 1));
                    total += water_height(Math.min(height[i], height[maxJ]), height, i + 1, maxJ - 1);
                    i = maxJ - 1;
                }
            }
        }
        return total;
    }
}