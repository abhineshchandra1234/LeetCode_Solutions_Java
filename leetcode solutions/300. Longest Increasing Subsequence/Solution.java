/**
 * 300. Longest Increasing Subsequence
 * 
 * Intuition
 * 
 * we will solve this problem using dfs
 * it is like 0/1 knapsack problem we can either pick curr element or skip it
 * for LIS that way time complexity will be 2n2^n2n
 * we can reduce it further using dfs
 * every index can be a start of LIS
 * we can create a dfs tree for each index to understand better
 * 2nd version
 * We can treat every no as end of lis
 * start can be any no from 0 to i-1
 * we will update curr value if by including curr no to prev lis is greater than
 * curr lis
 * dp[i] = dp[j] + 1;
 * Then we will update max with curr lis after its computation is finished, then
 * move to other index and repeat same
 * At last max will have max lis of all indices
 * by default lis for every index will be 1, ie curr char only
 * Version 2 template you can follow for all subsequence problems
 * 
 * 
 * Approach
 * 
 * like - [1, 4, 2, 3] res -> 3, [1, 2, 3]
 * we can create LIS from any index, lets start from back
 * we can create LIS if next idx is greater than curr idx
 * 3 -> [3], no more index can be reached, 3 is at end
 * 2 -> [2], i=3 -> [2,3]
 * 1 -> [4], no more idx can be reached, 4 is greatest
 * 0 -> [1],
 * i=1 -> [1,4], we saw earlier max LIS at 1 is 1 ie -> 1+1=2
 * i=2 -> [1,2], we saw earlier max LIS at 2 is 2 ie -> 1+2 =3
 * we further proceed to idx 3, so [1,2,3]
 * i=3 -> [1,3], we saw earlier max LIS at 3 is 1 ie -> 1+1=2
 * 
 * Among all indices max LIS is at index 0 of length 3, for index [0, 2, 3] ie
 * [1, 2, 3]
 * 
 * Complexity
 * 
 * Time complexity: O(n^2)
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int[] LIS = new int[nums.length];
        Arrays.fill(LIS, 1);

        int maxLIS = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j])
                    LIS[i] = Math.max(LIS[i], 1 + LIS[j]);
            }
            maxLIS = Math.max(maxLIS, LIS[i]);
        }

        return maxLIS;
    }
}

// version 2
class Solution {
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int lis = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    lis = Math.max(lis, dp[i]);
                }
            }
        }

        return lis;
    }
}