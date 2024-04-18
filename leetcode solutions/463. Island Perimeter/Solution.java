/**
 * 463. Island Perimeter
 * 
 * Intuition
 * 
 * perimeter will be island count * 4
 * If there is a neigh 2 connecting edges will be merged
 * To avoid repetition of neighs among each other we will consider only top or
 * down and left or right neighs
 * Total perimeter = island * 4 - neigh * 2
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int islandPerimeter(int[][] grid) {

        int island = 0, neigh = 0;
        int n = grid.length, m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    island++;
                    // down neigh
                    if (i < n - 1 && grid[i + 1][j] == 1)
                        neigh++;
                    // right neigh
                    if (j < m - 1 && grid[i][j + 1] == 1)
                        neigh++;
                }
            }
        }

        return island * 4 - neigh * 2;
    }
}
