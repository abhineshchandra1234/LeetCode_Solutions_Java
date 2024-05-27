/**
 * 1608. Special Array With X Elements Greater Than or Equal X
 * 
 * Intuition

    This is a tricky problem to solve
    we need to find x, such that count x nos in the array is equal or greater than x, not all nos
    If we sort the array and take x nos from the end, if the top of x no ie n-i>=x or i, then rest all x nos >= x, then that index from end is our solution

    nums[n - i] >= i          
top of i or k nos >= i or k

    And also check rest of the nos do not exist or is less than x or i as we need only x suitable nos
    n - i - 1 < 0 || nums[n - i - 1] < i

Approach
Complexity

    Time complexity: O(nlogn), sorting 

    Space complexity: O(logn), sorting

 */
class Solution {
    public int specialArray(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length;

        //top of n or k nos >= n or k
        if (nums[0] >= n)
            return n;

        for (int i = 1; i <= n; i++)
            if (nums[n - i] >= i && (n - i - 1 < 0 || nums[n - i - 1] < i))
                return i;

        return -1;
    }
}