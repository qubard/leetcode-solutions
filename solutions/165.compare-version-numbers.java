class Solution {
    public int compareVersion(String version1, String version2) {
        String[] one = version1.split("\\.");
        String[] two = version2.split("\\.");
        String[] min = one.length < two.length ? one: one.length > two.length ? two : null;
        
        if (min != null) {
            String[] replace = new String[Math.max(one.length, two.length)];
            for (int i = 0; i < replace.length; i++) {
                if (i < min.length) {
                    replace[i] = min[i];
                } else {
                    replace[i] = "0";
                }
            }
            
            if (one.length < two.length) {
                one = replace;
            } else {
                two = replace;
            }
        }
        
        for (int i = 0; i < one.length; i++) {
            int val = Integer.parseInt(one[i]);
            int val2 = Integer.parseInt(two[i]);
            if (val < val2) {
                return -1;
            } else if (val2 < val) {
                return 1;
            }
        }
        return 0;
    }
}