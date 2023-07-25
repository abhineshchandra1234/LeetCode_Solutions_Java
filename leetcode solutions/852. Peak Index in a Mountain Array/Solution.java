/**
 * 852. Peak Index in a Mountain Array
 * 
 * Intuition
 * 
 * According to question we need to find first ith element greater than i+1th
 * element.
 * We will apply binary search with condition arr[mid] < arr[mid + 1]
 * In binary search its important we satisfy the base cond
 * if arr[mid] < arr[mid + 1] the res is in right side so we are searching there
 * and vice-versa for arr[mid] >= arr[mid + 1]
 * 
 * Complexity
 * 
 * Time complexity: O(logn)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int peakIndexInMountainArray(int[] arr) {

        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < arr[mid + 1])
                l = mid + 1;
            else
                r = mid - 1;
        }
        return l;
    }
}