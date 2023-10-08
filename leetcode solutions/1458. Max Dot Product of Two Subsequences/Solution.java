/**
 * 1458. Max Dot Product of Two Subsequences
 * 
 * Intuition
 * 
 * we will solve this problem using recursion and memoization to avoid repeated
 * computation ie top-down approach
 * For every combination of nums1 & nums2 we three choices
 * first -> pick both and move to next indices
 * second -> pick nums1 and skip nums2
 * third -> skip nums1 and pick nums2
 * 
 * Approach
 * 
 * we can also have edge case where one of them have all -ve nos and other dont,
 * then product will always be -ve
 * to maximize this product select least values from both arrays
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(m*n), dp states
 * 
 * Space complexity:
 * 
 * O(m*n), dp space
 * 
 * 
 */
class Solution {
    Integer[][] memo;

    public int maxDotProduct(int[] nums1, int[] nums2) {

        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int num : nums1) {
            firstMax = Math.max(firstMax, num);
            firstMin = Math.min(firstMin, num);
        }

        for (int num : nums2) {
            secondMax = Math.max(secondMax, num);
            secondMin = Math.min(secondMin, num);
        }

        if (firstMax < 0 && secondMin > 0)
            return firstMax * secondMin;

        if (firstMin > 0 && secondMax < 0)
            return firstMin * secondMax;

        memo = new Integer[nums1.length][nums2.length];
        return dp(0, 0, nums1, nums2);
    }

    public int dp(int i, int j, int[] nums1, int[] nums2) {
        if (i == nums1.length || j == nums2.length)
            return 0;

        if (memo[i][j] != null)
            return memo[i][j];

        int use = nums1[i] * nums2[j] + dp(i + 1, j + 1, nums1, nums2);
        memo[i][j] = Math.max(use, Math.max(dp(i + 1, j, nums1, nums2),
                dp(i, j + 1, nums1, nums2)));
        return memo[i][j];
    }
}