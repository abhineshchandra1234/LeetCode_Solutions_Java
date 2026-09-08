// 3870. Count Commas in Range

/**
 * Intuition
 * nos in the range [1000,100000] will have one comma
 * nos less than 1000 will have no comma
 * so nos of comma will be equal to n-999
 * Approach
 * 
 * Complexity
 * Time complexity: O(1)
 * Space complexity: O(1)
 */

class Solution {
    public int countCommas(int n) {
        return Math.max(n - 999, 0);
    }
}