// 3719. Longest Balanced Subarray I

/**
 * Intuition
 * we will solve this problem using brute force
 * we will use 2 loops, which will generate all sizes of sub-arrays
 * we will have 2 sets to store even and odd nos
 * if both set size is same, update maxL with their size
 * Approach
 * 
 * Complexity
 * Time complexity: O(n^2), running 2 loops to test every sub-arrays
 * Space complexity: O(n), set to store nos
 */

class Solution {
    public int longestBalanced(int[] nums) {

        int n = nums.length;
        int maxL = 0;

        for (int i = 0; i < n; i++) {
            HashSet even = new HashSet();
            HashSet odd = new HashSet();

            for (int j = i; j < n; j++) {
                if (nums[j] % 2 == 0)
                    even.add(nums[j]);
                else
                    odd.add(nums[j]);
                if (even.size() == odd.size())
                    maxL = Math.max(maxL, j - i + 1);
            }
        }

        return maxL;
    }
}