/**
 * 2290. Minimum Obstacle Removal to Reach Corner
 * 
 * Intuition
 * we can solve this problem through graph using shortest path algorithm
 * we can consider each cell as nodes, if cell is obstacle its weight will be 1
 * else 0
 * we will apply Dijkstra on the starting node, then for each node, weight will
 * keep increasing by 1
 * if the weight is less than already existing weight we will replace
 * After applying above, it is a graph with weighted edges and we need to find
 * shortest path between source and target.
 * 
 * Approach
 * Complexity
 * Time complexity: O(n*logn), Dijkstra
 * Space complexity: O(n), graph
 */
class Solution {
    int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int minimumObstacles(int[][] grid) {

        int m = grid.length, n = grid[0].length;

        int[][] minObstacles = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                minObstacles[i][j] = Integer.MAX_VALUE;
            }
        }

        minObstacles[0][0] = grid[0][0];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[] { minObstacles[0][0], 0, 0 });

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int obstacles = current[0], row = current[1], col = current[2];

            if (row == m - 1 && col == n - 1)
                return obstacles;

            for (int[] dir : dirs) {
                int x = row + dir[0], y = col + dir[1];

                if (x < 0 || x >= m || y < 0 || y >= n)
                    continue;
                int newObstacles = obstacles + grid[x][y];
                if (newObstacles < minObstacles[x][y]) {
                    minObstacles[x][y] = newObstacles;
                    pq.add(new int[] { newObstacles, x, y });
                }
            }
        }

        return minObstacles[m - 1][n - 1];
    }
}