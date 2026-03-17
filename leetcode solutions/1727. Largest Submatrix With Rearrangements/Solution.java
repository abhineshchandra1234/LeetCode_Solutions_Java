/**
 * 1727. Largest Submatrix With Rearrangements
 * 
 * Intuition
 * Approach 1 (Sort by height on each row)
 * 
 * credits Aincrad-Lyu
 * This question is very similar to
 * 84. Largest Rectangle in Histogram
 * Maximal Rectangle
 * Continous ones in any row range 0-1, 0-2, 0-3 will form a histogram
 * we can sort them to get largest rectangle
 * then we just need to update res with max area of this rectangles taking each
 * row as base.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity:
 * 
 * O(m∗n∗logn), sorting height arr for m rows
 * 
 * Space complexity:
 * 
 * O(n), height arr
 * 
 */
class Solution {
    public int largestSubmatrix(int[][] matrix) {

        int m = matrix.length, n = matrix[0].length;
        int ans = 0;
        int[] height = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0)
                    height[j] = 0;
                else
                    height[j] += 1;
            }

            int[] orderHeight = Arrays.copyOf(height, n);
            Arrays.sort(orderHeight);

            for (int j = 0; j < n; j++)
                ans = Math.max(ans, orderHeight[j] * (n - j));

        }
        return ans;
    }
}

class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;

        for (int row = 0; row < m; row++) {

            for (int col = 0; col < n; col++) {

                if (matrix[row][col] == 1 && row > 0) {
                    matrix[row][col] += matrix[row - 1][col];
                }

            }

            int[] currRow = Arrays.copyOf(matrix[row], n);
            Arrays.sort(currRow);

            // reverse to get descending order
            for (int i = 0; i < n / 2; i++) {
                int temp = currRow[i];
                currRow[i] = currRow[n - i - 1];
                currRow[n - i - 1] = temp;
            }

            for (int col = 0; col < n; col++) {
                int base = col + 1;
                int height = currRow[col];

                result = Math.max(result, base * height);
            }
        }

        return result;
    }
}
