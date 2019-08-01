class Solution {
    // splitting is O(n), reversing is O(n) (assuming a linkedlist conversion first)
    // joining is O(n) -> total: O(n) runtime
    // If we weren't using handy util functions we would just
    // build a linkedlist of words by looking for the start/end of a word
    // looking at spaces, and then then join all the words using
    // string concatenation (which can be O(n^2) if you do O(n) concats, but
    // if you allocate the same size char array it's O(n))
    public String reverseWords(String s) {
        List<String> words = Arrays.asList(s.split("\\s+"));
        Collections.reverse(words);
        return String.join(" ", words).trim();
    }
}
