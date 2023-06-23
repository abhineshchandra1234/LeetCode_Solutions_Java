/**
 * 1027. Longest Arithmetic Subsequence
 * 
 * Intuition
 * 
 * credits lee215, kshatriyas
 * We will solve this problem using dp
 * dp[index][diff] equals the longest arithmetic at the index with the diff.
 * the diff will be nums[i] - nums[j] where j is from 0 to i-1.
 * If the diff exist at any index before i we will add + 1 to its length and
 * store it in the curr index.
 * If the diff doesnt exist before intialize with 2 intially.
 * At the every index update longest with the max of diff.
 * 
 * Approach
 * 
 * default value of longest will be 2 min
 * 
 * Complexity
 * 
 * Time complexity: O(n^2)
 * 
 * Space complexity: O(n^2)
 * 
 */
class Solution {
    public int longestArithSeqLength(int[] nums) {

        int n = nums.length;
        if (n <= 2)
            return n;

        int longest = 2;
        Map<Integer, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap();
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);
                longest = Math.max(longest, dp[i].get(diff));
            }
        }
        return longest;
    }
}