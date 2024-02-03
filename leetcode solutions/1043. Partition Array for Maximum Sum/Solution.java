/**
 * 1043. Partition Array for Maximum Sum
 * 
 * Intuition
 * 
 * We will solve this problem using dynamic programming
 * for every index we will create sub-array of different sizes from [1..k] and
 * find max sum between them
 * dp[i] contain max sum from index i to n
 * Finally we will return res at index 0
 * 
 * Approach
 * 
 * Input: arr = [2,5,10], k = 3
 * Output: 30
 * for index 2 -> 10
 * = 0 + 10 -> 10
 * for index 1 -> 20
 * = 10 + 5 * 1 -> 15
 * = 0 + 10 * 2 -> 20
 * for index 0 -> 30 -> res
 * = 20 + 2 * 1 -> 22
 * = 10 + 5 * 2 -> 20
 * = 0 + 10 * 3 -> 30
 * 
 * Complexity
 * 
 * Time complexity: O(n∗k), for every index we are creating an array
 * of max size k
 * 
 * Space complexity: O(n), dp[i] contain max sum from index i to n
 * 
 */
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);

        for (int start = n - 1; start >= 0; start--) {
            int currMax = 0;
            int end = Math.min(n, start + k);

            for (int i = start; i < end; i++) {
                currMax = Math.max(currMax, arr[i]);
                dp[start] = Math.max(dp[start], dp[i + 1] + currMax * (i - start + 1));
            }
        }
        return dp[0];
    }
}