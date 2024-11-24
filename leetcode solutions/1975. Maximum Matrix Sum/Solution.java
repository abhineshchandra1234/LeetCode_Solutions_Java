/**
 * 1975. Maximum Matrix Sum
 * 
 * Intuition
 * we can solve this problem through brute force
 * if we have even no of negatives, we can make it positive and calculate total
 * sum
 * if we have odd no of negatives, no matter what we do, we will always have 1
 * negative no left
 * we would transfer this negative to lowest no of the matrix
 * we are finding res by taking sum of all nos absolute values
 * to accomodate negative no, we need first remove it from res
 * as the question says need to again subtract it from the res
 * Approach
 * 
 * Complexity
 * Time complexity: O(m*n)
 * Space complexity: O(1)
 */
class Solution {
    public long maxMatrixSum(int[][] matrix) {

        int neg = 0, min = Integer.MAX_VALUE;
        long res = 0;

        for (int[] mat : matrix) {
            for (int no : mat) {
                res += Math.abs(no);
                min = Math.min(min, Math.abs(no));
                if (no < 0)
                    neg += 1;
            }
        }

        if ((neg & 1) == 1)
            res -= 2 * min;

        return res;
    }
}