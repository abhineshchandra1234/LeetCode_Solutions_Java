/**
 * 2812. Find the Safest Path in a Grid
 * 
 * Intuition
 * 
 * This is a hard problem
 * we will first find all the thiefs positions
 * Step 1 ->then we will apply multi-source BFS from all thiefs to find nearest
 * thief distance for each cell
 * Step 2 -> we will apply binary search on sf and try to find max fisible sf
 * A sf is fisible if we have a valid path from (0,0) to (n-1,n-1) cell, which
 * we will find using BFS
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n^2*logn), we are doing binary search
 * on sf and then checking valid path for sf using BFS
 * 
 * Space complexity: O(n^2), using visited array
 * 
 */
class Solution {
    int n;
    int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        n = grid.size();
        int[][] dist = new int[n][n];
        Queue<int[]> q = new LinkedList();
        boolean[][] visited = new boolean[n][n];

        // find all thiefs
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.add(new int[] { i, j });
                    visited[i][j] = true;
                }
            }
        }

        // step-1 -> find neareset thief dist for each cell
        // using multi-source BFS from thiefs
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] curr = q.poll();
                int curr_i = curr[0];
                int curr_j = curr[1];

                dist[curr_i][curr_j] = level;

                for (int[] d : dirs) {
                    int new_i = curr_i + d[0];
                    int new_j = curr_j + d[1];

                    if (new_i < 0 || new_i >= n || new_j < 0 || new_j >= n || visited[new_i][new_j])
                        continue;
                    q.add(new int[] { new_i, new_j });
                    visited[new_i][new_j] = true;
                }
            }
            level++;
        }

        // step-2 -> Apply binary search on SF
        int l = 0, r = 400;
        int res = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            // check if valid path exist for sf
            // from (0,0) to (n-1,n-1)
            if (check(dist, mid)) {
                res = mid;
                l = mid + 1;
            } else
                r = mid - 1;
        }

        return res;
    }

    boolean check(int[][] dist, int sf) {
        Queue<int[]> q = new LinkedList();
        boolean[][] visited = new boolean[n][n];

        q.add(new int[] { 0, 0 });
        visited[0][0] = true;

        // each cell value should be equal or greater than sf,
        // for valid sf
        // sf depends upon min dist or cell value from thief
        if (dist[0][0] < sf)
            return false;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] curr = q.poll();
                int curr_i = curr[0];
                int curr_j = curr[1];

                if (curr_i == n - 1 && curr_j == n - 1)
                    return true;

                for (int[] d : dirs) {
                    int new_i = curr_i + d[0];
                    int new_j = curr_j + d[1];

                    if (new_i < 0 || new_i >= n || new_j < 0 || new_j >= n || visited[new_i][new_j])
                        continue;

                    if (dist[new_i][new_j] < sf)
                        continue;
                    q.add(new int[] { new_i, new_j });
                    visited[new_i][new_j] = true;

                }
            }
        }
        return false;
    }
}