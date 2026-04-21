// 2078. Two Furthest Houses With Different Colors

/**
 * Intuition
 * we need to maximize distance between two colors
 * so we will fix leftmost and rightmost color
 * we will traverse color, and find dist between curr and leftmost and rightmost
 * color
 * Finally we will update res with max of res and above distances
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[0])
                res = Math.max(res, i);
            if (colors[i] != colors[n - 1])
                res = Math.max(res, n - 1 - i);
        }

        return res;
    }
}