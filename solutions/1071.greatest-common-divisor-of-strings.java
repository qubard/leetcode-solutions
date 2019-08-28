class Solution {
    public String gcdOfStrings(String str1, String str2) {

        if (str1.isEmpty() && str2.isEmpty())
            return "";
        
        if (str2.isEmpty()) 
            return str1;
        
        if (str1.isEmpty())
            return str2;
        
        if (str2.length() > str1.length()) 
            return gcdOfStrings(str2, str1);
        
        
        int i = 0;
        while(i < str2.length()) {
            char a = str1.charAt(i);
            char b = str2.charAt(i);
            if (a != b) {
                break;
            } else {
                i++;
            }
        }
        
        if (i == 0) return "";
        
        return gcdOfStrings(str1.substring(i, str1.length()), str2);
        // Now i is the max index where they are equal, recurse on str1 and str2
        // str1 is bigger than str2
    }
}