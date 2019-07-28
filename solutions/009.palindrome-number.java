class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        StringBuilder s = new StringBuilder(x+"").reverse();
        return s.toString().equals(x+"");
    }
}