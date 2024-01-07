/**
 * 446. Arithmetic Slices II - Subsequence
 * 
 * Intuition
 * 
 * we will solve this problem using bottom-up approach
 * we will traverse nos then we will traverse nos from 0 to i
 * we will find difference between them
 * Store the difference in dp to avoid repeated computation
 * sequence for current i with j of difference diff
 * sequences of i for difference diff + sequences of j for difference diff + 1
 * we update res with sequences of j for difference diff
 * we do not add one to avoid sequence of length 2 between i & j
 * we do not add sequences of i for difference diff as it will add the sequence
 * two times for i
 * we can better understand this by drawing a table with rows as nos, cols as
 * diff and values as no of sequences for no and diff combination just like
 * adjaceny list dp
 * 
 * Approach
 * 
 * difference can differ in values like 2, 4, 6, 8
 * Each no will have different no of sequences base on difference values
 * dp will be adjacency list
 * where row will be nos
 * each row will contain a map which will have difference as key and no of
 * sequences for that difference as value
 * 
 * Complexity
 * 
 * Time complexity: O(n^2), we can form subsequence for n numbers with
 * n numbers
 * 
 * Space complexity: O(n^2), we will have n^2 differences which we
 * need to store
 * 
 */
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {

        int n = nums.length;
        int ans = 0;
        Map<Long, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap();
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];

                dp[i].put(diff, dp[i].getOrDefault(diff, 0) + dp[j].getOrDefault(diff, 0) + 1);
                ans += dp[j].getOrDefault(diff, 0);
            }
        }

        return ans;
    }
}