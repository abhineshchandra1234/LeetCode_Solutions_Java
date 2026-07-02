// 3286. Find a Safe Walk Through a Grid

/**
 * Intuition
 * we will use 0-1 bfs to solve this problem
 * we will traet each cell as node
 * we will have 2d array res which will represent node
 * res[i][j] will represent min cost from cell [0][0] to [i][j]
 * we will add all nodes to a deque
 * we will pop the nodes and move in all 4 dirs
 * if the cost of moving to new node is less than the exisiting cost of new node
 * we will replace the existing cost with new cost
 * if the cell is 0, we are adding it at the start of deque, so that it will be
 * computed first, we are taking min cost
 * if the cell is 1, we are adding it at the last of deque, so that it can be
 * computed last
 * At the end we are checking [m-1][n-1] node, if health - cost is greater than
 * or equal to 1 as the question demands we will return true else false
 * which means there exist a path where health is still greater than or equal to
 * 1
 * Approach
 * 
 * Complexity
 * Time complexity: O(m*n)
 * Space complexity: O(m*n)
 */

class Solution {
    int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size(), n = grid.get(0).size();

        int[][] res = new int[m][n];
        for (int[] row : res)
            Arrays.fill(row, Integer.MAX_VALUE);

        Deque<int[]> dq = new LinkedList();
        res[0][0] = grid.get(0).get(0);
        dq.addFirst(new int[] { 0, 0 });

        while (!dq.isEmpty()) {
            int[] cell = dq.removeFirst();
            int r = cell[0], c = cell[1];

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;

                if (res[r][c] + grid.get(nr).get(nc) < res[nr][nc]) {
                    res[nr][nc] = res[r][c] + grid.get(nr).get(nc);
                    if (grid.get(nr).get(nc) == 0)
                        dq.addFirst(new int[] { nr, nc });
                    else
                        dq.addLast(new int[] { nr, nc });
                }
            }
        }

        return health - res[m - 1][n - 1] >= 1;
    }
}