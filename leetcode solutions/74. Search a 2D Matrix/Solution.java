/**
 * 74. Search a 2D Matrix
 * 
 * Intuition
 * 
 * credits summer.ji.5
 * I will solve this problem without binary search
 * You will notice max element exist at the end of each row we will use this
 * logic to solve this problem.
 * we will start from top right corner
 * If it is less than target, we will move to next row as elements before it are
 * less than target
 * If it is more than target, we will move to j-1 col as all elements after j
 * col are greater than the target
 * It it is equal to target return true. return false at end if row or col goes
 * out of bounds.
 * 
 * Complexity
 * 
 * Time complexity: O(log(m*n))
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {

            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] > target)
                j--;
            else
                i++;
        }
        return false;
    }
}