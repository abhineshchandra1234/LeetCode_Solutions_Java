/**
 * 2540. Minimum Common Value
 * 
 * Intuition
 * 
 * we can solve this problem using set but to further optimize it we can use
 * two-pointers
 * 
 * Approach
 * 
 * two-ptrs will point to start of both arrays
 * we will increase the ptr of the array with min no
 * If the nos are equal return any no otherwise return -1 at the end.
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int getCommon(int[] nums1, int[] nums2) {

        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j])
                i++;
            else if (nums1[i] > nums2[j])
                j++;
            else
                return nums1[i];
        }
        return -1;
    }
}