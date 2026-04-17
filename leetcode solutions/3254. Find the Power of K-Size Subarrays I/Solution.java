/**
 * 3254. Find the Power of K-Size Subarrays I
 * 
 * Intuition
 * we can solve this problem through sliding window
 * we will use consecutive count to find our ans
 * one ptr will traverse the nums array
 * if next no is consecutive, end ptr will increase the consecutive count
 * if the no at start of the window was consecutive, we will decrease the
 * consecutive count
 * At last we will check if window size is equal to k
 * then we will check if consecutive count is equal to k, if it is add end ptr
 * no to res
 * end ptr no will max as the sequence is consecutive
 * if the consecutive count is not equal to k, add -1 to res
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {
    public int[] resultsArray(int[] nums, int k) {

        int n = nums.length;
        int[] res = new int[n - k + 1];

        int l = 0;
        int count = 1;
        int i = 0;

        for (int r = 0; r < n; r++) {

            if (r > 0 && nums[r - 1] + 1 == nums[r])
                count++;

            if (r - l + 1 > k) {
                if (nums[l] + 1 == nums[l + 1])
                    count -= 1;
                l += 1;
            }

            if (r - l + 1 == k) {
                if (count == k)
                    res[i++] = nums[r];
                else
                    res[i++] = -1;
            }
        }
        return res;
    }
}