/**
 * 1639. Number of Ways to Form a Target String Given a Dictionary
 * 
 * Intuition
 * The problem statement is tricky to understand
 * Suppose we pick index 3 char of first word to form target, then we cannot use
 * index 0->3 chars of any word to form target.
 * next char index will be at 4 and then at 5 and so on.
 * to form each char of target we need to parse whole words array.
 * And there will be repeated computation so we will use dp to remember state.
 * We will use formula
 * dp[no of ways to form target j+1 first charcters] = dp[no of ways to form
 * target j first charecters] * new char count
 * let see this with an example
 * words = ["acca","bbbb","caca"], target = "aba"
 * there are 6 ways to form aba
 * there are 3 ways to form ab till the last index of the word
 * last index has 2 a, so there will be 3*2=6 ways to form "aba"
 * 
 * Approach
 * We will traverse the word length
 * Then we will store the count of each char at that index for every word.
 * then we will traverse the traget from reverse to apply the formula
 * Finally we will return the res.
 * 
 * Complexity
 * Time complexity:
 * O(n*n)
 * 
 * O(S*(W+N))
 * 
 * Space complexity:
 * 
 * O(n)
 * O(S+N)
 * S = words[i].length
 * W = words.length
 * N = target.length
 */
class Solution {
    public int numWays(String[] words, String target) {

        int n = target.length();
        long mod = (long) 1e9 + 7, res[] = new long[n + 1];
        res[0] = 1;
        for (int i = 0; i < words[0].length(); i++) {
            int[] count = new int[26];
            // count of each char at index i for all words
            for (String w : words)
                count[w.charAt(i) - 'a']++;
            // dp first j+1 chars = dp first j chars * new char count
            // after addition it can spill so we do mod operation 2 times.
            for (int j = n - 1; j >= 0; j--)
                res[j + 1] += res[j] * count[target.charAt(j) - 'a'] % mod;
        }
        return (int) (res[n] % mod);
    }
}