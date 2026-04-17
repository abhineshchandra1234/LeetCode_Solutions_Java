import java.util.Arrays;

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
 * Use dynamic programming, define DP[i][j] as the maximum dot product
 * of two subsequences starting in the position i of nums1 and position j of nums2.
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

// Alternative approach

class Solution {
    int[] nums1, nums2;
    int[][] memo;
    int n, m;
    int neg = (int) -1e9;

    public int maxDotProduct(int[] a, int[] b) {
        nums1 = a;
        nums2 = b;
        n = a.length;
        m = b.length;

        memo = new int[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        return dp(0, 0);
    }

    private int dp(int i, int j) {
        if (i == n || j == m)
            return neg;
        if (memo[i][j] != Integer.MIN_VALUE)
            return memo[i][j];

        int take = nums1[i] * nums2[j];

        int res = Math.max(
                Math.max(
                        take, // take and end here
                        take + dp(i + 1, j + 1) // take both and continue
                ),
                Math.max(
                        dp(i + 1, j), // skip nums1[i]
                        dp(i, j + 1) // skip nums2[j]
                ));

        return memo[i][j] = res;
    }
}
