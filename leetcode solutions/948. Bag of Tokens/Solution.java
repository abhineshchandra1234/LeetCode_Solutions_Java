/**
 * 948. Bag of Tokens
 * 
 * Intuition
 * 
 * credits lee215
 * to get the max score we need to buy token at cheapest and sell at highest
 * so we will sort tokens based on price, and use two ptrs start will be used to
 * buy tokens at cheapest rates and end will be used to sell tokens at highest
 * rates
 * we cannot use visted tokens
 * we will first try to buy tokens
 * if we cannot buy then we would try to sell tokens
 * If we cannot do both ie we have exhuasted all the resources, we will return
 * the max score
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n∗logn), sort
 * 
 * Space complexity: O(logn), sort
 * 
 */
class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length;
        Arrays.sort(tokens);
        int max = 0, start = 0, end = n - 1, score = 0;

        while (start <= end) {
            if (power >= tokens[start]) {
                power -= tokens[start++];
                max = Math.max(max, ++score);
            } else if (score > 0) {
                power += tokens[end--];
                score--;
            } else
                break;
        }

        return max;
    }
}