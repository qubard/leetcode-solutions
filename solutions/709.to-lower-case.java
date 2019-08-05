class Solution {
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ((int)c >= 65 && (int)c <= 90) {
                sb.append((char)((int)c - 65 + 97));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}