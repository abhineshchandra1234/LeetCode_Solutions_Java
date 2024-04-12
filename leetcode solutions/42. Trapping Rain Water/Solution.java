/**
 * 42. Trapping Rain Water
 * 
 * Intuition
 * 
 * credits mcrystal
 * we will use two ptrs to solve this problem
 * we will flow water from lower to higher end, something should be there at end
 * to stop the water
 * So if right wall is higher we will fill water in the left side
 * maxLeft would be the left wall of the left side and we can fill water till
 * maxLeft, as water will start overflowing
 * on right, higher right wall will stop the water
 * water content = maxLeft * 1, for each water block is added to res
 * Similarly if left wall is higher we will fill water in the right side
 * we keep doing this till left and right wall becomes equal
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int trap(int[] height) {

        int left = 0, right = height.length - 1;
        int res = 0;
        int maxLeft = 0, maxRight = 0;

        while (left <= right) {

            if (height[left] <= height[right]) {
                if (height[left] > maxLeft)
                    maxLeft = height[left];
                else
                    res += maxLeft - height[left];
                left++;
            } else {
                if (height[right] > maxRight)
                    maxRight = height[right];
                else
                    res += maxRight - height[right];
                right--;
            }
        }

        return res;
    }
}