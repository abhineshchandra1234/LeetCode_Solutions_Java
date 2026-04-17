/**
 * 1861. Rotating the Box
 * 
 * Intuition
 * we can solve this problem through simulation
 * we will start checking from bottom right cell
 * If it is a rock we will place it at correct position in the res, last empty
 * row, m-1-i
 * Then we will increase last empty row for that column
 * If we found a obstacle, place obstacle at correct position in the res, j,
 * m-1-i
 * Then update the last empty row to j-1, as we will fill rock above obstacle
 * Approach
 * 
 * Complexity
 * Time complexity: O(m*n)
 * Space complexity: O(m*n)
 */
class Solution {
    public char[][] rotateTheBox(char[][] box) {

        int n = box.length;
        int m = box[0].length;

        char[][] res = new char[m][n];

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                res[j][i] = '.';
            }
        }

        for (int i = 0; i < n; i++) {
            int lastRow = m - 1;
            for (int j = m - 1; j >= 0; j--) {
                if (box[i][j] == '#') {
                    res[lastRow][n - 1 - i] = '#';
                    lastRow--;
                } else if (box[i][j] == '*') {
                    res[j][n - 1 - i] = '*';
                    lastRow = j - 1;
                }
            }
        }

        return res;
    }
}