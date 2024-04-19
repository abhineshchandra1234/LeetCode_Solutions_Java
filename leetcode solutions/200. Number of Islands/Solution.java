/**
 * 200. Number of Islands
 * 
 * Intuition
 * 
 * We will traverse array, if we got 1 then we will increase island count
 * We will mark all the connected land by converting them to 0, this can done by
 * recursion (DFS) or through queue (BFS)
 * 
 * Note - I always make mistake of fetching out of bounds index. Just fetch it
 * at the later stage when you are sure row and col are inside bounds
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n), recursion
 * 
 */

// DFS 1
class Solution {
    int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int numIslands(char[][] grid) {

        int n = grid.length, m = grid[0].length, islands = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                islands += sink(grid, i, j);
        return islands;
    }

    public int sink(char[][] grid, int i, int j) {
        int n = grid.length, m = grid[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == '0')
            return 0;
        grid[i][j] = '0';
        for (int[] d : dirs)
            sink(grid, i + d[0], j + d[1]);
        return 1;
    }
}

// DFS 2
class Solution {

    int count = 0;

    public int numIslands(char[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int x, int y) {
        int n = grid.length, m = grid[0].length;

        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] != '1')
            return;

        grid[x][y] = '0';
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }
}

// BFS

class Solution {

    int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int numIslands(char[][] grid) {

        int n = grid.length, m = grid[0].length, islands = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '0')
                    continue;
                islands++;
                bfs(grid, i, j);
            }
        }
        return islands;
    }

    public void bfs(char[][] grid, int i, int j) {
        int n = grid.length, m = grid[0].length;
        grid[i][j] = '0';
        Queue<int[]> q = new LinkedList();
        q.add(new int[] { i, j });
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int curr[] = q.poll();
                for (int[] d : dirs) {
                    int x = curr[0] + d[0];
                    int y = curr[1] + d[1];
                    // new cell is out of bounds or 0
                    if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == '0')
                        continue;
                    // new cell is in bound and 1
                    grid[x][y] = '0';
                    q.add(new int[] { x, y });
                }
            }
        }
    }
}