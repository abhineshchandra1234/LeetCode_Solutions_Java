// 3875. Construct Uniform Parity Array I

/**
 * Intuition
 * if nums1 is all odd or even, we just need to copy all elements to nums2
 * if nums1 contains even and odd both, then we can copy odd nos
 * in case of even nos we can subtract it from odd no, which will result in odd
 * no
 * so in all scenarios, we are able to construct nums2 array, so we simply
 * return true
 * Approach
 * 
 * Complexity
 * Time complexity: O(1)
 * Space complexity: O(1)
 */

class Solution {
    public boolean uniformArray(int[] nums1) {
        return true;
    }
}