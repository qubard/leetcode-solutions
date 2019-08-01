class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int c = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean left = i == 0 ? true : flowerbed[i - 1] == 0;
                boolean right = i == flowerbed.length - 1 ? true : flowerbed[i + 1] == 0;
                if (left && right) {
                    c++;
                    flowerbed[i] = 1;
                }
            }
        }
        return c >= n;
    }
}
