/*
1509. Minimum Difference Between Largest and Smallest Value in Three Moves

Intuition

    given an integer array nums
    in one move we can convert any no to any value
    we need to return min difference between min and max no after performing at most 3 moves
    First we need to sort the array
    Then we need to remove 3 min nos or 3 max nos greedily and do operations with rest of the nos to find res
    we can also try different combinations of 3 nos to remove
    remove 3 min nos
    remove 3 max nos
    remove 1 min 2 max nos
    remove 2 min 1 max no
    result will be min of above 4 operations

Approach
Complexity

    Time complexity: O(nlogn), sorting

    Space complexity: O(logn), sorting

*/

class Solution {
    fun minDifference(nums: IntArray): Int {

        var n = nums.size
        if (n <= 4) return 0
        nums.sort()
        var ans = nums[n - 1] - nums[0]
        for (i in 0..3) ans = min(ans, nums[n - (3 - i) - 1] - nums[i])

        return ans
    }
}
