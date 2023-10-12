/**
 * 1095. Find in Mountain Array
 * 
 * Intuition
 * 
 * It is similar to the problem "852. Peak Index in a Mountain Array"
 * credits lee215
 * we will apply 3 binary search to solve this problem
 * first search to find the peak element
 * second search to find target in strictly increasing section
 * third reverse search to find target in strictly decreasing section
 * 
 * Approach
 * 
 * binary search will work to find the peak element, since one section will be
 * discarded after first comparison.
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(logn), binary search
 * 
 * Space complexity:
 * 
 * O(1)
 * 
 */
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 * public int get(int index) {}
 * public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {

        int n = mountainArr.length(), l, r, mid, peak = 0;

        // find index of peak
        l = 0;
        r = n - 1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1))
                l = mid + 1;
            else
                r = mid - 1;
        }
        peak = l;

        // find target in the left of peak
        l = 0;
        r = peak;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (mountainArr.get(mid) < target)
                l = mid + 1;
            else if (mountainArr.get(mid) > target)
                r = mid - 1;
            else
                return mid;
        }

        // find target in the right of peak
        l = peak;
        r = n - 1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (mountainArr.get(mid) > target)
                l = mid + 1;
            else if (mountainArr.get(mid) < target)
                r = mid - 1;
            else
                return mid;
        }
        return -1;
    }
}