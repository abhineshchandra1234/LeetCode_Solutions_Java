/**
 * 1406. Stone Game III
 * 
 * Intuition
 * credits lee215
 * This problem is easy compared to stone game II
 * What I observed in the stone game series is that both siblings are greedy and
 * want maximum result for themselves.
 * Then can utlize 1 to max opportunity to get their result.
 * We will use dp to solve this
 * dp[i] means, if we ignore before A[i], what's the highest score that Alex can
 * win over the Bob？
 * There are three option for Alice to choose.
 * Take A[i], win take - dp[i+1]
 * Take A[i] + A[i+1], win take - dp[i+2]
 * Take A[i] + A[i+1] + A[i+2], win take - dp[i+3]
 * dp[i] equals the best outcome of these three solutions.
 * Input: values = [1,2,3,7]
 * Output: "Bob"
 * dp[3]=7, dp[2]=10, dp[1]=12, dp[0]=-1
 * Alice starts first so we will return dp[0]. Here Alice need -1 to win bob
 * means alice has 1 less than bob max profit.
 * Input: values = [1,2,3,6]
 * Output: "Tie"
 * dp[3]=6, dp[2]=9, dp[1]=11, d[0]=0
 * Here Alice need 0 to win bob means alice and bob has same max profit.
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {
    public String stoneGameIII(int[] A) {
        int n = A.length, dp[] = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Integer.MIN_VALUE;
            for (int k = 0, take = 0; k < 3 && i + k < n; k++) {
                take += A[i + k];
                dp[i] = Math.max(dp[i], take - dp[i + k + 1]);
            }
        }

        if (dp[0] > 0)
            return "Alice";
        if (dp[0] < 0)
            return "Bob";
        return "Tie";
    }
}