// 3651. Minimum Cost Path with Teleportations

/**
 * 
 * solution to be discussed
 */

import java.util.*;

class Solution {
    public int minCost(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int INF = (int) 1e9;

        int[][] cost = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cost[i], INF);
        }

        // store all cells
        List<int[]> cells = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cells.add(new int[] { i, j });
            }
        }

        // sort cells by grid value
        cells.sort((a, b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]]);

        for (int step = 0; step <= k; step++) {

            int best = INF;

            for (int idx = 0; idx < cells.size(); idx++) {
                int r = cells.get(idx)[0];
                int c = cells.get(idx)[1];

                best = Math.min(best, cost[r][c]);

                // skip until the last cell with same value
                if (idx + 1 < cells.size()
                        && grid[r][c] == grid[cells.get(idx + 1)[0]][cells.get(idx + 1)[1]]) {
                    continue;
                }

                // propagate best cost to all equal-value cells
                int back = idx;
                while (back >= 0
                        && grid[cells.get(back)[0]][cells.get(back)[1]] == grid[r][c]) {
                    int br = cells.get(back)[0];
                    int bc = cells.get(back)[1];
                    cost[br][bc] = best;
                    back--;
                }
            }

            // DP from bottom-right
            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {

                    if (i == n - 1 && j == m - 1) {
                        cost[i][j] = 0;
                        continue;
                    }

                    if (i + 1 < n) {
                        cost[i][j] = Math.min(
                                cost[i][j],
                                cost[i + 1][j] + grid[i + 1][j]);
                    }

                    if (j + 1 < m) {
                        cost[i][j] = Math.min(
                                cost[i][j],
                                cost[i][j + 1] + grid[i][j + 1]);
                    }
                }
            }
        }

        return cost[0][0];
    }
}