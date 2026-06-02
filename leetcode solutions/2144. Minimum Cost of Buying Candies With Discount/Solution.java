// 2144. Minimum Cost of Buying Candies With Discount

/**
 * Intuition
 * we will first sort the array
 * then we need to pick nos from back and skip every third no, as it will be
 * free
 * Approach
 * 
 * Complexity
 * Time complexity: O(nlogn)
 * Space complexity: O(logn)
 */

class Solution {

    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int res = 0;
        int n = cost.length;
        for (int i = 0; i < n; i++) {
            if ((n - 1 - i) % 3 != 2) {
                res += cost[i];
            }
        }
        return res;
    }
}