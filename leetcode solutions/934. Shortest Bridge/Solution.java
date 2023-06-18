/**
 * 934. Shortest Bridge
 * 
 * Intuition
 * We will use dfs to find the first island and mark it visited.
 * We will also add first island to queue, it will help in bfs
 * In bfs we will expand the curr island and find the second island.
 * We will increase step at the end of each level of bfs, if we find second
 * island ie 1 in the curr level return the curr step.
 * 
 * Complexity
 * Time complexity: O(m*n)
 * Space complexity: O(m*n)
 */
class Solution {

    int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int shortestBridge(int[][] grid) {

        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        boolean found = false;
        Queue<int[]> q = new LinkedList();

        // dfs to find the curr island and mark it visited.
        for (int i = 0; i < n; i++) {
            if (found)
                break;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, visited, q, i, j);
                    found = true;
                    break;
                }
            }
        }

        // bfs to expand the curr island
        return bfs(grid, visited, q);
    }

    private void dfs(int[][] grid, boolean[][] visited, Queue<int[]> q, int i, int j) {
        int n = grid.length;
        if (i < 0 || j < 0 || i >= n || j >= n || visited[i][j] || grid[i][j] != 1)
            return;
        visited[i][j] = true;
        q.add(new int[] { i, j });
        for (int[] dir : dirs) {
            dfs(grid, visited, q, i + dir[0], j + dir[1]);
        }
    }

    private int bfs(int[][] grid, boolean[][] visited, Queue<int[]> q) {
        int n = grid.length;
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int i = curr[0] + dir[0];
                    int j = curr[1] + dir[1];
                    if (i < 0 || j < 0 || i >= n || j >= n || visited[i][j])
                        continue;
                    if (grid[i][j] == 1)
                        return step;
                    visited[i][j] = true;
                    q.add(new int[] { i, j });
                }
            }
            step++;
        }

        return -1;
    }
}