/**
 * 1760. Minimum Limit of Balls in a Bag
 * 
 * Intuition
 * we cannot solve this problem through brute force, by dividing max nos into
 * max pairs
 * Since the question ask to minimize the maximum value, binary search will be
 * applied
 * lowest value of search would be 1 optimum value of a bag and max value will
 * max no in the nums
 * we will send each value to helper function, to check if mid no is able to
 * divide all nos under max operations
 * in binary search we will update res with possible mid value and try to search
 * more lowest value
 * Approach
 * 
 * Complexity
 * Time complexity: O(n*logn), binary search logn, isPossible search n
 * Space complexity: O(1)
 */
class Solution {

    public int minimumSize(int[] nums, int maxOperations) {

        int m = Integer.MIN_VALUE;

        for (int no : nums) {
            if (no > m)
                m = no;
        }

        int lo = 1, hi = m;
        int res = 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isPossible(nums, maxOperations, mid)) {
                res = mid;
                hi = mid - 1;
            } else
                lo = mid + 1;
        }

        return res;
    }

    boolean isPossible(int[] nums, int maxOperations, int mid) {
        int to = 0;
        for (int no : nums) {
            int ops = no / mid;
            if (no % mid == 0)
                ops -= 1;
            to += ops;
        }

        if (to > maxOperations)
            return false;

        return true;
    }
}