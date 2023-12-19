/**
 * 661. Image Smoother
 * 
 * Intuition
 * 
 * the desc and ex is very confusing, we can understand through individual cells
 * we need to apply smoothen block to each cell and find avg of the block and
 * assign it to the cell. Thats it.
 * For each cell we will discard neighs outside smoothen block
 * smoothen block will be from i-1 to i+1 for rows and j-1 to j+1 for cols for
 * each cell and it will contain curr cell too.
 * 
 * Approach
 * 
 * for (0,0) few of the nighs cell will be discarded, as it is outside the
 * matrix.
 * for (1,1), no cells will be discarded from smoothen block
 * 
 * Complexity
 * 
 * Time complexity: O(m∗n)
 * 
 * Space complexity: O(m∗n)
 * 
 */
class Solution {
    public int[][] imageSmoother(int[][] img) {

        int n = img.length, m = img[0].length;
        int[][] res = new int[n][m];

        // apply smoothen to each cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = smoothen(img, i, j);
            }
        }
        return res;
    }

    int smoothen(int[][] img, int x, int y) {
        int n = img.length, m = img[0].length;
        int sum = 0;
        int count = 0;

        // sum and count of nos in smoothen block
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nx = x + i;
                int ny = y + j;

                // discard neighs for a cell outside smoothen block
                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;

                sum += img[nx][ny];
                count++;
            }
        }
        // avg of smoothen block
        return sum / count;
    }
}