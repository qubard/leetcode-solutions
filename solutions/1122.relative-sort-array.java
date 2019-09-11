class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        List<Integer> a = new ArrayList<Integer>();
        HashMap<Integer, Integer> ind = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            ind.put(arr2[i], i);
        }
        for (int i = 0; i < arr1.length; i++) {
            a.add(arr1[i]);
        }
        
        a.sort((e, b) -> {
            if (!ind.containsKey(e) || !ind.containsKey(b)) {
                if (!ind.containsKey(e) && !ind.containsKey(b)) {
                    return e - b;
                }
                return 0; // ignore (they are equal)
            }
            int i = ind.get(e);
            int j = ind.get(b);
            return i - j;
        });
        
        int[] ret = new int[arr1.length];
        int i = 0;
        for (Integer x : a) {
            ret[i++] = x;
        }
        return ret;
    }
}