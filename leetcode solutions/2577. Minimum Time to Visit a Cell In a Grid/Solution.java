/**
 * 2577. Minimum Time to Visit a Cell In a Grid
 * 
 * Intuition
 * we need to reach from source to destination in min time, so we will use
 * dijsktra to solve this
 * one base case for source cell is the right and bottom value should be 1, so
 * that we can move forward
 * sometimes we need to do to and fro from the same cell so that we can move to
 * next greater cell
 * if next cell value is less than or equal to time, we can move to that cell
 * if the diff of next cell and time is even, we can reach that cell in curr
 * value plus 1 time
 * if the diff of next cell and time is odd, we can reach that cell in exact
 * curr value
 * Approach
 * 
 * Complexity
 * Time complexity: O(nlogn)
 * For each configuration, BFS is visiting m*n states
 * Space complexity: O(n)
 */
class Solution {
    public int minimumTime(int[][] grid) {

        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        int n = grid.length;
        int m = grid[0].length;

        if (grid[0][1] > 1 && grid[1][0] > 1)
            return -1;

        boolean[][] vis = new boolean[n][m];
        int[][] res = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[] { grid[0][0], 0, 0 });
        res[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int t = curr[0], r = curr[1], c = curr[2];

            if (r == n - 1 && c == m - 1)
                return res[n - 1][m - 1];

            if (vis[r][c])
                continue;
            vis[r][c] = true;

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m || vis[nr][nc])
                    continue;

                int nextTime;
                if (grid[nr][nc] <= t + 1)
                    nextTime = t + 1;
                else if ((grid[nr][nc] - t) % 2 == 0)
                    nextTime = grid[nr][nc] + 1;
                else
                    nextTime = grid[nr][nc];

                if (nextTime < res[nr][nc]) {
                    res[nr][nc] = nextTime;
                    pq.add(new int[] { nextTime, nr, nc });
                }
            }
        }
        return -1;
    }
}