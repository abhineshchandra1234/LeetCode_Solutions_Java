/**
 * 1657. Determine if Two Strings Are Close
 * 
 * Intuition
 * 
 * credits suman_buie
 * In order to make two strings equal we need to have same unique chars in both
 * strings
 * And freq of different chars in both strings should be equal
 * 
 * Approach
 * 
 * Input: word1 = "cabbba", word2 = "abbccc"
 * Output: true
 * w1 unique chars -> a,b,c
 * w2 unique chars -> a,b,c
 * w1 -> c-1, a-2, b-3
 * w2 -> a-1, b-2, c-3
 * 
 * Total count of chars is 6. Suppose word2 has freq 2 for all chars
 * Since partial transformation is not allowed we can reach max bb but we need
 * bbb for word1, so we need equal freqs for different chars
 * 
 * Complexity
 * 
 * Time complexity: O(n∗logn), very small as we need to sort
 * array of length 26
 * 
 * Space complexity: O(1), array fixed size 26
 * 
 */
class Solution {
    public boolean closeStrings(String word1, String word2) {

        int[] w1 = new int[26];
        int[] u1 = new int[26];
        int[] w2 = new int[26];
        int[] u2 = new int[26];

        for (char c : word1.toCharArray()) {
            int idx = c - 'a';
            w1[idx]++;
            u1[idx] = 1;
        }

        for (char c : word2.toCharArray()) {
            int idx = c - 'a';
            w2[idx]++;
            u2[idx] = 1;
        }

        Arrays.sort(w1);
        Arrays.sort(w2);

        return Arrays.equals(w1, w2) && Arrays.equals(u1, u2);
    }
}