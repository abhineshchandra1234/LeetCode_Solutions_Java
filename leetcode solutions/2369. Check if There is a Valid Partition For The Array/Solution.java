/**
 * 2369. Check if There is a Valid Partition For The Array
 * 
 * Intuition
 * 
 * We will solve this problem using dp
 * dp[i+1] means 0~i is a valid partition.
 * we will get the result at dp[n], if 0~n-1 is a valid partition
 * At every index we will check if its prefix is a valid partition
 * 
 * Approach
 * 
 * for dpIndex i+1, 0~i is a valid partition if it satisfy one of 3 conditions
 * dp[dpIndex-2] is valid partition and nums[i]==nums[i-1]
 * means 0~i-2 is a valid partition and next partition containing nums[i] &
 * nums[i-1] is also valid.
 * we need only 3 states, so we are using rolling index dp
 * 3%3 will collide with 0 so we are using ans to update dp at the end of
 * compuatation.
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public boolean validPartition(int[] nums) {

        int n = nums.length;
        boolean[] dp = new boolean[3];
        dp[0] = true;

        // check nums[0~i] has a valid partition
        for (int i = 0; i < n; i++) {
            int dpIndex = i + 1;
            boolean ans = false;

            if (i > 0 && nums[i] == nums[i - 1])
                ans |= dp[(dpIndex - 2) % 3];
            if (i > 1 && nums[i] == nums[i - 1] && nums[i] == nums[i - 2])
                ans |= dp[(dpIndex - 3) % 3];
            if (i > 1 && nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2)
                ans |= dp[(dpIndex - 3) % 3];

            dp[dpIndex % 3] = ans;
        }

        return dp[n % 3];
    }
}