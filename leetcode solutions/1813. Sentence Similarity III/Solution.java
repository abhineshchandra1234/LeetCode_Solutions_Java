/**
 * 1813. Sentence Similarity III
 * 
 * Intuition
 * we can solve this problem through deque
 * split s1 and s2 into words and add it to deque
 * after removing the common prefix and suffix, one of the strings will be empty
 * if one of the strings is empty return true, else false
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {

    public boolean areSentencesSimilar(String sentence1, String sentence2) {

        Deque<String> d1 = new LinkedList(Arrays.asList(sentence1.split(" ")));
        Deque<String> d2 = new LinkedList(Arrays.asList(sentence2.split(" ")));

        while (!d1.isEmpty() && !d2.isEmpty() && d1.peek().equals(d2.peek())) {
            d1.pollFirst();
            d2.pollFirst();
        }

        while (!d1.isEmpty() && !d2.isEmpty() && d1.peekLast().equals(d2.peekLast())) {
            d1.pollLast();
            d2.pollLast();
        }

        return d1.isEmpty() || d2.isEmpty();
    }
}