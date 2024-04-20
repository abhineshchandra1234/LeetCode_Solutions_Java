/**
 * 1992. Find All Groups of Farmland
 * 
 * Intuition
 * 
 * we can solve this problem through dfs or bfs
 * To reduce complexity solved it through greedy
 * we will traverse through matrix, if we found water we will skip it
 * If we found land we find its farthest column using col ptr and farthest row
 * using ro ptr
 * Then we will add 4 coordinates to res
 * Then we will mark the whole group as water or 0 using 4 coordinates, to avoid
 * repetition
 * 
 * Approach
 * 
 * we have marked group water after calculating farthest row and col, if we had
 * done it simultaneously it would have given error for next computation.
 * we have used a list of int array, as we cannot convert list of Integer object
 * to int array
 * 
 * Complexity
 * 
 * Time complexity: O(m∗n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int[][] findFarmland(int[][] land) {

        int n = land.length;
        int m = land[0].length;

        List<int[]> res = new ArrayList();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 0)
                    continue;

                int c = j;
                while (c < m && land[i][c] == 1)
                    c++;

                int r = i;
                while (r < n && land[r][j] == 1)
                    r++;

                c = c == 0 ? c : c - 1;
                r = r == 0 ? r : r - 1;

                res.add(new int[] { i, j, r, c });

                for (int k = i; k <= r; k++)
                    for (int l = j; l <= c; l++)
                        land[k][l] = 0;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}