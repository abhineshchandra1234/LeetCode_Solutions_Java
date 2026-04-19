// 1855. Maximum Distance Between a Pair of Values

/**
 * Intuition
 * we will use two pointers i and j for nums1 and nums2
 * while i and j are in the limits, we will perform following actions
 * if no pointed by i is greater than no pointed by j, increase i pointer
 * Otherwise update res with max of res and j-i and increase j pointer bcs we
 * want max j-i
 * In the above scenario we have got no from nums1 less than or equal to no from
 * nums2
 * Finally return res
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int i = 0, j = 0, res = 0;

        while (i < m && j < n) {
            if (nums1[i] > nums2[j])
                i++;
            else {
                res = Math.max(res, j - i);
                j++;
            }
        }

        return res;
    }
}