// 11. Container With Most Water

/**
 * Intuition
 * we will solve this through two ptrs
 * one ptr will point to start and other ptr will point to end
 * Area at any point will be equal to right-left*min(height[right],height[left])
 * we will update maxArea with max of maxArea and Area at curr point
 * then if height at start ptr is less than height at end ptr increase start ptr
 * otherwise increase end ptr
 * we do this so that we have greater boundary
 * return maxArea at the end
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));

            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}