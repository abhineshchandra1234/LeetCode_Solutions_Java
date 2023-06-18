/**
 * 2352. Equal Row and Column Pairs
 * 
 * Intuition
 * credits rock
 * we will solve this problem using hashing. I use this technique to debug.
 * We will create a hash for each row and store it in the map
 * Then we will create a hash for each col and if that hash already exist means
 * we have duplicate row and will increase pair with hash count.
 * like - grid = [[3,2,1],[1,7,6],[2,7,7]]
 * row[2] = 2, 7, 7
 * col[1] = 2, 7, 7
 * we store hash of each row and count in map. we can have two duplicate row & 1
 * duplicate col. Then pairs will be 2.
 * eg - [[3,2,1],[2,7,7],[2,7,7]] output -> 2.
 * 
 * Complexity
 * Time complexity: O(n^2)
 * 
 * Space complexity:
 * 
 * O(n^2), if every row and col are different
 * 
 */
class Solution {
    public int equalPairs(int[][] grid) {

        Map<String, Integer> cnt = new HashMap();

        for (int[] row : grid) {
            String key = Arrays.toString(row);
            cnt.put(key, cnt.getOrDefault(key, 0) + 1);
        }

        int pairs = 0;
        for (int c = 0, n = grid.length; c < n; c++) {
            int[] col = new int[n];
            for (int r = 0; r < n; r++)
                col[r] = grid[r][c];
            pairs += cnt.getOrDefault(Arrays.toString(col), 0);
        }
        return pairs;
    }
}