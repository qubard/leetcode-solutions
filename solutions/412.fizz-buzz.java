class Solution {
    public List<String> fizzBuzz(int n) {
        ArrayList<String> lis = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                lis.add("FizzBuzz");
            } else if (i % 5 == 0) {
                lis.add("Buzz");
            } else if (i % 3 == 0) {
                lis.add("Fizz");
            } else {
                lis.add(i+"");
            }
        }
        return lis;
    }
}