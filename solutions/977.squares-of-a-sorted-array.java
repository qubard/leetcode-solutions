class Solution {
    public int[] sortedSquares(int[] A) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (Integer i: A) a.add(i * i);
        Collections.sort(a);
        return a.stream().mapToInt(x -> x).toArray();
    }
}