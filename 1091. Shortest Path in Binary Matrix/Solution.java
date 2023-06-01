/**
 * 1091. Shortest Path in Binary Matrix
 * 
 * Intuition
 * we will solve this problem through bfs
 * we will start bfs from first cell, we will get all nodes connected to first
 * cell.
 * These child nodes can be part of different paths ie 2, 8, 10 etc.
 * In bfs we traverse by levels. In whichever level we reach the last cell we
 * will return the steps.
 * here the min step is 2 we will stop at 2 level otherwise would have continued
 * till level 8 if 8 was the min step.
 * 
 * Approach
 * we will mark the cell as visited after adding it to queue by assigning 1.
 * we will add cell coordinate and step as 1-d array to queue.
 * 
 * Complexity
 * Time complexity: O(mn)
 * Space complexity: O(mn)
 */
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;

        Queue<int[]> q = new LinkedList();
        q.add(new int[] { 0, 0, 1 });
        grid[0][0] = 1;

        int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cell = q.poll();
                if (cell[0] == n - 1 && cell[1] == n - 1)
                    return cell[2];
                for (int[] d : dir) {
                    int r = cell[0] + d[0];
                    int c = cell[1] + d[1];

                    if (r >= 0 && c >= 0 && r < n && c < n && grid[r][c] == 0) {
                        q.add(new int[] { r, c, cell[2] + 1 });
                        grid[r][c] = 1;
                    }
                }
            }
        }

        return -1;
    }
}