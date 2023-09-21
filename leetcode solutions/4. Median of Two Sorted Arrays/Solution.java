/**
 * 4. Median of Two Sorted Arrays
 * 
 * Intuition
 * 
 * The brute force is first we merge both arrays then find the median but that
 * would take alot of time
 * So we have to do partition of the both the arrays such that all the left
 * elements are smaller than the right elements.
 * Note that both the arrays will have different mids.
 * Median divides both the arrays into smaller and bigger half.
 * We will do binary search on the smaller half of the array to solve this
 * problem.
 * Smaller halfs will contain total (m + n + 1) / 2 elements
 * 
 * Approach
 * 
 * we will do binary search on array of smaller length, so will keep smaller
 * array at first.
 * partition of first array will be left+right-2
 * partition of second array will be ((m + n + 1) / 2) - (left+right-2)
 * now we will use left and right ptrs to find correct partitionA
 * Now we will compare four elements in middle to find correct median point
 * (maxLeftA <= minRightB && maxLeftB <= minRightA)
 * we compare across as it is already sorted in the same array
 * (maxLeftA > minRightB)
 * It means maxLeftA should be on right side
 * (maxLeftB > minRightA)
 * It means we are further on left side of A and minRightA needs to be
 * increased.
 * 
 * Complexity
 * 
 * Time complexity: O(log(min(m,n)))
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int m = nums1.length, n = nums2.length;
        int left = 0, right = m;

        while (left <= right) {
            int partitionA = (left + right) / 2;
            int partitionB = (m + n + 1) / 2 - partitionA;

            int maxLeftA = (partitionA == 0) ? Integer.MIN_VALUE : nums1[partitionA - 1];
            int minRightA = (partitionA == m) ? Integer.MAX_VALUE : nums1[partitionA];
            int maxLeftB = (partitionB == 0) ? Integer.MIN_VALUE : nums2[partitionB - 1];
            int minRightB = (partitionB == n) ? Integer.MAX_VALUE : nums2[partitionB];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((m + n) % 2 == 0)
                    return (Math.max(maxLeftA, maxLeftB) +
                            Math.min(minRightA, minRightB)) / 2.0;
                else
                    return Math.max(maxLeftA, maxLeftB);
            } else if (maxLeftA > minRightB)
                right = partitionA - 1;
            else
                left = partitionA + 1;
        }
        return 0.0;
    }
}