// 3300. Minimum Element After Replacement With Digit Sum

/**
 * Intuition
 * we will traverse all nos, find its sum
 * then compare it with res and update res with max of two
 * Approach
 * 
 * Complexity
 * Time complexity: O(nlogn)
 * Space complexity: O(1)
 */

class Solution {
    public int minElement(int[] nums) {
        int ans = 37;
        for (int num : nums) {
            int dig = 0;
            while (num > 0) {
                dig += num % 10;
                num /= 10;
            }
            ans = Math.min(ans, dig);
        }
        return ans;
    }
}